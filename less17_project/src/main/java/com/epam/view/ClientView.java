package com.epam.view;

import com.epam.controller.iml.AccountControllerIml;
import com.epam.controller.iml.BankControllerIml;
import com.epam.controller.iml.ClientControllerIml;
import com.epam.controller.iml.TransactionControllerIml;
import com.epam.model.account.MainAccount;
import com.epam.model.account.type.TypeAccount;
import com.epam.model.authorization.Authorization;
import com.epam.model.bank.CustomBank;
import com.epam.model.bank.GeneralBank;
import com.epam.model.client.Client;
import com.epam.model.transaction.Transaction;
import com.epam.services.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.*;

public class ClientView {
	private static final Logger logger = LogManager.getLogger(ClientView.class);
	private Map<String, String> menu;
	private Map<String, Printable> methodsMenu;
	private static Scanner input = new Scanner(System.in);
	private Client client;
	private List<MainAccount> accountList;

	public ClientView(Authorization authorization) {
		this.accountList = new LinkedList<>();
		this.client = authorization.getClient();
		menu = new LinkedHashMap<>();
		methodsMenu = new LinkedHashMap<>();
		menu.put("1", "   1 - Select all accounts");
		menu.put("2", "   2 - Create an account");
		menu.put("3", "   3 - Get personal information");
		menu.put("4", "   4 - Update personal information");
		menu.put("5", "   5 - Send money");
		menu.put("Q", "   Q - Log Out");

		methodsMenu.put("1", this::selectAllAccounts);
		methodsMenu.put("2", this::createAccount);
		methodsMenu.put("3", this::getClientInfo);
		methodsMenu.put("4", this::updateClientInfo);
		methodsMenu.put("5", this::sendMoney);

	}

	private void updateClientInfo() {
		logger.info("Enter client surname:");
		String surname = new Scanner(System.in).nextLine();
		logger.info("Enter client name:");
		String name = new Scanner(System.in).nextLine();
		logger.info("Enter client city:");
		String city = new Scanner(System.in).nextLine();
		logger.info("Enter client email:");
		String email = new Scanner(System.in).nextLine();
		logger.info("Enter client password:");
		String password = new Scanner(System.in).nextLine();
		logger.info("Enter client question to reset password:");
		String questionToReset = new Scanner(System.in).nextLine();
		logger.info("Enter client answer from question:");
		String answerToReset = new Scanner(System.in).nextLine();
		Client newClient = new Client(client.getIDClient(),surname, name, city, email,
				password, questionToReset, answerToReset,client.getIDBank());
		new ClientControllerIml().update(newClient);
	}

	private void getClientInfo() {
		client = new ClientControllerIml().getById(client.getIDClient());
		logger.info(client);
	}

	private void createAccount() {
		List<TypeAccount> typeAccounts = new AccountControllerIml().find();
		logger.info(typeAccounts);
		logger.info("Choose Id of type which you want :");
		int idtype = new Scanner(System.in).nextInt();
		TypeAccount typeAccount = new AccountControllerIml().findByID(idtype);
		logger.info("Enter amount:");
		int amount = new Scanner(System.in).nextInt();

		int id = new BankControllerIml().getById(client.getIDBank()).getIdBank();
		String name = new BankControllerIml().getById(client.getIDBank()).getName();
		String city = new BankControllerIml().getById(client.getIDBank()).getCity();
		GeneralBank generalBank = new CustomBank(id,name,city);
		MainAccount account = generalBank.create(typeAccount,amount, client);
		new AccountControllerIml().create(account);
		logger.info(account);
	}

	private void selectAllAccounts() {
		this.accountList = new AccountControllerIml().findAllByID(client.getIDClient());
		logger.info(accountList);
	}

	private void sendMoney() {
		logger.info("Enter amount of money which you want to send:");
		double money = new Scanner(System.in).nextInt();
		logger.info("Enter id of your account:");
		int id_from_account = new Scanner(System.in).nextInt();
		logger.info("Enter id of client account:");
		int id_to_account = new Scanner(System.in).nextInt();
		MainAccount account_to = new AccountControllerIml().getById(id_to_account);
		MainAccount account_from  = Utils.getElements(accountList,id_from_account);
		Transaction transaction = new AccountControllerIml().sendMoney(account_from,account_to,money);
		if(transaction == null){
			transaction = new Transaction(account_from.getIDClient(), account_from.getIDAccount(),
					account_to.getIDClient(), account_to.getIDAccount(), money, false);
		}
		new TransactionControllerIml().create(transaction);
		if(transaction.isSuccess()){
			logger.info("Transaction success!");
		}else {
			logger.info("Transaction failed!");
		}
	}

	private void outputMenu() {
		logger.info("Cabinet of " + client.getName());
		logger.info("\nMENU:");
		for (String key : menu.keySet()) {
			logger.info(menu.get(key));
		}
	}

	public void show() {
		String keyMenu;
		do {
			outputMenu();
			keyMenu = input.nextLine().toUpperCase();
			try {
				methodsMenu.get(keyMenu).print();
			} catch (Exception e) {
				logger.error(e);
			}
		} while (!keyMenu.equals("Q"));
	}
}
