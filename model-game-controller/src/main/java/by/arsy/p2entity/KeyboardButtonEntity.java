package by.arsy.p2entity;

import java.util.Objects;
import java.util.Optional;

public class KeyboardButtonEntity {

    private String keyboardButtonName;
    private Integer userId;
    private ControlButton controlButton;

    private KeyboardButtonEntity(){
    }

    public String name() {
        return keyboardButtonName;
    }

    public Optional<Integer> getUserId() {
        return Optional.ofNullable(userId);
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Optional<ControlButton> getControlButton() {
        return Optional.ofNullable(controlButton);
    }

    public void setControlButton(ControlButton controlButton) {
        this.controlButton = controlButton;
    }

    public boolean isUsed() {
        return getUserId().isPresent() && getControlButton().isPresent();
    }

    public static KeyboardButtonEntity build(String button, Integer userId, String userButton) {
        KeyboardButtonEntity keyboardButton = new KeyboardButtonEntity();
        keyboardButton.keyboardButtonName = button;
        keyboardButton.setUserId(userId);
        Optional<String> stringOptional = Optional.ofNullable(userButton);
        stringOptional.ifPresent(key -> keyboardButton.setControlButton(ControlButton.valueOf(userButton)));
        return keyboardButton;
    }

    public static KeyboardButtonEntity build(String button, Integer userId, ControlButton userButton) {
        KeyboardButtonEntity keyboardButton = new KeyboardButtonEntity();
        keyboardButton.keyboardButtonName = button;
        keyboardButton.setUserId(userId);
        keyboardButton.setControlButton(userButton);
        return keyboardButton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyboardButtonEntity entity = (KeyboardButtonEntity) o;
        return Objects.equals(keyboardButtonName, entity.keyboardButtonName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(keyboardButtonName);
    }
}
