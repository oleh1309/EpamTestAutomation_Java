package com.epam.task_2.command;

public class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String openFile(String comments){
        return this.name  + " is open!!! " + comments;
    }
    public String closeFile(String comments){
        return this.name  + " is close!!! " + comments;
    }
    public String writeFile(String comments){
        return this.name  + " is write!!! " + comments;
    }
    public String deleteFile(String comments){
        return this.name  + " is removed!!! " + comments;
    }
}
