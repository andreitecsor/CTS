package assignments.no5.testare;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses({ProdusCerinta1Test.class, ProdusCerinta2Test.class, ProdusCerinta3Test.class})
@Categories.IncludeCategory(ErrorConditionTests.class)
public class Cerinta4Suita2 {
}
