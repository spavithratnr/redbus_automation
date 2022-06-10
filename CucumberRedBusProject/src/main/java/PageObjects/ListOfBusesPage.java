package PageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfBusesPage {

	WebDriver driver;

	public ListOfBusesPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='onward-modify-btn g-button clearfix fl']")
	WebElement modify;

	@FindBy(xpath = "//div[@class='button view-seats fr']")
	WebElement viewSeats;

	@FindBy(xpath = "//ul[@class='list-chkbox']//li[2]//label[1]")
	WebElement ac;
	
	@FindBy(xpath = "//span[@class='dst']")
	WebElement nearDest;

	/*@FindBy(xpath = "//canvas[@data-type=\"lower\"]")
	WebElement selectSeat;*/

	public WebElement modifyWebElement() {
		return modify;

	}

	public WebElement viewSeatsWebElement() {
		return viewSeats;
	}

	public WebElement selectACVWebElement() {
		return ac;
	}
	
	public WebElement nearestDestinationWebElement() {
		return nearDest;
	}

	/*public void selectSeat() throws InterruptedException {

		Dimension canvas_dimensions = selectSeat.getSize();
		Point location = selectSeat.getLocation();
		int height =canvas_dimensions.getHeight() / 5;
		int width = canvas_dimensions.getWidth() / 2;
		
		new Actions(driver)
		.moveToElement(selectSeat)
        .moveByOffset(419, 211)
        .click()
        .build()
        .perform();
		System.out.println(width+ ", " +height);
		Thread.sleep(5000);
	}
	*/


}
