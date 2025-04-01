package org.nhlstenden.jabberpoint.slide;

import org.nhlstenden.jabberpoint.decorator.Style;
import org.nhlstenden.jabberpoint.decorator.StyleComponent;
import org.nhlstenden.jabberpoint.decorator.ColorStyleDecorator;
import org.nhlstenden.jabberpoint.decorator.FontSizeStyleDecorator;
import org.nhlstenden.jabberpoint.slide.item.SlideItem;
import org.nhlstenden.jabberpoint.slide.item.TextItem;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

/** <p>A slide. This class has a drawing functionality.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide {
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    protected String title; // title is saved separately
    protected Vector<SlideItem> items; // slide items are saved in a Vector

    public Slide() {
        items = new Vector<SlideItem>();
    }

    // Add a slide item
    public void append(SlideItem anItem) {
        items.addElement(anItem);
    }

    // give the title of the slide
    public String getTitle() {
        return title;
    }

    // change the title of the slide
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    // Create TextItem of String, and add the TextItem
    public void append(int level, String message) {
        append(new TextItem(level, message));
    }

    // give the  SlideItem
    public SlideItem getSlideItem(int number) {
        return (SlideItem)items.elementAt(number);
    }

    // give all SlideItems in a Vector
    public Vector<SlideItem> getSlideItems() {
        return items;
    }

    // give the size of the Slide
    public int getSize() {
        return items.size();
    }

    private StyleComponent createStyle(int level) {
        // Create base style and decorate it
        Style baseStyle;
        switch (level) {
            case 0: // Title style
                baseStyle = new Style(0, Color.BLACK, 48, 20);
                // Decorate with color and font size
                return new ColorStyleDecorator(
                    new FontSizeStyleDecorator(baseStyle, 60),
                    Color.GREEN
                );
            case 1: // Main point style
                baseStyle = new Style(20, Color.BLACK, 36, 10);
                return new ColorStyleDecorator(baseStyle, Color.RED);
            case 2: // Sub point style
                baseStyle = new Style(40, Color.BLACK, 30, 10);
                return new ColorStyleDecorator(baseStyle, Color.BLUE);
            case 3: // Sub-sub point style
                baseStyle = new Style(60, Color.BLACK, 24, 10);
                return baseStyle; // No decoration
            case 4: // Sub-sub-sub point style
                baseStyle = new Style(100, Color.ORANGE, 5, 20);
                return baseStyle;
            case 5: // Sub-sub-sub-sub point style
                baseStyle = new Style(120, Color.PINK, 1, 20);
                return baseStyle;
            default: // Default style
                return new Style(60, Color.BLACK, 20, 10);
        }
    }

    // draw the slide
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);
        int y = area.y;
        // Title is handled separately
        SlideItem slideItem = new TextItem(0, getTitle());
        StyleComponent style = createStyle(slideItem.getLevel());
        slideItem.draw(area.x, y, scale, g, style, view);
        y += slideItem.getBoundingBox(g, view, scale, style).height;
        for (int number=0; number<getSize(); number++) {
            slideItem = (SlideItem)getSlideItems().elementAt(number);
            style = createStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, g, style, view);
            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    // Give the scale for drawing
    private float getScale(Rectangle area) {
        return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
    }
}