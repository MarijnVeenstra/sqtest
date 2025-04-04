package org.nhlstenden.jabberpoint.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.nhlstenden.jabberpoint.Presentation;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Path;
import java.io.File;

class SaveTest {
    private Save saveCommand;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        saveCommand = new Save(presentation);
    }

    @Test
    void testConstructorNotNull() {
        assertNotNull(saveCommand);
    }

    @Test
    void testConstructorHasPresentation() {
        assertNotNull(presentation);
    }

    @Test
    void testSaveEmptyPresentation(@TempDir Path tempDir) {
        File testFile = tempDir.resolve("test.xml").toFile();
        assertDoesNotThrow(() -> saveCommand.execute());
    }

    @Test 
    void testSaveWithContent(@TempDir Path tempDir) {
        presentation.setTitle("Test Presentation");
        File testFile = tempDir.resolve("test-with-content.xml").toFile();
        assertDoesNotThrow(() -> saveCommand.execute());
    }
}