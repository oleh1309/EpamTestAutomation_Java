package com.epam.view;

import com.epam.model.CustomBufferClass;
import com.epam.model.Ship;
import com.epam.model.client_server.Client;
import com.epam.model.client_server.Server;
import com.epam.util.Services;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TaskView {
    private static final Logger logger = LogManager.getLogger(TaskView.class);
    private Map<String, String> menu;
    private Map<String, Printable> menubar;
    private Ship ship;
    private boolean result;

    public TaskView() {
        ship = new Ship();
        menu = new LinkedHashMap<>();
        menu.put("1", "Task 2 Create Ship with Droids. Serialize and deserialize them. Use transient.");
        menu.put("2", "Task 3. Compare reading and writing performance of usual and buffered reader for\n" +
                "200 MB file. Compare performance of buffered reader with different buffer\n" +
                "size (e.g. 10 different size).");
        menu.put("3", "Task 4. Write your implementation of InputStream with capability of push read data\n" +
                "back to the stream.");
        menu.put("4", "Task 5. Write a program that reads a Java source-code file (you provide the file\n" +
                "name on the command line) and displays all the comments. Do not use\n" +
                "regular expression.");
        menu.put("5", "Task 6. Write a program that displays the contents of a specific directory (file and\n" +
                "folder names + their attributes) with the possibility of setting the current\n" +
                "directory (similar to “dir” and “cd” command line commands).");
        menu.put("6", "Task 7. Try to create SomeBuffer class, which can be used for read and write data\n" +
                "from/to channel (Java NIO)");
        menu.put("7", "Task 8. Write client-server program using NIO (+ if you want, other implementation\n" +
                "using IO). E.g. you have one server and multiple clients. A client can send\n" +
                "direct messages to other client.");
        menu.put("Q", "Exit");

        menubar = new LinkedHashMap<>();
        menubar.put("1", this::getSerializeShip);
        menubar.put("2", this::getCompareOfReadingWriting);
        menubar.put("3", this::getPushBack);
        menubar.put("4", this::getReadingSourceCode);
        menubar.put("5", this::getDirFromInput);
        menubar.put("6", this::getCustomBufferClass);
        menubar.put("7", this::getClientServerApp);
    }


    private void getSerializeShip() {
        logger.info("Writing objects...");
        logger.info(ship);
        Services.writeFile(ship.getDroidsList());
        logger.info("Reading objects...");
        logger.info(Services.readFile());
    }

    private void getCompareOfReadingWriting() {
        getPerformanceWriting(ship);
        getPerformanceReading();
        result = true;
    }

    private void getPushBack() {
        Services.push();
    }

    private void getReadingSourceCode() {
        Services.readSourceCode();
    }

    private void getDirFromInput() {
        logger.info("Please enter the directory which you want to discover:");
        File file = new File(new Scanner(System.in).nextLine());
        Services.getDirectory(file, "");
    }

    private void getCustomBufferClass() {
        Path newfile = Paths.get(Services.getPath("testFiles/testfile_task7.txt").substring(1));
        CustomBufferClass.writeFile(newfile);
        CustomBufferClass.readFile(newfile);
    }

    private void printMenu() {
        menu.forEach((a, b) -> System.out.println(a + " - " + b));
    }

    private void getClientServerApp() {
        Server server1 = null;
        Client client1 = null;

        try {
            server1 = new Server(8090);
            client1 = new Client("127.0.0.1", 8090);
            client1.connect();
            server1.connect();

        } catch (IOException e) {
            logger.error(e);
        }
        getCommunity(server1,client1);
//        server1.write("Blalal");
//        logger.info(client1.read());
//        client1.write("Bioio");
//        logger.info(server1.read());
    }

    private void getCommunity(Server server, Client client) {
        String msg = "";
        do {
            logger.info("Write msg from server to client...");
            msg = new Scanner(System.in).nextLine();
            if (!msg.equals("Q".toLowerCase())) {
                server.write(msg);
                client.read();
            }else {
                break;
            }
            logger.info("Write msg from client to server...");
            msg = new Scanner(System.in).nextLine();
            if (!msg.equals("Q".toLowerCase())) {
                client.write(msg);
                server.read();
            }else{
                break;
            }
        } while (!msg.equals("Q".toLowerCase()));
        logger.info("[Closing client-server community...]");
        client.close();
        server.close();
    }

    public void show() {
        String keyMenu;
        do {
            printMenu();
            logger.info("Please, select menu point.");
            keyMenu = new Scanner(System.in).nextLine().toUpperCase();
            try {
                menubar.get(keyMenu).print();
            } catch (Exception e) {
                logger.error(e);
            }
        } while (!keyMenu.equals("Q"));
    }

    private void getPerformanceWriting(Ship ship) {
        StopWatch stopWatch;
        stopWatch = StopWatch.createStarted();
        Services.generalisableFile(ship, ship.getCountOfDroids());
        stopWatch.stop();
        logger.info("Performance of writing objects \nTime: [" +
                stopWatch.getTime(TimeUnit.MILLISECONDS) + "]");
    }

    private void getPerformanceReading() {
        StopWatch stopWatch;
        logger.info("Performance of usual reading objects");
        stopWatch = StopWatch.createStarted();
        logger.info(Services.readFile());
        stopWatch.stop();
        logger.info("\nTime: [" +
                stopWatch.getTime(TimeUnit.MILLISECONDS) + "]");

        logger.info("Performance of buffer reading objects");
        stopWatch = StopWatch.createStarted();
        Services.readBufferdFile();
        stopWatch.stop();
        logger.info("\nTime: [" +
                stopWatch.getTime(TimeUnit.MILLISECONDS) + "]");
        logger.info("Performance of buffer reading objects by size");
        stopWatch = StopWatch.createStarted();
        Services.readBufferdFile(2);
        stopWatch.stop();
        logger.info("\nTime: [" +
                stopWatch.getTime(TimeUnit.MILLISECONDS) + "]");
    }


}
