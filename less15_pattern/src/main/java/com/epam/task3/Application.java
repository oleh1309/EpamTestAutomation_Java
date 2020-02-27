package com.epam.task3;

import com.epam.task3.clientFactory.Client;
import com.epam.task3.clientFactory.ClientInStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
        List<String> flowerTypeList = new LinkedList<>();
        flowerTypeList.add(FlowerType.CHRYSANTHEMUM.toString());
        flowerTypeList.add(FlowerType.CHRYSANTHEMUM.toString());
        flowerTypeList.add(FlowerType.CHRYSANTHEMUM.toString());
        flowerTypeList.add(FlowerType.CHRYSANTHEMUM.toString());
        flowerTypeList.add(FlowerType.ROSE.toString());
        flowerTypeList.add(FlowerType.ROSE.toString());
        flowerTypeList.add(FlowerType.ROSE.toString());
        flowerTypeList.add(FlowerType.ROSE.toString());
        flowerTypeList.add(FlowerType.ROSE.toString());
        flowerTypeList.add(FlowerType.ROSE.toString());
        flowerTypeList.add(FlowerType.ORCHIDS.toString());
        flowerTypeList.add(FlowerType.ORCHIDS.toString());

        Client client = new ClientInStore("Oleh");
        client.orderFromCatalog(TypeOfFlowers.SAINT_VALENTINES_DAY, TypeOfDelivery.STANDARD);
        client.orderFromCatalog(TypeOfFlowers.WEDDING, TypeOfDelivery.EXPRESS);
        client.orderFromCatalog(TypeOfFlowers.FUNERAL, TypeOfDelivery.STANDARD);
        client.orderFromCatalog(TypeOfFlowers.BIRTHDAY, TypeOfDelivery.EXPRESS);
        logger.info(client);

        Client client_Igor = new ClientInStore("Igor");
        client_Igor.order(TypeOfFlowers.SAINT_VALENTINES_DAY, TypeOfDelivery.STANDARD,flowerTypeList);
        client_Igor.orderFromCatalog(TypeOfFlowers.WEDDING, TypeOfDelivery.EXPRESS);
        client_Igor.order(TypeOfFlowers.FUNERAL, TypeOfDelivery.STANDARD,flowerTypeList);
        client_Igor.orderFromCatalog(TypeOfFlowers.BIRTHDAY, TypeOfDelivery.EXPRESS);
        logger.info(client_Igor);
    }
}
