package epam.task4_5;

public class ModernDroid extends Droid {

    private int power;

    public ModernDroid(String name, int power) {
        super(name);
        this.power = power;
    }

    @Override
    public String toString() {
        return "ModernDroid{" + "name=" + getName() +
                ", power=" + power +
                '}';
    }
}
