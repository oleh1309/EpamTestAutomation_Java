package com.epam.task2.state.iml;

import com.epam.task2.Sprint;
import com.epam.task2.state.State;

public class ReviewState implements State {

    @Override
    public void inProgress(Sprint sprint) {
        sprint.setState(new InProgressState());
        System.out.println("Task in progress!!!");
    }

    @Override
    public void inTest(Sprint sprint) {
        sprint.setState(new InTestState());
        System.out.println("Task in test!!!");
    }

    @Override
    public void blocked(Sprint sprint) {
        sprint.setState(new BlockedState());
        System.out.println("Task is blocked");
    }
}
