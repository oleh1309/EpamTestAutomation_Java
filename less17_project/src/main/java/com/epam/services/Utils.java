package com.epam.services;

import com.epam.model.account.MainAccount;

import java.util.List;

public class Utils {

	public static MainAccount getElements(List<MainAccount> list, int id){
		return list.stream().filter(a-> a.getIDAccount()==id).findAny().orElse(null);
	}
}
