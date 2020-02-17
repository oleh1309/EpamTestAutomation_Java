package com.epam.model.client_server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client{
    private static final Logger logger = LogManager.getLogger(Client.class);
    private Socket client;
    private InetSocketAddress address;

    public Client(String ip, int port) {
        this.client = new Socket();
        this.address = new InetSocketAddress(ip, port);
    }

    public void connect() throws IOException {
        logger.info(address.getHostName());
        client.connect(address);
    }

    public void read(){
        byte[] temp = new byte[1024];
        int bytesRead = 0;
        try {
            InputStream input = client.getInputStream();
            bytesRead = input.read(temp);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        //return new String(temp, 0, bytesRead, StandardCharsets.US_ASCII);
        String res = new String(temp, 0, bytesRead, StandardCharsets.US_ASCII);
        logger.info("[Client read response from server... " + res + " ]");
    }

    public void write(String data){
        try {
            OutputStream out = client.getOutputStream();
            out.write(data.getBytes());
            out.flush();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void close(){
        try {
            logger.info("Closing client...");
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

