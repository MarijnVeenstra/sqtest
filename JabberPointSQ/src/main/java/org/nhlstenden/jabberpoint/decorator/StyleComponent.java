package org.nhlstenden.jabberpoint.decorator;

import java.awt.*;

public interface StyleComponent {

  Color getColor();
  Font getFont(float scale);
  int getIndent();
  int getLeading();

  void createStyles();
}
