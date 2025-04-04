package org.nhlstenden.jabberpoint.decorator;

public class LeadingStyleDecorator extends StyleWrapper {
  private final int newLeading;

  public LeadingStyleDecorator(StyleComponent wrappee, int newLeading) {
    super(wrappee);
    this.newLeading = newLeading;
  }

  @Override
  public void createStyles() {
    super.createStyles();
    System.out.println("Applying leading: " + newLeading);
  }

  @Override
  public int getLeading() {
    return newLeading;
  }
}
