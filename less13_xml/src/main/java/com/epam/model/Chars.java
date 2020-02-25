package com.epam.model;


import java.util.Objects;

public class Chars {
    private String typeOfPlane;
    private int numberOfSeats;
    private boolean combatKit;
    private int rackets;
    private boolean availabilityOfRadar;

    public Chars() {
    }

    public Chars(String type, int numberOfSeats, boolean availabilityOfRadar, int racket) {
        this.typeOfPlane = type;
        this.numberOfSeats = numberOfSeats;
        this.availabilityOfRadar = availabilityOfRadar;
        if(type!= Type.SCOUT.toString()){
            this.combatKit = true;
            this.rackets = racket;
        }
    }

    public void setType(String type) {
        this.typeOfPlane = type;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setCombatKit(boolean combatKit) {
        this.combatKit = combatKit;
    }

    public void setRacket(int racket) {
        this.rackets = racket;
    }

    public void setAvailabilityOfRadar(boolean availabilityOfRadar) {
        this.availabilityOfRadar = availabilityOfRadar;
    }

    @Override
    public String toString() {
        return "Chars{" +
                "typeOfPlane='" + typeOfPlane + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", combatKit=" + combatKit +
                ", rackets=" + rackets +
                ", availabilityOfRadar=" + availabilityOfRadar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chars)) return false;
        Chars chars = (Chars) o;
        return numberOfSeats == chars.numberOfSeats &&
                combatKit == chars.combatKit &&
                rackets == chars.rackets &&
                availabilityOfRadar == chars.availabilityOfRadar &&
                Objects.equals(typeOfPlane, chars.typeOfPlane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfPlane, numberOfSeats, combatKit, rackets, availabilityOfRadar);
    }
}
