package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddCategoryPage extends BasePage
{
WebDriver driver;
	
	public AddCategoryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//WEBELEMENTS
	@FindBy(how = How.NAME, using ="categorydata")WebElement CATEGORY_DATA_ELEMENT;
	@FindBy(how = How.XPATH, using ="//span[@id='extra']//input[@type='submit']")WebElement ADD_CATEGORY_ELEMENET;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']")WebElement DROP_DOWN_ELEMENT;
	
	
	//CORRESPONDING METHODS
	public boolean addCategory()
	{
		System.out.println(CATEGORY_DATA_ELEMENT);
		CATEGORY_DATA_ELEMENT.sendKeys("Geetha" +generateRandomNum(999));
		
		//TO GET THE VALUE ENTERED IN THE TEXT
		String categoryValue =CATEGORY_DATA_ELEMENT.getAttribute("value");
		ADD_CATEGORY_ELEMENET.click();
		
		//TO FIND ALL THE CATEGORY LISTED IN THE PAGE
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='controls']//span"));
		
		for(int i=0; i<allElements.size(); i++)
		{
			if(allElements.get(i).getText().equals(categoryValue))
			{
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean addDuplicateCategory()
	{
		CATEGORY_DATA_ELEMENT.sendKeys("Geetha" +generateRandomNum(999));
		
		
		String categoryValue = CATEGORY_DATA_ELEMENT.getAttribute("value");
		System.out.println(categoryValue);
		ADD_CATEGORY_ELEMENET.click();
		
		
		CATEGORY_DATA_ELEMENT.sendKeys(categoryValue);
		ADD_CATEGORY_ELEMENET.click();
		
		String warningText = ("The category you want to add already exists" + categoryValue);
		
		List<WebElement>  list = driver.findElements(By.xpath("//body[contains(text(),warningText)]"));
		
		if(list.size()>0)
		{
			System.out.println("Text :" + warningText +  "is present. ");
			return true;
		}
		else
		{

			return false;
		}
	}
	
	
	public int dropDownList()
	{
		
		String[]months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		
		Select sel = new Select(DROP_DOWN_ELEMENT);
		List<WebElement>  option = sel.getOptions();
		int count =0;
		
	
		
		for(WebElement dropdown: option)
		{
			System.out.println("DropDown Options :" + dropdown.getText());
			
			for(int i =0; i<months.length; i++)
			{
				//System.out.println("List Of months" + months[i]);
				if(dropdown.getText().equalsIgnoreCase(months[i]))
				{
					count++;
					break;
				}
			}
		}
		
		
		return count;
		
	}
	
	
	
	
	
	
}
