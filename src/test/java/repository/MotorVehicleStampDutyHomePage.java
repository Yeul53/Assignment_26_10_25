package repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MotorVehicleStampDutyHomePage {
	WebDriver driver;

	public MotorVehicleStampDutyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Check online']")
	WebElement checkOnlineBtn;

	@FindBy(id = "page-title")
	WebElement pageTitle;

	public WebElement checkOnlineButtonPath() {
		return checkOnlineBtn;
	}

	public WebElement pageTitlePath() {
		return pageTitle;
	}
}
