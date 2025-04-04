package org.nhlstenden.jabberpoint.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nhlstenden.jabberpoint.slide.BaseSlide;
import org.nhlstenden.jabberpoint.slide.item.TextItem;
import org.nhlstenden.jabberpoint.slide.item.SlideItem;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;

class DirectorTest {
    private Director director;
    private Builder builder;
    private Vector<SlideItem> items;

    @BeforeEach
    void setUp() {
        builder = new BaselineBuilder();
        director = new Director(builder);
        items = new Vector<>();
        items.add(new TextItem(1, "Test Item"));
    }

    @Test
    void testConstructorNotNull1() {
        assertNotNull(director);
    }

    @Test
    void testConstructorNotNull2() {
        Director newDirector = new Director(new BaselineBuilder());
        assertNotNull(newDirector);
    }

    @Test
    void testGetBuilder1() {
        assertEquals(builder, director.getBuilder());
    }

    @Test
    void testGetBuilder2() {
        Builder newBuilder = new BaselineBuilder();
        Director newDirector = new Director(newBuilder);
        assertEquals(newBuilder, newDirector.getBuilder());
    }

    @Test
    void testSetBuilder1() {
        Builder newBuilder = new BaselineBuilder();
        director.setBuilder(newBuilder);
        assertEquals(newBuilder, director.getBuilder());
    }

    @Test
    void testSetBuilder2() {
        Builder newBuilder = new BaselineBuilder();
        director.setBuilder(newBuilder);
        assertNotEquals(builder, director.getBuilder());
    }

    @Test
    void testChangeBuilder1() {
        Builder newBuilder = new BaselineBuilder();
        director.changeBuilder(newBuilder);
        assertEquals(newBuilder, director.getBuilder());
    }

    @Test
    void testChangeBuilder2() {
        Builder originalBuilder = director.getBuilder();
        Builder newBuilder = new BaselineBuilder();
        director.changeBuilder(newBuilder);
        assertNotEquals(originalBuilder, director.getBuilder());
    }

    @Test
    void testMakeBaseSlide1() {
        BaseSlide slide = director.make("Test Title", items);
        assertNotNull(slide);
        assertTrue(slide instanceof BaseSlide);
    }

    @Test
    void testMakeBaseSlide2() {
        Vector<SlideItem> newItems = new Vector<>();
        newItems.add(new TextItem(2, "Another Test"));
        BaseSlide slide = director.make("Another Title", newItems);
        assertNotNull(slide);
        assertEquals(1, newItems.size());
    }

    @Test
    void testMakeAnimationSlide1() {
        BaseSlide slide = director.make("Animation Test", items, "test.gif");
        assertNotNull(slide);
    }

    @Test
    void testMakeAnimationSlide2() {
        BaseSlide slide = director.make("Animation Test 2", items, "another.gif");
        assertNotNull(slide);
        assertTrue(slide instanceof BaseSlide);
    }

    @Test
    void testMakeVideoSlide1() {
        BaseSlide slide = director.make("Video Test", items, "test.mp4", 0, 0, 640, 480);
        assertNotNull(slide);
    }

    @Test
    void testMakeVideoSlide2() {
        BaseSlide slide = director.make("Video Test 2", items, "another.mp4", 100, 100, 800, 600);
        assertNotNull(slide);
        assertTrue(slide instanceof BaseSlide);
    }
}