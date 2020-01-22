package epam.View;

import epam.Controller.Controller;
import epam.Controller.ControllerImpl;

public class View {

    public Controller controller;

    public View() {
        controller = new ControllerImpl();
    }
}
