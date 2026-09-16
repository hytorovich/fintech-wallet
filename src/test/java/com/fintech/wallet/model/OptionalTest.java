package com.fintech.wallet.model;

import com.fintech.wallet.practice.Optional2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {

    public static String[] technologies;
    public static String target;

    @BeforeEach
    public void setup() {
        technologies = new String[]{"Java", "Python", "JavaScript"};
    }

    @Test
    public void testPresent() {
        target = "Java";
        assertTrue(Optional2.check(technologies, target).isPresent());
        assertEquals("Java", Optional2.check(technologies, target).get());
    }
    @Test
    public void testEmpty() {
        target = "Javaa";
        assertTrue(Optional2.check(technologies, target).isEmpty());
    }

    @Test
    public void testThrows() {
        target = "Javaa";
        assertThrows(RuntimeException.class, () -> Optional2.check(technologies, target).orElseThrow());
    }

}
