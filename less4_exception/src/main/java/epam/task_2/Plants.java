package epam.task_2;

import epam.task_2.plant_properties.Color;
import epam.task_2.plant_properties.Type;
import epam.task_2.plant_properties.exception.ColorException;
import epam.task_2.plant_properties.exception.TypeException;

public class Plants {

    private Color color;
    private int size;
    private Type type;

    public Plants(Color color, int size, Type type) throws ColorException, TypeException {
        this.color = validateColor(color);
        this.size = size;
        this.type = validateType(type);
    }

    private Color validateColor(Color iColor) throws ColorException {
        if (iColor.equals(Color.COLOR_GREEN)) {
            throw new ColorException("This color doesn`t registered!!!");
        }
        return iColor;
    }

    private Type validateType(Type iType) throws TypeException {
        if (iType.equals(Type.TYPE_SEEDS)) {
            throw new TypeException("This color doesn`t registered!!!");
        }
        return iType;
    }

    @Override
    public String toString() {
        return "Plants{" +
                "color=" + color +
                ", size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
