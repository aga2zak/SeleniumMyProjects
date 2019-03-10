package pl.infoshare.test;


import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.catrgories.AddCartTest;
import pl.infoshare.catrgories.PurchaseTests;
import pl.infoshare.tests.SeleniumApp2;

@RunWith(Categories.class)
@Categories.IncludeCategory({PurchaseTests.class, AddCartTest.class})
@Suite.SuiteClasses(SeleniumApp2.class)
public class PurchaseTestSuite {
}
