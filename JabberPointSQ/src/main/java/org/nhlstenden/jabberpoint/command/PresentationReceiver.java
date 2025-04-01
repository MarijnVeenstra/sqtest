package org.nhlstenden.jabberpoint.command;

import org.nhlstenden.jabberpoint.slide.SlideViewerComponent;

public interface PresentationReceiver {
    void open();
    void save();
    void exit();
    void goTo(int slideNumber);
    void next();
    void previous();
    void newFile();
    void help();
    void clear();
    void setSlideNumber(int slideNumber);
    SlideViewerComponent getParent();
}