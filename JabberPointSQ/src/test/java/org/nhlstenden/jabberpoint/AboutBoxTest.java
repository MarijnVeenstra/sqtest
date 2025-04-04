package org.nhlstenden.jabberpoint;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Frame;

class AboutBoxTest {

    @Test
    void testShowWithNullFrame1() {
        assertDoesNotThrow(() -> AboutBox.show(null));
    }

    @Test
    void testShowWithNullFrame2() {
        Frame frame = null;
        assertDoesNotThrow(() -> AboutBox.show(frame));
    }

    @Test
    void testShowWithValidFrame1() {
        Frame frame = new Frame();
        assertDoesNotThrow(() -> AboutBox.show(frame));
    }

    @Test
    void testShowWithValidFrame2() {
        Frame frame = new Frame("Test Frame");
        assertDoesNotThrow(() -> AboutBox.show(frame));
    }
}