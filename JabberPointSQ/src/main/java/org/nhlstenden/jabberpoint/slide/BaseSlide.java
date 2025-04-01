package org.nhlstenden.jabberpoint.slide;

import org.nhlstenden.jabberpoint.slide.item.SlideItem;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface BaseSlide {
    //Baseline for all future slides
    public abstract void draw(Graphics graphics, Rectangle rectangle, ImageObserver imageObserver);

    public abstract void append(int level, String message);
    public abstract void append(SlideItem anItem);
}