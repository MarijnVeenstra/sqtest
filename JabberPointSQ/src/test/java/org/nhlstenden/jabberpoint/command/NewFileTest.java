package org.nhlstenden.jabberpoint.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nhlstenden.jabberpoint.Presentation;
import static org.junit.jupiter.api.Assertions.*;

class NewFileTest {
    private NewFile newFileCommand;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        newFileCommand = new NewFile(presentation);
    }

    @Test
    void testConstructorNotNull1() {
        NewFile command = new NewFile(presentation);
        assertNotNull(command);
    }

    @Test
    void testConstructorNotNull2() {
        NewFile command = new NewFile(new Presentation());
        assertNotNull(command);
    }

    @Test
    void testConstructorHasPresentation1() {
        Presentation pres = new Presentation();
        NewFile command = new NewFile(pres);
        assertNotNull(pres);
    }

    @Test
    void testConstructorHasPresentation2() {
        Presentation pres = new Presentation();
        pres.setTitle("Test");
        NewFile command = new NewFile(pres);
        assertNotNull(pres);
        assertEquals("Test", pres.getTitle());
    }

    @Test
    void testNewFileClearsPresentation1() {
        presentation.setTitle("Test1");
        presentation.setSlideNumber(1);
        newFileCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
        assertEquals(0, presentation.getSize());
    }

    @Test
    void testNewFileClearsPresentation2() {
        presentation.setTitle("Test2");
        presentation.setSlideNumber(2);
        newFileCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
        assertEquals(0, presentation.getSize());
    }

    @Test
    void testNewFileWithEmptyPresentation1() {
        presentation.setSlideNumber(0);
        newFileCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
        assertEquals(0, presentation.getSize());
    }

    @Test
    void testNewFileWithEmptyPresentation2() {
        presentation.setTitle("");
        presentation.setSlideNumber(0);
        newFileCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
        assertEquals(0, presentation.getSize());
    }
}