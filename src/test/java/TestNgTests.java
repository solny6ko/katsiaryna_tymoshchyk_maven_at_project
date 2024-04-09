import org.testng.annotations.*;

import static org.testng.Assert.*;


public class TestNgTests {
    @Test
    public void classFileTestOne() {
        MyClassFile classFile = new MyClassFile();
        assertEquals(classFile.getNumber(-5, 5), 42, "Test one failed");
    }
    @Test
    public void classFileTestTwo() {
        MyClassFile classFile = new MyClassFile();
        assertEquals(classFile.getNumber(70, 1), -40, "Test two failed");
    }
    @Test
    public void classFileTestThree() {
        MyClassFile classFile = new MyClassFile();
        assertEquals(classFile.getNumber(-5, 11), 42, "Test three failed");
    }
    @Test
    public void classFileTestFour() {
        MyClassFile classFile = new MyClassFile();
        assertEquals(classFile.getNumber(10, 70), 120, "Test four failed");
    }

}