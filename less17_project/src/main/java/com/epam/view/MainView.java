package com.epam.view;

import com.epam.controller.iml.BankControllerIml;
import com.epam.controller.iml.ClientControllerIml;
import com.epam.model.authorization.Authorization;
import com.epam.model.bank.GeneralBank;
import com.epam.model.client.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainView {
	private static final Logger logger = LogManager.getLogger(MainView.class);
	private Map<String, String> menu;
	private Map<String, Printable> methodsMenu;
	private static Scanner input = new Scanner(System.in);

	public MainView() {

		menu = new LinkedHashMap<>();
		methodsMenu = new LinkedHashMap<>();
		menu.put("A", "   A - Select all Banks");
        menu.put("B", "   B - Registration");
		menu.put("C", "   C - Log In");
		menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllBanks);
        methodsMenu.put("B", this::createClient);
		methodsMenu.put("C", this::enterInCabinet);

	}

	private void enterInCabinet() {
		logger.info("Set email:");
		String email = new Scanner(System.in).nextLine();
		logger.info("Set password:");
		String password = new Scanner(System.in).nextLine();
		Authorization newAuthorize = new Authorization(email,password);
		if(newAuthorize.isAuthorize()){
			new ClientView(newAuthorize).show();
		}
	}

	public void selectAllBanks(){
		logger.info("\nTable: Bank");
		List<GeneralBank> departments = new BankControllerIml().getAll();
		for (GeneralBank entity : departments) {
			logger.info(entity);
		}
	}

	public void createClient() {
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
		selectAllBanks();
		logger.info("Enter bankID which you want to use:");
		int bankID = new Scanner(System.in).nextInt();
		Client newClient = new Client(surname, name, city, email, password, questionToReset, answerToReset,bankID);
		new ClientControllerIml().create(newClient);
		logger.info(newClient);
	}

	private void outputMenu() {
		logger.info("\nMENU:");
		for (String key : menu.keySet())
			if (key.length() == 1) {
				logger.info(menu.get(key));
			}
	}

	private void outputSubMenu(String fig) {
		logger.info("\nSubMENU:");
		for (String key : menu.keySet())
			if (key.length() != 1 && key.substring(0, 1).equals(fig)) logger.info(menu.get(key));
	}

	public void show() {
		String keyMenu;
		do {
			outputMenu();
			logger.info("Please, select menu point.");
			keyMenu = input.nextLine().toUpperCase();
			if (keyMenu.matches("^\\d")) {
				outputSubMenu(keyMenu);
				logger.info("Please, select menu point.");
				keyMenu = input.nextLine().toUpperCase();
			}
			try {
				methodsMenu.get(keyMenu).print();
			} catch (Exception e) {
				logger.error(e);
			}
		} while (!keyMenu.equals("Q"));
	}
}
