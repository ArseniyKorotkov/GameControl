package by.arsy.button;

import java.awt.*;

public enum SingleRobot {
    ROBOT;

    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public Robot getRobot() {
        return robot;
    }
}
