package org.nhlstenden.jabberpoint.command;

import org.nhlstenden.jabberpoint.Presentation;

public class Next extends Command{

    public Next(PresentationReceiver presentationReceiver)
    {
        super(presentationReceiver);
    }

    @Override
    public void execute(){
        presentationReceiver.next();
    }
}
