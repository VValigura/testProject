package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Simple")
public class SkippedTest {
    @Test
    @Disabled("test1 Disabled")
    void test1(){
        assertTrue(true);
    }

    @Test
    @Disabled("test2 Disabled")
    void test2(){
        assertTrue(true);
    }

    @Test
    @Disabled("test3 Disabled")
    void test3(){
        assertTrue(true);
    }
}
