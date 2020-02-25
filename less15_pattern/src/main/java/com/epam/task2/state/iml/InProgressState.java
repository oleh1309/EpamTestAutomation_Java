package com.epam.task2.state.iml;

import com.epam.task2.Sprint;
import com.epam.task2.state.State;

public class InProgressState implements State {

    @Override
    public void addSprintBacklog(Sprint sprint) {
        sprint.setState(new AddSprintTaskState());
        System.out.println("Add more tasks");
    }

    @Override
    public void review(Sprint sprint) {
        sprint.setState(new ReviewState());
        System.out.println("Task is reviewing now!!!");
    }

    @Override
    public void blocked(Sprint sprint) {
        sprint.setState(new BlockedState());
        System.out.println("Task is blocked");
    }


}
