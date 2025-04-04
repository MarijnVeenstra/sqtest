package org.nhlstenden.jabberpoint.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nhlstenden.jabberpoint.Presentation;
import static org.junit.jupiter.api.Assertions.*;

class PreviousTest {
    private Previous previousCommand;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        previousCommand = new Previous(presentation);
    }

    @Test
    void testConstructorNotNull() {
        assertNotNull(previousCommand);
    }

    @Test
    void testConstructorNotNull1() {
        Previous command = new Previous(presentation);
        assertNotNull(command);
    }

    @Test
    void testConstructorNotNull2() {
        Previous command = new Previous(new Presentation());
        assertNotNull(command);
    }

    @Test
    void testConstructorHasPresentation() {
        assertNotNull(presentation);
    }

    @Test
    void testConstructorHasPresentation1() {
        Presentation pres = new Presentation();
        Previous command = new Previous(pres);
        assertNotNull(pres);
    }

    @Test
    void testConstructorHasPresentation2() {
        Presentation pres = new Presentation();
        pres.setTitle("Test");
        Previous command = new Previous(pres);
        assertNotNull(pres);
        assertEquals("Test", pres.getTitle());
    }

    @Test
    void testPreviousSlideDecrementsSlideNumber() {
        presentation.setSlideNumber(1);
        previousCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void testPreviousSlideDecrementsSlideNumber1() {
        presentation.setSlideNumber(2);
        previousCommand.execute();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void testPreviousSlideDecrementsSlideNumber2() {
        presentation.setSlideNumber(3);
        previousCommand.execute();
        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    void testPreviousSlideFromFirstSlide() {
        presentation.setSlideNumber(0);
        previousCommand.execute();
        // Should stay at first slide
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void testPreviousSlideFromFirstSlide1() {
        presentation.setSlideNumber(0);
        previousCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void testPreviousSlideFromFirstSlide2() {
        presentation.setSlideNumber(0);
        previousCommand.execute();
        previousCommand.execute(); // Try twice
        assertEquals(0, presentation.getSlideNumber());
    }
}