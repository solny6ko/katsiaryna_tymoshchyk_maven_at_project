import org.junit.Test;

import static org.junit.Assert.*;

public class TestsJUnit {
    @Test
    public void classFileTestOne() {
        MyClassFile classFile = new MyClassFile();
        assertEquals("Test one failed", 42, classFile.getNumber(-5, 5));
    }
    @Test
    public void classFileTestTwo() {
        MyClassFile classFile = new MyClassFile();
        assertEquals("Test two failed", -40, classFile.getNumber(-70, 1));
    }
    @Test
    public void classFileTestThree() {
        MyClassFile classFile = new MyClassFile();
        assertEquals("Test three failed", 42, classFile.getNumber(-5, 11));
    }
    @Test
    public void classFileTestFour() {
        MyClassFile classFile = new MyClassFile();
        assertEquals("Test four failed", 120, classFile.getNumber(10, 70));
    }
}
