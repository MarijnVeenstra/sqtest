package org.nhlstenden.jabberpoint.builder;

import org.nhlstenden.jabberpoint.slide.BaseSlide;
import org.nhlstenden.jabberpoint.slide.item.SlideItem;

import java.util.Vector;

public interface Builder {
    public abstract void videoCreatorSetup(String title, Vector<SlideItem> items, String videoPath, int videoXAxis, int videoYAxis, int width, int height);
    public abstract void animationCreatorSetup(String title, Vector<SlideItem> items, String animationPath);
    public abstract void baselineCreatorSetup(String title, Vector<SlideItem> items);
    public abstract BaseSlide getResult();
}