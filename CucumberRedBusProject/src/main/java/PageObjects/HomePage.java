package PageObjects;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@id='src']")
    
	WebElement from;
	
	@FindBy(xpath = "//li[@select-id='results[0]']")
	WebElement fromSelected;

	
	
	@FindBy(xpath = "//input[@id='dest']")
	WebElement destination;
	
	
	@FindBy(xpath = "//li[@select-id='results[0]']")
	WebElement destSelected;
	
	@FindBy(xpath = "//button[normalize-space()='>']")
	WebElement datePickerNext;
	
	@FindBy(xpath = "//button[normalize-space()='<']")
	WebElement datePickerPrevious;


	


	@FindBy(xpath = "//input[@id='onward_cal']")
	WebElement date;

	@FindBy(xpath = "//button[@id='search_btn']")
	WebElement searchBus;

	
	public WebElement fromWebElement() {

		return from;

	}
	
	public WebElement fromSelectedWebElement() {

		return fromSelected;

	}


	public WebElement destinationWebElement() {

		return destination;

	}
	
	public WebElement destSelectedWebElement() {

		return destSelected;

	}
	
	public WebElement dateWebElement() {

		return date;

	}
	public WebElement datePickerNextWebElemnt() {

		return datePickerNext;

	}
	public WebElement datePickerPreviousWebElemnt() {

		return datePickerPrevious;

	}
	


	

	

	public WebElement searchBusWebElement() {

		return searchBus;

	}
	
	public int getMonthsDifference(Date date1, Date date2) {
	    @SuppressWarnings("deprecation")
		int m1 = date1.getYear() * 12 + date1.getMonth();
	    @SuppressWarnings("deprecation")
		int m2 = date2.getYear() * 12 + date2.getMonth();
	    return m2 - m1;
	}

	public void selectJourneyDate(Date date) throws InterruptedException {
		
	    Date currentDate = new Date();  
	    int monthDiff = getMonthsDifference(currentDate, date);
	    for(int i = 0; i < monthDiff; i++)
	    {
	    	datePickerNext.click();
	    	Thread.sleep(1000);
	    	
	    }
	    @SuppressWarnings("deprecation")
		int day =  date.getDate();
	    driver.findElement(By.xpath("//td[normalize-space()='"+ day +"']")).click();
    	Thread.sleep(1000);

	    
	    
	}
	

}
