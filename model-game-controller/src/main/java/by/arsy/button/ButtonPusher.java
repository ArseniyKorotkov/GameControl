package by.arsy.button;

import by.arsy.p2entity.KeyboardButtonEntity;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

public final class ButtonPusher {
    private final static Robot robot = SingleRobot.ROBOT.getRobot();
    private final static ButtonPusher button = new ButtonPusher();

    private ButtonPusher() {

    }

    public void push(KeyboardButtonEntity keyboardButton) {
        try {
            Field field = KeyEvent.class.getField(keyboardButton.name());
            int buttonNumber = field.getInt(field);
            robot.keyPress(buttonNumber);
            Thread.sleep(50);
            robot.keyRelease(buttonNumber);
        } catch (IllegalAccessException | NoSuchFieldException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void press(KeyboardButtonEntity keyboardButton) {
        try {
            Field field = KeyEvent.class.getField(keyboardButton.name());
            int buttonNumber = field.getInt(field);
            robot.keyPress(buttonNumber);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void release(KeyboardButtonEntity keyboardButton) {
        try {
            Field field = KeyEvent.class.getField(keyboardButton.name());
            int buttonNumber = field.getInt(field);
            robot.keyRelease(buttonNumber);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static ButtonPusher getInstance() {
        return button;
    }

}
