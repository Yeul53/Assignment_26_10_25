package repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevenueNSWCalculatorsPage {
	WebDriver driver;

	@FindBy(xpath = "//label[text()='Yes']")
	WebElement yesRadioBtn;

	@FindBy(id = "purchasePrice")
	WebElement purchasePriceTxtBox;

	@FindBy(xpath = "//button[text()='Calculate']")
	WebElement calculateBtn;

	@FindBy(xpath = "//td[text()='Purchase price or value']/following-sibling::td")
	WebElement resultPurchasePriceTxt;

	@FindBy(xpath = "//td[contains(text(),'passenger vehicle')]/following-sibling::td")
	WebElement resultPassengerVehicleTxt;

	@FindBy(xpath = "//td[contains(text(),'Duty payable')]/following-sibling::td")
	WebElement resultDutyPayableTxt;

	public RevenueNSWCalculatorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement yesBtnPath() {
		return yesRadioBtn;
	}

	public WebElement purchasePricePath() {
		return purchasePriceTxtBox;
	}

	public WebElement calculateBtnPath() {
		return calculateBtn;
	}

	public WebElement resultPurchasePriceTxtPath() {
		return resultPurchasePriceTxt;
	}

	public WebElement resultDutyPayablePath() {
		return resultDutyPayableTxt;
	}

	public WebElement resultPassengerVehicleTxtPath() {
		return resultPassengerVehicleTxt;
	}

}
