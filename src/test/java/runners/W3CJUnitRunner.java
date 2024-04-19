package runners;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.JUnitTests.MyDemoQATasksTest;
import tests.JUnitTests.MyW3schoolsAndGoogleSearchTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({MyW3schoolsAndGoogleSearchTest.class})
public class W3CJUnitRunner {


}