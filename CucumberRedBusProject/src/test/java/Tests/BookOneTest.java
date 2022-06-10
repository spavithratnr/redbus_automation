package Tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.ListOfBusesPage;

import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookOneTest extends BusBaseTest{
	// Create first WebDriver reference.
	WebDriver driver;

	@Parameters({ "Browser" })
	@BeforeTest
	public void openBrowser(String browser) {
		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}

	@Parameters({ "URL" })
	@BeforeTest(dependsOnMethods = { "openBrowser" })
	public void getURL(String URL) throws InterruptedException {
		driver.get(URL);
		Thread.sleep(500);
	}

	@Test(dataProvider = "getFields")
	public void enterFromDestDate(String from, String dest, String date, String expectedResult)
			throws InterruptedException, ParseException{
		HomePage homePage = new HomePage(driver);
		test = extent.createTest("Enter Correct source, destination, date");

		homePage.fromWebElement().sendKeys(from);
		Thread.sleep(2000);
		homePage.fromSelectedWebElement().click();

		homePage.destinationWebElement().sendKeys(dest);
		Thread.sleep(2000);
		homePage.destSelectedWebElement().click();

		homePage.dateWebElement().click();

		// convert string to date object
		Date selectionDate = new SimpleDateFormat("dd-MMM-yyyy").parse(date);
		homePage.selectJourneyDate(selectionDate);

		homePage.searchBusWebElement().click();
		Thread.sleep(1000);

		ListOfBusesPage listPage = new ListOfBusesPage(driver);
		String actualResult = null;
		try {
			if (listPage.modifyWebElement().isDisplayed()) {

				actualResult = "Success";

			}
		}

		catch (Exception e) {

			actualResult = "Failure";

		}

		Assert.assertEquals(actualResult, expectedResult);
		
		
		listPage.viewSeatsWebElement().click();
		Thread.sleep(2000);
		listPage.selectACVWebElement().click();
		Thread.sleep(2000);
		/*listPage.selectSeat();
		Thread.sleep(2000);*/

		


	}
	
	

	@AfterMethod
	public void close() {
		driver.close();
	}

	@DataProvider
	public Object[][] getFields() {

		Object[][] data = { { "Koyambedu, Chennai", "Madiwala, Bangalore", "15-Aug-2022", "Success" } };

		return data;

	}

}
