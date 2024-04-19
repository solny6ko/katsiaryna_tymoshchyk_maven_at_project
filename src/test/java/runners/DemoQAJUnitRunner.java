package runners;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.JUnitTests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({MyDemoQATasksTest.class})
public class DemoQAJUnitRunner {


}