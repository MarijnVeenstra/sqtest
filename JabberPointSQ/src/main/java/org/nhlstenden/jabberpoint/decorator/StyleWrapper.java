package org.nhlstenden.jabberpoint.decorator;

import java.awt.*;

public abstract class StyleWrapper implements StyleComponent {
    private final StyleComponent wrappee;

    public StyleWrapper(StyleComponent wrappee) {
        this.wrappee = wrappee;
    }

    protected StyleComponent getWrappee() {
        return wrappee;
    }

    @Override
    public Color getColor() {
        return wrappee.getColor();
    }

    @Override
    public Font getFont(float scale) {
        return wrappee.getFont(scale);
    }

    @Override
    public int getIndent() {
        return wrappee.getIndent();
    }

    @Override
    public int getLeading() {
        return wrappee.getLeading();
    }

    @Override
    public void createStyles() {
        wrappee.createStyles();
    }
}
