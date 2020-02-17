package com.epam.model.client_server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private static final Logger logger = LogManager.getLogger(Server.class);
    private ServerSocket socket;
    private Socket listener;

    public Server(int port) {
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void connect() throws IOException {
        logger.info(socket.getLocalSocketAddress());
        listener = socket.accept();
    }

    public void read() {
        byte[] temp = new byte[1024];
        int bytesRead = 0;
        try {
            InputStream input = listener.getInputStream();
            bytesRead = input.read(temp);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String res = new String(temp, 0, bytesRead, StandardCharsets.US_ASCII);
        logger.info( "[Server read request from client... " + res + " ]");
    }

    public void write(String data) {
        try {
            OutputStream out = listener.getOutputStream();
            out.write(data.getBytes());
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            logger.info("Closing server...");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

