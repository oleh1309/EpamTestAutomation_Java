package com.epam.model.authorization;

public interface State {

	default void logIn(Authorization authorization){};
	default void logOut(Authorization authorization){};

}
