package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestRailDemoListener.class)
public class ReportingNGTest {

    @Test(description = "157858")
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test(description = "157863")
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test(description = "157865")
    public void test3() {
        Assert.assertTrue(true);
    }

    @Test(description = "157868")
    public void test4() {
        Assert.assertTrue(false);
    }
}
