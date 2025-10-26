package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.restassured.response.Response;

public class CommonSteps {
	
	public static void takeScreenshot(WebDriver driver, String message) {
		//take screenshot
        String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        //embed into report
        ExtentCucumberAdapter.getCurrentStep().info("&nbsp;&nbsp;&nbsp;" + message,
        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
	}
	
	public static void addLog(WebDriver driver, String message) {
		//log for browser
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"&nbsp;&nbsp;&nbsp;" + message);

	}	

	public static void addAPILog(Response response, String message) {
		//logs for api
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"&nbsp;&nbsp;&nbsp;" + message);

	}	

	
}
