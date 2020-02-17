package com.epam.model;

import com.epam.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CustomBufferClass {
    private static final Logger logger = LogManager.getLogger(CustomBufferClass.class);

    public static void writeFile(Path filePath){
        String input = "Let us go and eat!";
        logger.info("Text written to file [" + filePath.getFileName() + "]: " + input);
        byte[] inputBytes = input.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.wrap(inputBytes);
        FileChannel writeChannel = null;
        try {
            writeChannel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            writeChannel.write(writeBuffer);
            writeChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(Path filePath) {
        FileChannel readChannel = null;
        try {
            readChannel = FileChannel.open(filePath);
            ByteBuffer readBuffer = ByteBuffer.allocate(24);
            readChannel.read(readBuffer);
            byte[] bytes = readBuffer.array();
            String output = new String(bytes).trim();
            logger.info("Text read from file [" + filePath.getFileName() + "]: " + output);
            readChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
