package org.nhlstenden.jabberpoint.command;

import org.nhlstenden.jabberpoint.Presentation;

public class Exit extends Command{

    public Exit(PresentationReceiver presentationReceiver)
    {
        super(presentationReceiver);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
