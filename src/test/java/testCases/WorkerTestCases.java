package testCases;

import org.testng.annotations.Test;

import elementRepository.DashBoard;
import elementRepository.LoginPage;
import elementRepository.WorkerPage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WorkerTestCases {
  WebDriver driver;
  @Test
  public void  verifyTextOfSearchButtonInWorkersPage() {
	  LoginPage lp=new LoginPage(driver);
	  lp.inputUserName();
	  lp.inputPassword();
	  lp.clickLoginButton();
	  
	  DashBoard db=new DashBoard(driver);
	  db.clickOnWorker();
	  
	  WorkerPage wp=new WorkerPage(driver);
	  String actualResult=wp.getTextFromSearchButton();
	  String expected="Search";
	  Assert.assertEquals(actualResult, expected,"Search button text not found");
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  driver.get("https://www.qabible.in/payrollapp/site/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
