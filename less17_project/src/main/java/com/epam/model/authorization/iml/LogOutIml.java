package com.epam.model.authorization.iml;

import com.epam.model.authorization.Authorization;
import com.epam.model.authorization.State;

public class LogOutIml implements State {

	@Override
	public void logIn(Authorization authorization) {
		System.out.println("Wrong email or password!");
	}

	@Override
	public void logOut(Authorization authorization) {
		System.out.println("Log out!");
	}
}
