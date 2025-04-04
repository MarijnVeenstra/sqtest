package org.nhlstenden.jabberpoint.decorator;

import java.awt.Color;
import java.awt.Font;

public class Style implements StyleComponent {
    private static final String FONTNAME = "Helvetica";

    public int indent;
    public Color color;
    public Font font;
    public int fontSize;
    public int leading;

    public Style(int indent, Color color, int points, int leading) {
        this.indent = indent;
        this.color = color;
        this.fontSize = points;
        this.font = new Font(FONTNAME, Font.BOLD, points);
        this.leading = leading;
    }

    public static Style getStyle(int level) {
        switch (level) {
            case 0:
                return new Style(0, Color.red, 48, 20);
            case 1:
                return new Style(20, Color.blue, 40, 18);
            case 2:
                return new Style(40, Color.black, 36, 16);
            case 3:
                return new Style(60, Color.darkGray, 30, 14);
            default:
                return new Style(80, Color.gray, 24, 12);
        }
    }

    @Override
    public void createStyles() {
        System.out.println("Base style created: " + this.toString());
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }

    @Override
    public int getIndent() {
        return indent;
    }

    @Override
    public int getLeading() {
        return leading;
    }

    @Override
    public String toString() {
        return "[" + indent + ", " + color + "; " + fontSize + " on " + leading + "]";
    }
}
