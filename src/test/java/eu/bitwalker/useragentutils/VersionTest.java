package eu.bitwalker.useragentutils;

import static org.junit.Assert.*;

import org.junit.Test;

public class VersionTest {

    @Test
    public void shouldCompareCorrectly() {
        assertTrue(new Version("2.5", "2", "5").compareTo(new Version("3.1", "3", "1")) < 0);
        assertTrue(new Version("7.0.1", "7", "0.1").compareTo(new Version("7.0", "7", "0")) > 0);
        assertTrue(new Version("7.0.1", "7", "0.1").compareTo(new Version("7.0.1", "7", "0.1")) == 0);
        assertTrue(new Version("7.0.a", "7", "0.a").compareTo(new Version("7.0.b", "7", "0.b")) < 0);
        assertTrue(new Version("25.0", "25", "0").compareTo(new Version("3.1", "3", "1")) > 0);
    }
}