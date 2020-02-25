package com.epam.task2.state.iml;

import com.epam.task2.Sprint;
import com.epam.task2.state.State;

public class AddSprintTaskState implements State {

    @Override
    public void addSprintBacklog(Sprint sprint) {
        sprint.addTask();
        System.out.println("Add task");
    }

    @Override
    public void inProgress(Sprint sprint) {
        sprint.setState(new InProgressState());
        System.out.println("Task in progress!!!");
    }

    @Override
    public void blocked(Sprint sprint) {
        sprint.setState(new BlockedState());
        System.out.println("Task is blocked");
    }

}
