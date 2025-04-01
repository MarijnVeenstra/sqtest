package org.nhlstenden.jabberpoint.command;

import org.nhlstenden.jabberpoint.Presentation;
import org.nhlstenden.jabberpoint.accessor.Accessor;
import org.nhlstenden.jabberpoint.accessor.XMLAccessor;
import org.nhlstenden.jabberpoint.slide.SlideViewerComponent;
import org.nhlstenden.jabberpoint.util.Constants;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Open extends Command {
    public Open(PresentationReceiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            SlideViewerComponent parent = this.presentationReceiver.getParent();
            this.presentationReceiver.clear();

            Accessor xmlAccessor = new XMLAccessor();
            try {
                xmlAccessor.loadFile((Presentation) this.presentationReceiver, file.getAbsolutePath());
                this.presentationReceiver.setSlideNumber(0);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(
                        parent, Constants.IO_ERR + exc, Constants.LOAD_ERR, JOptionPane.ERROR_MESSAGE
                );
            }

            parent.repaint();
        }
    }
}