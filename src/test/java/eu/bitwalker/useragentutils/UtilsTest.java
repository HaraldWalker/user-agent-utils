package eu.bitwalker.useragentutils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilsTest {

    private boolean contains(String a, String b) {
        return Utils.contains(a, new String[] { b });
    }

    @Test
    public void matchesWithVersion() {
        assertFalse(Utils.matchesWithVersion("foo bar/45 baz", "bar/4"));
        assertTrue(Utils.matchesWithVersion("foo bar/45 baz", "bar/45"));

        assertTrue(Utils.matchesWithVersion("foo bar/10.20 baz", "bar/10"));
        assertTrue(Utils.matchesWithVersion("foo bar/10.20 baz", "bar/10.2"));
        assertTrue(Utils.matchesWithVersion("foo bar/10.20 baz", "bar/10.20"));
        assertTrue(Utils.matchesWithVersion("foo bar/10.200 baz", "bar/10.20"));
        assertFalse(Utils.matchesWithVersion("foo bar/10.201 baz", "bar/10.20"));

        assertTrue(Utils.matchesWithVersion("foo bar/1.2.3 baz", "bar/1"));
        assertTrue(Utils.matchesWithVersion("foo bar/1.2.3 baz", "bar/1.2"));
        assertTrue(Utils.matchesWithVersion("foo bar/1.2.3 baz", "bar/1.2.3"));
        assertFalse(Utils.matchesWithVersion("foo bar/1.2.3 baz", "bar/1.2.4"));
        assertFalse(Utils.matchesWithVersion("foo bar/1.2.3 baz", "bar/1.3"));

    }

    @Test
    public void contains() {
        assertTrue(contains("foo", "foo"));
        assertTrue(contains("foo bar baz", "foo"));
        assertTrue(contains("foo bar baz", "bar"));
        assertTrue(contains("foo bar baz", "baz"));
        assertFalse(contains("foo firefox/45 baz", "firefox/4"));
        assertTrue(contains("foo firefox/45 baz", "firefox/45"));
    }
}
