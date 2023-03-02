package calculation.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import calculation.test.sqrt.SquareRootRobustTest;
import calculation.test.sqrt.SquareRootUnitTest;

@Suite
@SelectClasses({ SquareRootUnitTest.class, SquareRootRobustTest.class })
public class SquareRootTest {

}