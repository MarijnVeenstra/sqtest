package org.nhlstenden.jabberpoint.decorator;

public class IndentStyleDecorator extends StyleWrapper {
  private final int extraIndent;

  public IndentStyleDecorator(StyleComponent wrappee, int extraIndent) {
    super(wrappee);
    this.extraIndent = extraIndent;
  }

  @Override
  public void createStyles() {
    super.createStyles();
    System.out.println("Applying indent: " + extraIndent);
  }

  @Override
  public int getIndent() {
    return extraIndent;
  }
}
