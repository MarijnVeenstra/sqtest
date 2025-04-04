package org.nhlstenden.jabberpoint;

import org.nhlstenden.jabberpoint.command.Command;
import org.nhlstenden.jabberpoint.command.Exit;
import org.nhlstenden.jabberpoint.command.Next;
import org.nhlstenden.jabberpoint.command.Previous;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the org.nhlstenden.jabberpoint.KeyController (KeyListener)
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter {
    private final Map<Integer, Command> commandMap = new HashMap<>();

    public KeyController(Presentation presentation) {
        // Map keys to command instances
        commandMap.put(KeyEvent.VK_PAGE_DOWN, new Next(presentation));
        commandMap.put(KeyEvent.VK_DOWN, new Next(presentation));
        commandMap.put(KeyEvent.VK_ENTER, new Next(presentation));
        commandMap.put((int) '+', new Next(presentation));

        commandMap.put(KeyEvent.VK_PAGE_UP, new Previous(presentation));
        commandMap.put(KeyEvent.VK_UP, new Previous(presentation));
        commandMap.put((int) '-', new Previous(presentation));

        commandMap.put((int) 'q', new Exit(presentation));
        commandMap.put((int) 'Q', new Exit(presentation));
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        Command command = commandMap.get(keyEvent.getKeyCode());
        if (command != null) {
            command.execute();
        }
    }
}