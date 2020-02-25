package com.epam.task1.pizza;

import com.epam.task1.Location;

public interface Pizza {
    void prepare(Location location);

    void bake(Location location);

    void box(Location location);

    void cut();
}
