package testNGcommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class GroupExecution {
  @Test
  public void testCase1() {
	  System.out.println("Test case 1");
  }
  @Test(groups = "critical")
  public void testCase2() {
	  System.out.println("Test case 2");
  }
  @Test
  public void testCase3() {
	  System.out.println("Test case 3");
  }
  @Test(groups = "critical")
  
  public void testCase4() {
	  System.out.println("Test case 4");
  }
  @Test
  public void testCase5() {
	  System.out.println("Test case 5");
  }
 
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
	  System.out.println("After Method");
  }

}
