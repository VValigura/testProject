package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@Tag("Simple")
public class PositivTest {
    @Test
    void test1(){
        assertTrue(true);
    }

    @Test
    void test2(){
        assertTrue(true);
    }

    @Test
    void test3(){
        assertTrue(true);
    }
}
