package com.epam.task2.state;

import com.epam.task2.Sprint;

public interface State {

    default void addSprintBacklog(Sprint sprint) {
        System.out.println("addProduct - is not allowed");
    }

    default void inProgress(Sprint sprint) {
        System.out.println("register - is not allowed");
    }

    default void review(Sprint sprint) {
        System.out.println("grant - is not allowed");
    }

    default void inTest(Sprint sprint) {
        System.out.println("invoice - is not allowed");
    }

    default void done(Sprint sprint) {
        System.out.println("ship - is not allowed");
    }

    default void blocked(Sprint sprint) {
        System.out.println("cancel - is not allowed");
    }
}
