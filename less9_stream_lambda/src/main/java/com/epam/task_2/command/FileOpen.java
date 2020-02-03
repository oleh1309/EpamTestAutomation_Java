package com.epam.task_2.command;

public class FileOpen implements Printable{
    private File file;

    public FileOpen(File file) {
        this.file = file;
    }

    @Override
    public String print(String value) {
        return file.openFile(value);
    }
}
