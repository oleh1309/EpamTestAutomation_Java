package epam.view;

import epam.controller.Controller;
import epam.controller.ControllerImpl;

public class View {

    public Controller controller;

    public View() {
        controller = new ControllerImpl();
    }
}
