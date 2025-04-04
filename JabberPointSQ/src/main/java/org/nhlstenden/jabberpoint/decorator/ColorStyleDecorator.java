package org.nhlstenden.jabberpoint.decorator;

import java.awt.*;

public class ColorStyleDecorator extends StyleWrapper {
    private final Color newColor;

    public ColorStyleDecorator(StyleComponent wrappee, Color newColor) {
        super(wrappee);
        this.newColor = newColor;
    }

    @Override
    public Color getColor() {
        return newColor;
    }

    @Override
    public void createStyles() {
        super.createStyles();
        System.out.println("Applying color: " + newColor);
    }
}
