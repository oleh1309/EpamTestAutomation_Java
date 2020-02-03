package com.epam.task_2.command;

public class FileClose implements Printable {
    private File file;

    public FileClose(File file) {
        this.file = file;
    }

    @Override
    public String print(String value) {
        return file.closeFile(value);
    }
}
