package calculation.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import calculation.test.gdnb.GoodNumberRobustTest;
import calculation.test.gdnb.GoodNumberUnitTest;

@Suite
@SelectClasses({ GoodNumberUnitTest.class, GoodNumberRobustTest.class })
public class GoodNumberTest {

}