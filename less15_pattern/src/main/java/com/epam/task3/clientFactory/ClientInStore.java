package com.epam.task3.clientFactory;

import com.epam.task3.TypeOfDelivery;
import com.epam.task3.TypeOfFlowers;
import com.epam.task3.decorate.FlowersDecorator;
import com.epam.task3.decorate.iml.*;
import com.epam.task3.flowers.Flowers;
import com.epam.task3.flowers.iml.*;

import java.util.List;

public class ClientInStore extends Client {


    public ClientInStore(String name) {
        super(name);
    }

    @Override
    protected Flowers createFlower(TypeOfFlowers type, List<String> list) {
        Flowers flowers = null;
        if(!list.isEmpty()){
           flowers = new FlowersByYourSelf(list,type);
        }
        return flowers;
    }

    @Override
    protected Flowers getFlowerFromCatalog(TypeOfFlowers type) {
        Flowers flowers = null;
        if (type.equals(TypeOfFlowers.BIRTHDAY)) {
            flowers = new FlowersForBirthday();
        } else if (type.equals(TypeOfFlowers.FUNERAL)) {
            flowers = new FlowersForFuneral();
        } else if (type.equals(TypeOfFlowers.SAINT_VALENTINES_DAY)) {
            flowers = new FlowersForLovers();
        } else if (type.equals(TypeOfFlowers.WEDDING)) {
            flowers = new FlowersForWedding();
        }
        return flowers;
    }

    @Override
    protected FlowersDecorator createFlowersDecorator(Flowers flower, TypeOfDelivery typeOfDelivery, Client client) {
        FlowersDecorator fullDecoration = null;
        if (flower.getType().equals(TypeOfFlowers.WEDDING)) {
            FlowersDecorator paper = new PaperWrappingForFlowers();
            FlowersDecorator delivery = getDelivery(typeOfDelivery, client);
            paper.setFlowers(flower);
            delivery.setFlowers(paper);
            if (client.isDiscount()||client.isSocialCard()) {
                fullDecoration = getPromotionalOffer(client, delivery);
            } else {
                fullDecoration = delivery;
            }
        } else if (flower.getType().equals(TypeOfFlowers.SAINT_VALENTINES_DAY)) {
            FlowersDecorator oilclothPaper = new OilclothWrappingForFlowers();
            FlowersDecorator delivery = getDelivery(typeOfDelivery, client);
            oilclothPaper.setFlowers(flower);
            delivery.setFlowers(oilclothPaper);
            if (client.isDiscount()||client.isSocialCard()) {
                fullDecoration = getPromotionalOffer(client, delivery);
            } else {
                fullDecoration = delivery;
            }
        } else if (flower.getType().equals(TypeOfFlowers.BIRTHDAY)) {
            FlowersDecorator oilclothPaper = new OilclothWrappingForFlowers();
            oilclothPaper.setFlowers(flower);
            FlowersDecorator delivery = getDelivery(typeOfDelivery, client);
            delivery.setFlowers(oilclothPaper);
            if (client.isDiscount()||client.isSocialCard()) {
                fullDecoration = getPromotionalOffer(client, delivery);
            } else {
                fullDecoration = delivery;
            }
        } else if (flower.getType().equals(TypeOfFlowers.FUNERAL)) {
            FlowersDecorator delivery = getDelivery(typeOfDelivery, client);
            delivery.setFlowers(flower);
            if (client.isDiscount()||client.isSocialCard()) {
                fullDecoration = getPromotionalOffer(client, delivery);
            } else {
                fullDecoration = delivery;
            }
        }
        return fullDecoration;
    }

    private FlowersDecorator getDelivery(TypeOfDelivery typeOfDelivery, Client client) {
        FlowersDecorator delivery = null;
        if (typeOfDelivery.equals(TypeOfDelivery.STANDARD)) {
            Delivery deliv = new Delivery(client.isGoldCard());
            delivery = deliv;
        } else {
            ExpressDelivery deliv = new ExpressDelivery(client.isGoldCard());
            delivery = deliv;
        }
        return delivery;
    }

    private FlowersDecorator getPromotionalOffer(Client client, FlowersDecorator lastDecorator) {
        FlowersDecorator discount = null;
        if (client.isDiscount()) {
            discount = new PromotionalOffer(lastDecorator.getPrice() * 0.1);
        } else if (client.isSocialCard()) {
            discount = new PromotionalOffer(lastDecorator.getPrice() * 0.2);
        }
        discount.setFlowers(lastDecorator);
        return discount;
    }

}
