package org.nhlstenden.jabberpoint.command;

import org.nhlstenden.jabberpoint.Presentation;

public class Previous extends Command{

    public Previous(PresentationReceiver presentationReceiver)
    {
        super(presentationReceiver);
    }

    @Override
    public void execute() {
        presentationReceiver.previous();
    }
}
