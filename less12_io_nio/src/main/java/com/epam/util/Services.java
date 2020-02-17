package com.epam.util;

import com.epam.Application;
import com.epam.model.Droids;
import com.epam.model.Ship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.*;

public class Services {
    private static final Logger logger = LogManager.getLogger(Application.class);
    private static final File file = new File(Services.class.getClassLoader().getResource("testFiles/file.txt").getFile());

    public static void writeFile(List list) {
        try (
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            objectOutputStream.writeObject(list);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static List<Droids> readFile() {
        List<Droids> droidsList = new LinkedList<>();
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            droidsList = (List<Droids>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }
        return droidsList;
    }

    public static void readBufferdFile() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            try {
                while (in.available() > 0) {
                    in.readByte();
                }
            } catch (EOFException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public static void readBufferdFile(int sizeMb) {
        sizeMb = sizeMb * 1024 * 1024;
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file), sizeMb))) {
            while (in.available() > 0) {
                in.readByte();
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public static void generalisableFile(Ship ship, int res) {
        ship.generateArmy(res);
        writeFile(ship.getDroidsList());
        logger.info(getSizeMb());
        if (Services.getSizeMb() < 15) {
            generalisableFile(ship, ship.getCountOfDroids() * 1000);
        }
    }

    public static int getSizeMb() {
        return (int) file.length() / (1024 * 1024);
    }

    public static void push() {
        List list = new ArrayList();
        byte[] first_input = new byte[]{'1', '2', '3', '4', '5', '6', '7'};
        InputStream inputStream = new ByteArrayInputStream(first_input);
        PushbackInputStream pushbackInputStream =
                new PushbackInputStream(inputStream, 10);
        try {
            int data = pushbackInputStream.read();
            while (data != -1) {
                data = pushbackInputStream.read();
                list.add(data);
            }
            logger.info(list);
            byte[] second_input = new byte[]{'8', '9', '1'};
            pushbackInputStream.unread(second_input);
            for (int i = 0; i < second_input.length; i++) {
                list.add(pushbackInputStream.read());
            }
            logger.info(list);
        } catch (IOException ex) {
            logger.error(ex);
        } finally {
            try {
                inputStream.close();
                pushbackInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readSourceCode() {
        File paths = new File(Objects.requireNonNull(Services.class.getClassLoader()
                .getResource("testFiles/test.java")).getFile());
        BufferedReader br;
        String curline;
        try {
            br = new BufferedReader(new FileReader(String.valueOf(paths)));

            while ((curline = br.readLine()) != null) {
                if (curline.contains("//")) {
                    logger.info(curline.substring(curline.indexOf("//")));
                }
                if (curline.contains("/*")) {
                    logger.info(curline.substring(curline.indexOf("/*")));
                }
                if (curline.contains("*")) {
                    logger.info(curline.substring(curline.indexOf("*")));
                }
                System.out.println(curline);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getDirectory(File dir,String path) {
        File[] children = dir.listFiles();
        if (children != null)  {
            for (int i = 0; i < children.length; i++) {
                if (children[i].isDirectory()) {
                    path +="\\" + children[i].getName();
                    getDirectory(children[i],path);
                } else if (children[i].isDirectory() && (i < children.length - 1)) {
                    path +="\\" + children[i].getName();
                    getDirectory(children[i + 1],path);
                } else {
                    logger.info(path + children[i].getName());
                }
            }
        }
    }

    public static String getPath(String directionInResources ){
        return Services.class.getClassLoader().getResource(directionInResources).getPath();
    }
}
