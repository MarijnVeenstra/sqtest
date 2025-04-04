package org.nhlstenden.jabberpoint.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nhlstenden.jabberpoint.Presentation;
import static org.junit.jupiter.api.Assertions.*;

class NextTest {
    private Next nextCommand;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        nextCommand = new Next(presentation);
    }

    @Test
    void testConstructorNotNull1() {
        Next command = new Next(presentation);
        assertNotNull(command);
    }

    @Test
    void testConstructorNotNull2() {
        Next command = new Next(new Presentation());
        assertNotNull(command);
    }

    @Test
    void testConstructorHasPresentation1() {
        Presentation pres = new Presentation();
        Next command = new Next(pres);
        assertNotNull(pres);
    }

    @Test
    void testConstructorHasPresentation2() {
        Presentation pres = new Presentation();
        pres.setTitle("Test");
        Next command = new Next(pres);
        assertNotNull(pres);
        assertEquals("Test", pres.getTitle());
    }

    @Test
    void testNextSlideIncrementsSlideNumber1() {
        presentation.setSlideNumber(0);
        nextCommand.execute();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void testNextSlideIncrementsSlideNumber2() {
        presentation.setSlideNumber(1);
        nextCommand.execute();
        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    void testNextSlideFromLastSlide1() {
        presentation.setSlideNumber(presentation.getSize());
        nextCommand.execute();
        assertEquals(presentation.getSize(), presentation.getSlideNumber());
    }

    @Test
    void testNextSlideFromLastSlide2() {
        int lastSlide = presentation.getSize();
        presentation.setSlideNumber(lastSlide);
        nextCommand.execute();
        nextCommand.execute(); // Try twice
        assertEquals(lastSlide, presentation.getSlideNumber());
    }
}