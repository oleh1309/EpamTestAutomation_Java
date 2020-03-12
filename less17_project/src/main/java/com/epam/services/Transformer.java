package com.epam.services;

import com.epam.controller.iml.AccountControllerIml;
import com.epam.model.account.MainAccount;
import com.epam.model.account.factory.CreditMainAccount;
import com.epam.model.account.factory.DebutMainAccount;
import com.epam.model.account.factory.DepositMainAccount;
import com.epam.model.account.type.AccountType;
import com.epam.model.account.type.TypeAccount;
import com.epam.model.annotation.Column;
import com.epam.model.bank.GeneralBank;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Transformer<T> {
	private final Class<T> clazz;

	public Transformer(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Object fromResultSetToEntity(ResultSet rs)
			throws SQLException {
		//create new object
		Object entity = null;
		ResultSetMetaData rsMetaData = rs.getMetaData();

		try {
			if (clazz.equals(MainAccount.class)) {
				entity = getAccount(rs).newInstance();
			} else {
				entity = clazz.getDeclaredConstructor().newInstance();
			}

			List<Field> fields = null;
			if (GeneralBank.class.isAssignableFrom(clazz)) {
				fields = Arrays.asList(clazz.getSuperclass().getDeclaredFields());
			} else {
				fields = Arrays.asList(clazz.getDeclaredFields());
			}
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
						if (column.name().equalsIgnoreCase(rsMetaData.getColumnName(i))) {
							field.set(entity, rs.getObject(i));
						}
					}
				}
			}
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return entity;
	}

	public Constructor getAccount(ResultSet rs) throws SQLException, NoSuchMethodException {
		Constructor constructor = null;
		int id = rs.getInt(3);
		TypeAccount newType = new AccountControllerIml().findByID(id);
		if (newType.getTypeName().equals(AccountType.CREDIT_LIGHT.toString()) ||
				newType.getTypeName().equals(AccountType.CREDIT_MEDIUM.toString())) {
			constructor = CreditMainAccount.class.getDeclaredConstructor();
		} else if (newType.getTypeName().equals(AccountType.DEBIT_LIGHT.toString()) ||
				newType.getTypeName().equals(AccountType.DEBIT_MEDIUM.toString())) {
			constructor = DebutMainAccount.class.getDeclaredConstructor();
		} else if (newType.getTypeName().equals(AccountType.DEPOSIT_LIGHT.toString()) ||
				newType.getTypeName().equals(AccountType.DEPOSIT_MEDIUM.toString())) {
			constructor = DepositMainAccount.class.getDeclaredConstructor();
		}
		return constructor;
	}

}
