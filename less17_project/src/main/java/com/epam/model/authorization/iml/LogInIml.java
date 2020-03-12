package com.epam.model.authorization.iml;

import com.epam.model.authorization.Authorization;
import com.epam.model.authorization.State;

public class LogInIml implements State {
	@Override
	public void logIn(Authorization authorization) {
		System.out.println("Successful Log in!");
	}
}
