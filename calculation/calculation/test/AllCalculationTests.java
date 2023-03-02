package calculation.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SquareRootTest.class, GoodNumberTest.class})
public class AllCalculationTests {

}
