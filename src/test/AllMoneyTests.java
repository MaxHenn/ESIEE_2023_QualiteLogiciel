package src.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ MoneyBagTest.class, MoneyTest.class })
public class AllMoneyTests {

}
