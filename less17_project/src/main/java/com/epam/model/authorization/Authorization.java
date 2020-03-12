package com.epam.model.authorization;

import com.epam.controller.iml.ClientControllerIml;
import com.epam.model.authorization.iml.LogInIml;
import com.epam.model.authorization.iml.LogOutIml;
import com.epam.model.client.Client;

import java.sql.SQLException;

public class Authorization {
	private Client client;
	private State state;
	private String email;
	private String password;
	private static boolean ifAuthorize;

	public Authorization(String email, String password){
		this.email = email;
		this.password = password;
		checking();
	}

	private void checking(){
		this.client = new ClientControllerIml().getByEmailPassword(email, password);
		if(client != null){
			state = new LogInIml();
			state.logIn(this);
			ifAuthorize = true;
		}else {
			state =new LogOutIml();
			state.logIn(this);
			ifAuthorize = false;
		}
	}

	public void logOut() {
		state =new LogOutIml();
		state.logOut(this);
		ifAuthorize = false;
	}

	public boolean isAuthorize() {
		return ifAuthorize;
	}

	public Client getClient() {
		return client;
	}
}
