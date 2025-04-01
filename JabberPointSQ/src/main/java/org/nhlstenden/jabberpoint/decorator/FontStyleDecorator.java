package org.nhlstenden.jabberpoint.decorator;

import java.awt.*;

public class FontStyleDecorator extends StyleWrapper {
  private Font newFont;

  public FontStyleDecorator(StyleComponent wrappee, Font newFont) {
    super(wrappee);
    this.newFont = newFont;
  }

  @Override
  public Color getColor() {
    return null;
  }

  @Override
  public Font getFont(float scale) {
    return null;
  }

  @Override
  public int getIndent() {
    return 0;
  }

  @Override
  public int getLeading() {
    return 0;
  }

  @Override
  public void createStyles() {

    super.createStyles();
    applyFont();
  }

  private Font applyFont() {
    // Logic to apply the new font
    System.out.println("Applying font: " + newFont);
    // You can add actual rendering logic here if needed
    return newFont;
  }
}
