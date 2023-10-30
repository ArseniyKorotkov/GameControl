package by.arsy.p7coder;

import by.arsy.p2entity.ControlButton;

import java.util.List;
import java.util.Locale;

public class ButtonNameCoder {

    private static final List<String> BUTTONS_CODES = List.of(
            ControlButton.BUTTON_UP.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_A.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_B.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_C.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_LEFT.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_DOWN.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_RIGHT.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_D.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_E.name().toLowerCase(Locale.ROOT),
            ControlButton.BUTTON_F.name().toLowerCase(Locale.ROOT)
    );

    public static List<String> getButtonsCodes() {
        return BUTTONS_CODES;
    }
}
