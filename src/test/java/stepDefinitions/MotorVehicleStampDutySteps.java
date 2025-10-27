package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import repository.MotorVehicleStampDutyHomePage;
import repository.RevenueNSWCalculatorsPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MotorVehicleStampDutySteps {

	// initialize variables
	WebDriver driver;
	private MotorVehicleStampDutyHomePage mvsdhp;
	private RevenueNSWCalculatorsPage calcPage;

	@After
	public void teardown() {
		CommonSteps.browserTearDown(driver);
	}

	@Given("the browser is open")
	public void openBrowser() {
		// driver setup
		driver = CommonSteps.browserStartUp();
	}

	@When("A user is on the motor vehicle stamp duty page")
	public void validateMotorVehiclePage() {
		// navigate to web page
		driver.get("https://www.service.nsw.gov.au/transaction/check-motor-vehicle-stamp-duty");
		// initialize the page elements
		mvsdhp = new MotorVehicleStampDutyHomePage(driver);
		// retrieve page title
		String title = mvsdhp.pageTitlePath().getText();
		// check the page is correct
		Assert.assertEquals("Check motor vehicle stamp duty", title);
		CommonSteps.takeScreenshot(driver, "Motor Vehicle Stamp Duty Home Page Screenshot");
	}

	@Then("A user clicks the check online button")
	public void clickCheckOnlineBtn() {
		mvsdhp.checkOnlineButtonPath().click();
		// screenshot to validate page
		CommonSteps.takeScreenshot(driver, "Revenue NSW Calculators Page Screenshot");

	}

	@And("A user clicks yes")
	public void clickYesRadioBtn() {
		// retrieve new page
		calcPage = new RevenueNSWCalculatorsPage(driver);
		calcPage.yesBtnPath().click();
	}

	@And("A user enters (.*)$")
	public void enterValueTxtBox(String purchaseValue) throws Throwable {
		calcPage.purchasePricePath().sendKeys(purchaseValue);

	}

	@And("A user clicks the calculate button")
	public void clickCalculateBtn() {
		// screenshot to show values before calculation
		CommonSteps.takeScreenshot(driver, "Values Entered before calculation Screenshot");
		calcPage.calculateBtnPath().click();
	}

	@Then("A user checks the duty payable is (.*)$")
	public void validateCalculatedValue(String dutyPayable) throws InterruptedException {
		// Add log to prove assert
		CommonSteps.addLog(driver, "Comparing the expected Duty Payable $" + dutyPayable + ".00 with " + calcPage.resultDutyPayablePath().getAttribute("textContent"));
		// Retrieve duty payable and validate
		Assert.assertEquals(calcPage.resultDutyPayablePath().getAttribute("textContent"), "$" + dutyPayable + ".00");
		// Add logs and screenshot to report
		CommonSteps.addLog(driver, "Comparison successful");
		// Click to ensure element is visible
		calcPage.resultDutyPayablePath().click();
		calcPage.resultPurchasePriceTxtPath().click();
		calcPage.resultPassengerVehicleTxtPath().click();
		CommonSteps.takeScreenshot(driver, "Results calculation Screenshot");
	}
}
