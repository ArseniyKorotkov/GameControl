package by.arsy.button;

import by.arsy.p2entity.KeyboardButtonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

@Component
public class ButtonPusher {

    @Autowired
    private Robot robot;

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
}
