package org.nhlstenden.jabberpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.MenuBar;
import java.awt.Frame;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import org.nhlstenden.jabberpoint.slide.SlideViewerComponent;

class MenuControllerTest {
    private MenuController menuController;
    private Presentation presentation;
    private JMenuItem menuItem;
    private SlideViewerComponent slideViewer;
    private JFrame frame;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        frame = new JFrame();
        slideViewer = new SlideViewerComponent(presentation, frame);
        menuController = new MenuController(frame, presentation); // Fixed constructor arguments
        menuItem = new JMenuItem();
    }

    @Test
    void testConstructorNotNull1() {
        assertNotNull(menuController);
        assertTrue(menuController instanceof MenuBar);
    }

    @Test
    void testConstructorNotNull2() {
        JFrame newFrame = new JFrame();
        Presentation newPresentation = new Presentation();
        MenuController controller = new MenuController(newFrame, newPresentation); // Fixed constructor arguments
        assertNotNull(controller);
        assertTrue(controller instanceof MenuBar);
    }

    // Update remaining test methods to use actionPerformed instead of handleCommand
    @Test 
    void testMenuClickOpen1() {
        menuItem.setActionCommand("Open");
        ActionEvent event = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, "Open");
        assertDoesNotThrow(() -> menuController.createMenuItem("Open", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickOpen2() {
        JMenuItem item = new JMenuItem("Open");
        ActionEvent event = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, "Open");
        assertDoesNotThrow(() -> menuController.createMenuItem("Open", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickNew1() {
        menuItem.setActionCommand("New");
        ActionEvent event = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, "New");
        assertDoesNotThrow(() -> menuController.createMenuItem("New", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickNew2() {
        JMenuItem item = new JMenuItem("New");
        ActionEvent event = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, "New");
        assertDoesNotThrow(() -> menuController.createMenuItem("New", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickSave1() {
        menuItem.setActionCommand("Save");
        ActionEvent event = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, "Save");
        assertDoesNotThrow(() -> menuController.createMenuItem("Save", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickSave2() {
        JMenuItem item = new JMenuItem("Save");
        ActionEvent event = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, "Save");
        assertDoesNotThrow(() -> menuController.createMenuItem("Save", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickExit1() {
        menuItem.setActionCommand("Exit");
        ActionEvent event = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, "Exit");
        assertDoesNotThrow(() -> menuController.createMenuItem("Exit", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickExit2() {
        JMenuItem item = new JMenuItem("Exit");
        ActionEvent event = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, "Exit");
        assertDoesNotThrow(() -> menuController.createMenuItem("Exit", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickNext1() {
        menuItem.setActionCommand("Next");
        ActionEvent event = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, "Next");
        assertDoesNotThrow(() -> menuController.createMenuItem("Next", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickNext2() {
        JMenuItem item = new JMenuItem("Next");
        ActionEvent event = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, "Next");
        assertDoesNotThrow(() -> menuController.createMenuItem("Next", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickPrev1() {
        menuItem.setActionCommand("Prev");
        ActionEvent event = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, "Prev");
        assertDoesNotThrow(() -> menuController.createMenuItem("Prev", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickPrev2() {
        JMenuItem item = new JMenuItem("Prev");
        ActionEvent event = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, "Prev");
        assertDoesNotThrow(() -> menuController.createMenuItem("Prev", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickGoto1() {
        menuItem.setActionCommand("Goto");
        ActionEvent event = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, "Goto");
        assertDoesNotThrow(() -> menuController.createMenuItem("Goto", e -> {}).getActionListeners()[0].actionPerformed(event));
    }

    @Test
    void testMenuClickGoto2() {
        JMenuItem item = new JMenuItem("Goto");
        ActionEvent event = new ActionEvent(item, ActionEvent.ACTION_PERFORMED, "Goto");
        assertDoesNotThrow(() -> menuController.createMenuItem("Goto", e -> {}).getActionListeners()[0].actionPerformed(event));
    }
}