package testNGcommands;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasicCommands {
	
	@Test(priority = 2)
	@Parameters({"para1","para2"})
	public void testCase1(int a,String name)
	{
		System.out.println("TestCase1 Executed");
		System.out.println("The parameterised integer value:" + a);
		System.out.println("name para: " + name);
	}
	
	@Test(priority = 5)
	public void testCase2()
	{
		System.out.println("TestCase2 Executed");
	}
	
	@Test(priority = 1)
	public void testCase3()
	{
		System.out.println("TestCase3 Executed");
	}
	
	@Test(priority = 3)
	public void testCase4()
	{
		System.out.println("TestCase4 Executed");
	}
	
	@Test(priority = 4)
	public void testCase5()
	{
		System.out.println("TestCase5 Executed");
	}
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { 2, 3 }, { 7, 9 }, { 10, 15 } };
	}

}
