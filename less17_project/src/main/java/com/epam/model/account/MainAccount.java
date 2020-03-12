package com.epam.model.account;

import com.epam.model.account.type.TypeAccount;
import com.epam.model.annotation.Column;
import com.epam.model.client.Client;

import java.sql.Date;
import java.util.Objects;

public abstract class MainAccount {
    @Column(name = "IDAccount")
    private int IDAccount;
    @Column(name = "IDClient")
    private int IDClient;
    @Column(name = "IDType")
    private int IDType;
    private TypeAccount type;
    @Column(name = "Amount")
    private double total_count;
    @Column(name = "DateStart")
    private Date dateStart;
    @Column(name = "DateEnd")
    private Date dateEnd;

    public MainAccount() {
    }

    public MainAccount(TypeAccount type, double total_count, Client client) {
        this.IDType = type.getIDType();
        this.IDClient = client.getIDClient();
        this.type = type;
        this.total_count = total_count;
        this.dateStart = new Date(new java.util.Date().getTime());
    }

    public int getIDClient() {
        return IDClient;
    }

    public int getIDType() {
        return IDType;
    }

    public int getIDAccount() {
        return IDAccount;
    }

    public TypeAccount getType() {
        return type;
    }

    public  double getBalance() {
        return total_count;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    protected void setDateEnd(long dateEnd) {
        java.util.Date date = new java.util.Date();
        dateEnd = dateEnd + dateStart.getTime();
        date.setTime(dateEnd);
        this.dateEnd = new Date(date.getTime());
    }

    protected double getTotal_count() {
        return total_count;
    }

    protected void setTotal_count(double total_count) {
        this.total_count = total_count;
    }

    protected abstract void setMoney(double count);

    protected abstract void getMoney(double count);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MainAccount)) return false;
        MainAccount account = (MainAccount) o;
        return total_count == account.total_count &&
                type == account.type &&
                dateStart.equals(account.dateStart) &&
                dateEnd.equals(account.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, total_count, dateStart, dateEnd);
    }

    @Override
    public String toString() {
        return "MainAccount{" +
                "IDAccount=" + IDAccount +
                ", IDClient=" + IDClient +
                ", IDType=" + IDType +
                ", type=" + type +
                ", total_count=" + total_count +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
