package org.nhlstenden.jabberpoint.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nhlstenden.jabberpoint.slide.BaseSlide;
import org.nhlstenden.jabberpoint.slide.item.TextItem;
import org.nhlstenden.jabberpoint.slide.item.SlideItem;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;

class BaselineBuilderTest {
    private BaselineBuilder builder;
    private Vector<SlideItem> items;

    @BeforeEach
    void setUp() {
        builder = new BaselineBuilder();
        items = new Vector<>();
        items.add(new TextItem(1, "Test Item"));
    }

    @Test
    void testConstructorNotNull1() {
        assertNotNull(builder);
    }

    @Test
    void testConstructorNotNull2() {
        BaselineBuilder newBuilder = new BaselineBuilder();
        assertNotNull(newBuilder);
    }

    @Test
    void testBaselineCreatorSetup1() {
        builder.baselineCreatorSetup("Test Title", items);
        BaseSlide result = builder.getResult();
        assertNotNull(result);
        assertTrue(result instanceof BaseSlide);
        assertFalse(items.isEmpty());
    }

    @Test
    void testBaselineCreatorSetup2() {
        Vector<SlideItem> newItems = new Vector<>();
        newItems.add(new TextItem(2, "Another Test"));
        builder.baselineCreatorSetup("Another Title", newItems);
        BaseSlide result = builder.getResult();
        assertNotNull(result);
        assertTrue(result instanceof BaseSlide);
        assertEquals(1, newItems.size());
    }

    @Test
    void testVideoCreatorSetupNoEffect1() {
        builder.videoCreatorSetup("Video Title", items, "test.mp4", 0, 0, 640, 480);
        assertNull(builder.getResult());
    }

    @Test
    void testVideoCreatorSetupNoEffect2() {
        builder.videoCreatorSetup("Video Title 2", items, "another.mp4", 100, 100, 800, 600);
        assertNull(builder.getResult());
    }

    @Test
    void testAnimationCreatorSetupNoEffect1() {
        builder.animationCreatorSetup("Animation Title", items, "test.gif");
        assertNull(builder.getResult());
    }

    @Test
    void testAnimationCreatorSetupNoEffect2() {
        builder.animationCreatorSetup("Animation Title 2", items, "another.gif");
        assertNull(builder.getResult());
    }

    @Test
    void testGetResultNoSetup1() {
        assertNull(builder.getResult());
    }

    @Test
    void testGetResultNoSetup2() {
        BaselineBuilder newBuilder = new BaselineBuilder();
        assertNull(newBuilder.getResult());
    }
}