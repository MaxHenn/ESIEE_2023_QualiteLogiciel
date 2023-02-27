package calculation.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import calculation.test.unit.SquareRootUnitTest;
import calculation.test.robust.SquareRootRobustTest;

@Suite
@SelectClasses({ SquareRootUnitTest.class, SquareRootRobustTest.class })
public class SquareRootTest {

}