package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import util.BrowserFactory;

public class AddCategoryTest 

{
WebDriver driver;
	
	@BeforeMethod
	public void init() throws IOException
	{
		
		driver = BrowserFactory.init();
	}
	
	
	@Test(priority=1)
	public void validUsershouldAbleToAddCategory()
	{
		
		AddCategoryPage category = PageFactory.initElements(driver, AddCategoryPage.class);
		
		Assert.assertEquals(category.addCategory(), true);
	}
	
	@Test(priority=2)
	public void validUsershouldnotAbleToAddCategory()
	{
		AddCategoryPage duplicatecategory = PageFactory.initElements(driver, AddCategoryPage.class);
		
		Assert.assertEquals(duplicatecategory.addDuplicateCategory(), true);
	}
	
	
	@Test(priority=3)
	public void validateMpnthDropDown()
	{
		AddCategoryPage listofMonths = PageFactory.initElements(driver, AddCategoryPage.class);
		Assert.assertEquals(listofMonths.dropDownList(), 12);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.tearDown();
		
	}
	
	
	
	
	
}
