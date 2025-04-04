package org.nhlstenden.jabberpoint.accessor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.nhlstenden.jabberpoint.Presentation;
import org.nhlstenden.jabberpoint.slide.Slide;
import org.nhlstenden.jabberpoint.slide.item.TextItem;
import org.nhlstenden.jabberpoint.slide.item.BitmapItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class XMLAccessorTest {
    private XMLAccessor accessor;
    private Presentation presentation;
    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() throws IOException {
        accessor = new XMLAccessor();
        presentation = new Presentation();
        
        // Copy DTD file to temp directory
        String dtdContent = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "<!ELEMENT presentation (showtitle,slide*)>\n" +
                "<!ELEMENT showtitle (#PCDATA)>\n" +
                "<!ELEMENT slide (title, item*)>\n" +
                "<!ELEMENT title (#PCDATA)>\n" +
                "<!ELEMENT item (#PCDATA)>\n" +
                "<!ATTLIST item kind CDATA #REQUIRED>\n" +
                "<!ATTLIST item level CDATA #REQUIRED>";
        Files.writeString(tempDir.resolve("jabberpoint.dtd"), dtdContent);
    }

    @Test
    void testLoadValidXMLFile() throws IOException {
        String validXml = "<?xml version=\"1.0\"?>\n" +
                "<!DOCTYPE presentation SYSTEM \"" + tempDir.resolve("jabberpoint.dtd") + "\">\n" +
                "<presentation>\n" +
                "<showtitle>Test Presentation</showtitle>\n" +
                "<slide>\n" +
                "<title>Test Slide</title>\n" +
                "<item kind=\"text\" level=\"1\">Test Item</item>\n" +
                "</slide>\n" +
                "</presentation>";
        
        Path xmlPath = tempDir.resolve("test.xml");
        Files.writeString(xmlPath, validXml);

        accessor.loadFile(presentation, xmlPath.toString());
        
        assertEquals("Test Presentation", presentation.getTitle());
        assertEquals(1, presentation.getSize());
        Slide slide = presentation.getSlide(0);
        assertNotNull(slide, "Slide should not be null");
        assertEquals("Test Slide", slide.getTitle());
    }

    @Test
    void testLoadFileWithMultipleSlides() throws IOException {
        String xmlContent = "<?xml version=\"1.0\"?>\n" +
                "<!DOCTYPE presentation SYSTEM \"" + tempDir.resolve("jabberpoint.dtd") + "\">\n" +
                "<presentation>\n" +
                "<showtitle>Multiple Slides</showtitle>\n" +
                "<slide><title>Slide 1</title></slide>\n" +
                "<slide><title>Slide 2</title></slide>\n" +
                "</presentation>";

        Path xmlPath = tempDir.resolve("multiple.xml");
        Files.writeString(xmlPath, xmlContent);

        accessor.loadFile(presentation, xmlPath.toString());
        
        assertEquals(2, presentation.getSize());
        assertNotNull(presentation.getSlide(0));
        assertNotNull(presentation.getSlide(1));
        assertEquals("Slide 1", presentation.getSlide(0).getTitle());
        assertEquals("Slide 2", presentation.getSlide(1).getTitle());
    }

    @Test
    void testSaveAndLoadFile() throws IOException {
        // Create test image file
        Path imagePath = tempDir.resolve("test.jpg");
        Files.writeString(imagePath, "dummy image data");

        // Create a presentation
        presentation.setTitle("Save Test");
        Slide slide = new Slide();
        slide.setTitle("Test Slide");
        slide.append(new TextItem(1, "Test Text"));
        slide.append(new BitmapItem(2, imagePath.toString()));
        presentation.append(slide);

        // Save it
        Path savePath = tempDir.resolve("save-test.xml");
        accessor.saveFile(presentation, savePath.toString());

        // Verify file exists and has content
        assertTrue(Files.exists(savePath));
        String content = Files.readString(savePath);
        assertTrue(content.contains("Save Test"));
        assertTrue(content.contains("Test Slide"));

        // Load it into a new presentation
        Presentation loadedPresentation = new Presentation();
        accessor.loadFile(loadedPresentation, savePath.toString());

        assertEquals("Save Test", loadedPresentation.getTitle());
        assertEquals(1, loadedPresentation.getSize());
        assertNotNull(loadedPresentation.getSlide(0));
        assertEquals("Test Slide", loadedPresentation.getSlide(0).getTitle());
    }

    @Test
    void testLoadInvalidFile() {
        Path nonExistentFile = tempDir.resolve("nonexistent.xml");
        assertThrows(IOException.class, () -> 
            accessor.loadFile(presentation, nonExistentFile.toString())
        );
    }

    @Test
    void testLoadMalformedXML() throws IOException {
        String invalidXml = "<?xml version=\"1.0\"?>\n" +
                "<!DOCTYPE presentation SYSTEM \"" + tempDir.resolve("jabberpoint.dtd") + "\">\n" +
                "<presentation>\n" +
                "<showtitle>Malformed</showtitle>\n" +
                "<slide><title>Incomplete Slide</slide>";

        Path xmlPath = tempDir.resolve("malformed.xml");
        Files.writeString(xmlPath, invalidXml);

        assertThrows(IOException.class, () -> 
            accessor.loadFile(presentation, xmlPath.toString())
        );
    }

    @Test
    void testLoadFileWithDifferentItemTypes() throws IOException {
        String xmlContent = "<?xml version=\"1.0\"?>\n" +
                "<!DOCTYPE presentation SYSTEM \"" + tempDir.resolve("jabberpoint.dtd") + "\">\n" +
                "<presentation>\n" +
                "<showtitle>Item Types</showtitle>\n" +
                "<slide><title>Items</title>\n" +
                "<item kind=\"text\" level=\"1\">Text Item</item>\n" +
                "<item kind=\"image\" level=\"2\">" + tempDir.resolve("test.jpg") + "</item>\n" +
                "<item kind=\"unknown\" level=\"1\">Unknown Item</item>\n" +
                "</slide></presentation>";

        // Create test image
        Files.writeString(tempDir.resolve("test.jpg"), "dummy image data");

        Path xmlPath = tempDir.resolve("items.xml");
        Files.writeString(xmlPath, xmlContent);

        accessor.loadFile(presentation, xmlPath.toString());
        
        Slide slide = presentation.getSlide(0);
        assertNotNull(slide, "Slide should not be null");
        assertEquals(2, slide.getSlideItems().size());
    }
}