package com.epam.task2.state.iml;

import com.epam.task2.Sprint;
import com.epam.task2.state.State;

public class InTestState implements State {

    @Override
    public void inProgress(Sprint sprint) {
        sprint.setState(new InProgressState());
        System.out.println("Task in progress!!!");
    }

    @Override
    public void review(Sprint sprint) {
        sprint.setState(new ReviewState());
        System.out.println("Task is reviewing now!!!");
    }

    @Override
    public void done(Sprint sprint){
        sprint.setState(new DoneState());
        System.out.println("Task is done!!!");
    }

    @Override
    public void blocked(Sprint sprint) {
        sprint.setState(new BlockedState());
        System.out.println("Task is blocked");
    }
}
