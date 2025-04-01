package org.nhlstenden.jabberpoint.command;

public class NewFile extends Command{

    public NewFile(PresentationReceiver presentationReceiver)
    {
        super(presentationReceiver);
    }

    @Override
    public void execute() {
        this.presentationReceiver.clear();
        this.presentationReceiver.setSlideNumber(0);
        this.presentationReceiver.getParent().repaint();
    }
}
