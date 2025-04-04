package org.nhlstenden.jabberpoint.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nhlstenden.jabberpoint.Presentation;
import static org.junit.jupiter.api.Assertions.*;

class GoToTest {
    private GoTo goToCommand;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        goToCommand = new GoTo(presentation);
    }

    @Test
    void testConstructorNotNull1() {
        GoTo command = new GoTo(presentation);
        assertNotNull(command);
    }

    @Test
    void testConstructorNotNull2() {
        GoTo command = new GoTo(new Presentation());
        assertNotNull(command);
    }

    @Test
    void testConstructorHasPresentation1() {
        Presentation pres = new Presentation();
        GoTo command = new GoTo(pres);
        assertNotNull(pres);
    }

    @Test
    void testConstructorHasPresentation2() {
        Presentation pres = new Presentation();
        pres.setTitle("Test");
        GoTo command = new GoTo(pres);
        assertNotNull(pres);
        assertEquals("Test", pres.getTitle());
    }

    @Test
    void testGoToValidSlide1() {
        presentation.setSlideNumber(0);
        assertDoesNotThrow(() -> goToCommand.execute());
    }

    @Test
    void testGoToValidSlide2() {
        presentation.setSlideNumber(1);
        assertDoesNotThrow(() -> goToCommand.execute());
    }

    @Test
    void testGoToInvalidNumberFormat1() {
        presentation.setSlideNumber(0);
        assertDoesNotThrow(() -> goToCommand.execute());
    }

    @Test
    void testGoToInvalidNumberFormat2() {
        presentation.setSlideNumber(1);
        assertDoesNotThrow(() -> goToCommand.execute());
    }

    @Test
    void testGoToBoundaryMin1() {
        presentation.setSlideNumber(-1);
        assertDoesNotThrow(() -> goToCommand.execute());
    }

    @Test
    void testGoToBoundaryMin2() {
        presentation.setSlideNumber(-100);
        assertDoesNotThrow(() -> goToCommand.execute());
    }

    @Test
    void testGoToBoundaryMax1() {
        presentation.setSlideNumber(Integer.MAX_VALUE);
        assertDoesNotThrow(() -> goToCommand.execute());
    }

    @Test
    void testGoToBoundaryMax2() {
        presentation.setSlideNumber(presentation.getSize() + 1);
        assertDoesNotThrow(() -> goToCommand.execute());
    }
}