package com.epam.task2;

import com.epam.task2.state.State;
import com.epam.task2.state.iml.AddSprintTaskState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Sprint {
    private static final Logger logger = LogManager.getLogger(Sprint.class);
    private State state;
    private List<Task> sprintTasks;
    private List<Task> mainList;


    public Sprint(List<Task> mainList) {
        sprintTasks = new LinkedList<>();
        this.mainList = mainList;
        state = new AddSprintTaskState();
    }

    public void addSprintBacklog(){
        state.addSprintBacklog(this);
    }

    public void inProgress() {
        if (sprintTasks.isEmpty()) {
            System.out.println("TaskList is empty!");
        } else {
            state.inProgress(this);
        }
    }

    public void review() {
        state.review(this);
    }

    public void inTest() {
        state.inTest(this);
    }

    public void done() {
        state.done(this);
    }

    public void blocked() {
        state.blocked(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addTask() {
        logger.info("Choose task which you want to add ");
        int count = 0;
        for (Task t : mainList) {
            logger.info(++count + " " + t);
        }
        int res = 0;
        do {
            logger.info("Enter valid number from 1 - " + mainList.size());
            res = new Scanner(System.in).nextInt();
        } while (res > mainList.size());
        sprintTasks.add(mainList.get(res-1));
    }

    public void getList() {
        logger.info(sprintTasks);
    }
}
