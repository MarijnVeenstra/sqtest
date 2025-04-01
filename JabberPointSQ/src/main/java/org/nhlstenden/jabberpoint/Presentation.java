package org.nhlstenden.jabberpoint;

import org.nhlstenden.jabberpoint.command.PresentationReceiver;
import org.nhlstenden.jabberpoint.slide.Slide;
import org.nhlstenden.jabberpoint.slide.SlideViewerComponent;

import javax.swing.*;
import java.util.ArrayList;

/**
 * <p>Presentation maintains the slides in the presentation.</p>
 * <p>There is only instance of this class.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation implements PresentationReceiver
{
    private String showTitle;
    private ArrayList<Slide> showList = null;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent;

    public Presentation() {
        this.slideViewComponent = null;
        this.clear();
    }

    public Presentation(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
        this.clear();
    }

    public int getSize() {
        return this.showList.size();
    }

    public SlideViewerComponent getParent() {
        return this.slideViewComponent;
    }

    public String getTitle() {
        return this.showTitle;
    }

    public void setTitle(String nt) {
        this.showTitle = nt;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
    }

    // give the number of the current slide
    public int getSlideNumber() {
        return this.currentSlideNumber;
    }

    public void setSlideNumber(int number) {
        if (number < 0 || number > (this.showList.size() - 1)) {
            return;
        }

        this.currentSlideNumber = number;

        if (this.slideViewComponent == null) {
            return;
        }

        this.slideViewComponent.update(this, this.getCurrentSlide());
    }

    // go to the previous slide unless your at the beginning of the presentation
    public void prevSlide() {
        this.setSlideNumber(this.currentSlideNumber - 1);
    }

    // go to the next slide unless your at the end of the presentation.
    public void nextSlide() {
        this.setSlideNumber(this.currentSlideNumber + 1);
    }

    // Delete the presentation to be ready for the next one.
    public void clear() {
        this.showList = new ArrayList<>();
        this.setSlideNumber(-1);
    }

    // Add a slide to the presentation
    public void append(Slide slide) {
        this.showList.add(slide);
    }

    // Get a slide with a certain slide number
    public Slide getSlide(int number) {
        if (number < 0 || number >= this.getSize()) {
            return null;
        }
        return this.showList.get(number);
    }

    // Give the current slide
    public Slide getCurrentSlide() {
        return this.getSlide(this.currentSlideNumber);
    }

    @Override
    public void open()
    {

    }

    @Override
    public void save()
    {

    }

    @Override
    public void goTo(int slideNumber) {
        this.setSlideNumber(slideNumber);
    }

    @Override
    public void next() {
        this.nextSlide();
    }

    @Override
    public void previous() {
        this.prevSlide();
    }

    @Override
    public void newFile() {
        this.clear();
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void help() {
        JOptionPane.showMessageDialog(null, "Help is not yet implemented.");
    }
}