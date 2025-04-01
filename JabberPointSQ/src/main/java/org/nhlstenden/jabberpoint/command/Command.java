package org.nhlstenden.jabberpoint.command;

public abstract class Command
{
    PresentationReceiver presentationReceiver;

    public Command(PresentationReceiver presentationReceiver)
    {
        this.presentationReceiver = presentationReceiver;
    }

    public abstract void execute();
}