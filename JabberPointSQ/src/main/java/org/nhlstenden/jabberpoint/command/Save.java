package org.nhlstenden.jabberpoint.command;

import org.nhlstenden.jabberpoint.Presentation;
import org.nhlstenden.jabberpoint.accessor.Accessor;
import org.nhlstenden.jabberpoint.accessor.XMLAccessor;
import org.nhlstenden.jabberpoint.slide.SlideViewerComponent;
import org.nhlstenden.jabberpoint.util.Constants;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Save extends Command {
    public Save(PresentationReceiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Accessor xmlAccessor = new XMLAccessor();

            try {
                xmlAccessor.saveFile((Presentation) this.presentationReceiver, file.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Failed to save: " + e.getMessage());
            }
        }
    }
}
