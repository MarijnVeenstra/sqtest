package org.nhlstenden.jabberpoint;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.awt.Color;

import org.nhlstenden.jabberpoint.decorator.Style;
import org.nhlstenden.jabberpoint.decorator.StyleComponent;
import org.nhlstenden.jabberpoint.decorator.FontSizeStyleDecorator;
import org.nhlstenden.jabberpoint.decorator.ColorStyleDecorator;

class JabberPointTest {
    private Presentation presentation;
    
    @BeforeEach
    void setUp() {
        presentation = new Presentation();
    }

    @Test
    void testMainWithNoArguments() {
        // Test loading demo presentation
        String[] args = new String[]{};
        assertDoesNotThrow(() -> JabberPoint.main(args));
    }

    @Test 
    void testMainWithValidXMLFile(@TempDir Path tempDir) throws IOException {
        // Create temporary test XML file
        Path xmlPath = tempDir.resolve("test.xml");
        String xmlContent = "<?xml version=\"1.0\"?>\n" +
                          "<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">\n" +
                          "<presentation>\n" +
                          "<showtitle>Test Presentation</showtitle>\n" +
                          "<slide><title>Test Slide</title></slide>\n" +
                          "</presentation>";
        Files.writeString(xmlPath, xmlContent);

        String[] args = new String[]{xmlPath.toString()};
        assertDoesNotThrow(() -> JabberPoint.main(args));
    }

    @Test
    void testMainWithInvalidXMLFile() {
        String[] args = new String[]{"nonexistent.xml"};
        assertDoesNotThrow(() -> JabberPoint.main(args));
        // Should handle IOException internally
    }

    @Test
    void testStyleDecoration() {
        Style baseStyle = new Style(20, Color.BLACK, 36, 10);
        StyleComponent decoratedStyle = new FontSizeStyleDecorator(
            new ColorStyleDecorator(baseStyle, Color.GREEN),
            48
        );
        
        assertNotNull(decoratedStyle);
        assertTrue(decoratedStyle instanceof FontSizeStyleDecorator);
    }

    @Test
    void testConstants() {
        assertEquals("IO Error: ", JabberPoint.IOERR);
        assertEquals("Jabberpoint Error ", JabberPoint.JABERR);
        assertEquals("Jabberpoint 1.6 - OU version", JabberPoint.JABVERSION);
    }
}
