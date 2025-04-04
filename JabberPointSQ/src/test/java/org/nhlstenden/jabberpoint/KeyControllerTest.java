package org.nhlstenden.jabberpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.KeyEvent;
import java.awt.Frame;
import javax.swing.JFrame;

class KeyControllerTest {
    private KeyController keyController;
    private Presentation presentation;
    private JFrame frame;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        keyController = new KeyController(presentation);
        frame = new JFrame();
    }

    @Test
    void testConstructorNotNull1() {
        assertNotNull(keyController);
    }

    @Test
    void testConstructorNotNull2() {
        KeyController controller = new KeyController(new Presentation());
        assertNotNull(controller);
    }

    @Test
    void testKeyPressPageDown1() {
        KeyEvent event = new KeyEvent(frame, KeyEvent.KEY_PRESSED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, 'P');
        assertDoesNotThrow(() -> keyController.keyPressed(event));
    }

    @Test
    void testKeyPressPageDown2() {
        KeyEvent event = new KeyEvent(frame, KeyEvent.KEY_PRESSED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, KeyEvent.CHAR_UNDEFINED);
        assertDoesNotThrow(() -> keyController.keyPressed(event));
    }

    @Test
    void testKeyPressPageUp1() {
        KeyEvent event = new KeyEvent(frame, KeyEvent.KEY_PRESSED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP, 'P');
        assertDoesNotThrow(() -> keyController.keyPressed(event));
    }

    @Test
    void testKeyPressPageUp2() {
        KeyEvent event = new KeyEvent(frame, KeyEvent.KEY_PRESSED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP, KeyEvent.CHAR_UNDEFINED);
        assertDoesNotThrow(() -> keyController.keyPressed(event));
    }

    @Test
    void testKeyReleased1() {
        KeyEvent event = new KeyEvent(frame, KeyEvent.KEY_RELEASED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, 'P');
        assertDoesNotThrow(() -> keyController.keyReleased(event));
    }

    @Test
    void testKeyReleased2() {
        KeyEvent event = new KeyEvent(frame, KeyEvent.KEY_RELEASED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP, 'P');
        assertDoesNotThrow(() -> keyController.keyReleased(event));
    }

    @Test
    void testKeyTyped1() {
        KeyEvent event = new KeyEvent(frame, KeyEvent.KEY_TYPED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'q');
        assertDoesNotThrow(() -> keyController.keyTyped(event));
    }

    @Test
    void testKeyTyped2() {
        KeyEvent event = new KeyEvent(frame, KeyEvent.KEY_TYPED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, ' ');
        assertDoesNotThrow(() -> keyController.keyTyped(event));
    }
}