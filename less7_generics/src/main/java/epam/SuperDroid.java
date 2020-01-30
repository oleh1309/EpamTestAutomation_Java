package epam;

public class SuperDroid extends Droid{
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
}
