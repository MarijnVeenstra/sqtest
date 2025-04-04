package org.nhlstenden.jabberpoint.decorator;

import java.awt.*;

public class FontSizeStyleDecorator extends StyleWrapper {
  private final int newFontSize;

  public FontSizeStyleDecorator(StyleComponent wrappee, int newFontSize) {
    super(wrappee);
    this.newFontSize = newFontSize;
  }

  @Override
  public void createStyles() {
    super.createStyles();
    System.out.println("Applying font size: " + newFontSize);
  }

  @Override
  public Font getFont(float scale) {
    return getWrappee().getFont(scale).deriveFont(newFontSize * scale);
  }
}
