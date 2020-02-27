package com.epam.task3.clientFactory;

import com.epam.task3.TypeOfDelivery;
import com.epam.task3.TypeOfFlowers;
import com.epam.task3.decorate.FlowersDecorator;
import com.epam.task3.flowers.Flowers;

import java.util.LinkedList;
import java.util.List;

public abstract class Client {
    private String name;
    private List<FlowersDecorator> flowersList;
    private boolean isGoldCard;
    private boolean isSocialCard;
    private boolean isDiscount;

    public Client(String name) {
        this.name = name;
        flowersList = new LinkedList<>();
    }

    protected abstract Flowers createFlower(TypeOfFlowers type, List<String> list);

    protected abstract Flowers getFlowerFromCatalog(TypeOfFlowers type);

    protected abstract FlowersDecorator createFlowersDecorator(Flowers flowers,TypeOfDelivery typeOfDelivery, Client client);

    public void orderFromCatalog(TypeOfFlowers type, TypeOfDelivery typeOfDelivery) {
        decorateFlower(getFlowerFromCatalog(type),typeOfDelivery);
    }

    public void order(TypeOfFlowers type, TypeOfDelivery typeOfDelivery, List<String> list) {
       decorateFlower(createFlower(type,list),typeOfDelivery);
    }

    public void decorateFlower(Flowers flowers, TypeOfDelivery typeOfDelivery){
        FlowersDecorator flowersDecorator = createFlowersDecorator(flowers, typeOfDelivery, this);
        flowersList.add(flowersDecorator);
        checkDiscount();
    }

    private void checkDiscount(){
        double sum = 0;
        for (Flowers fullDecoration: flowersList) {
            sum += fullDecoration.getPrice();
        }
        if(sum>150 && sum<250){
            isDiscount = true;
        }else if(sum>250 && sum<500){
            isSocialCard = true;
            isDiscount = false;
        }else if(sum>500){
            isSocialCard = false;
            isDiscount = false;
            isGoldCard = true;
        }
    }

    public String print() {
        StringBuilder res = new StringBuilder();
        for (Flowers fullDecoration: flowersList) {
            res.append("price: ").append(fullDecoration.getPrice()).append("\n")
                    .append("price: ").append(fullDecoration.getName()).append("\n")
                    .append("COMPONENTS ===================\n");
            List<String> toppings = fullDecoration.getFlowersList();
            for (String component : toppings) {
                res.append(component).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}' + "\n" + print();
    }

    public boolean isGoldCard() {
        return isGoldCard;
    }

    public boolean isSocialCard() {
        return isSocialCard;
    }

    public boolean isDiscount() {
        return isDiscount;
    }
}
