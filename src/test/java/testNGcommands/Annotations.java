package testNGcommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Annotations {
  @Test
  public void testCase1() {
	  System.out.println("TestCase1 Executed");
  }
 
  @Test
  public void testCase2() {
	  System.out.println("TestCase2 Executed");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method Executed");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method Executed");
  }

}
