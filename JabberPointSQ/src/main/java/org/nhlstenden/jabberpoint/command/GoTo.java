package org.nhlstenden.jabberpoint.command;

import org.nhlstenden.jabberpoint.Presentation;
import org.nhlstenden.jabberpoint.slide.SlideViewerComponent;
import org.nhlstenden.jabberpoint.util.Constants;

import javax.swing.*;

public class GoTo extends Command {

    public GoTo(PresentationReceiver presentationReceiver) {
        super(presentationReceiver);
    }

    @Override
    public void execute() {
        SlideViewerComponent parent = this.presentationReceiver.getParent();
        String pageNumberStr = JOptionPane.showInputDialog("Page number?");
        int pageNumber = 0;

        try {
            pageNumber = Integer.parseInt(pageNumberStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    parent, Constants.INT_ERR, Constants.JAB_ERR, JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (pageNumber <= 0) {
            JOptionPane.showMessageDialog(
                    parent, Constants.INT_ERR, Constants.JAB_ERR, JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.presentationReceiver.setSlideNumber(pageNumber - 1);
    }
}
