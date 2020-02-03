package epam.task4_5;

public class SuperDroid extends Droid implements Comparable<SuperDroid>{
    private int power;
    private int armor;

    public SuperDroid(String name, int power, int armor) {
        super(name);
        this.power = power;
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "SuperDroid{" + "name=" + getName() +
                ", power=" + power +
                ", armor=" + armor +
                '}';
    }

    @Override
    public int compareTo(SuperDroid o) {
        return this.getName().compareTo(o.getName());
    }
}
