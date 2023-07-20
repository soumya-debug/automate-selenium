package com.saucelabs.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.saucelabs.driverMgmt.BaseTest;

public class SignUpTest extends BaseTest {
	By firstname = By.name("first_name");
	By lastname = By.name("last_name");
	By gender = By.id("inlineRadioMale");
	By hobbies = By.id("exampleFormControlSelect2");
	By department = By.name("department");
	By username = By.name("user_name");
	By Password = By.name("user_password");
	By confirmPassword = By.name("confirm_password");
	By email = By.name("email");
	By contactno = By.name("contact_no");
	By additionalinfo = By.id("exampleFormControlTextarea1");
	By submitbutton = By.xpath("//button[@type='submit']");

	public void register() throws InterruptedException, IOException {
	    setupDriver();
	    driver.get("https://mytestingthoughts.com/Sample/home.html");
	    driver.findElement(firstname).sendKeys("Soumya");
	    driver.findElement(lastname).sendKeys("Rout");
	    driver.findElement(gender).click();
	    Select hobbiesselect = new Select(driver.findElement(hobbies));
	    hobbiesselect.selectByVisibleText("Reading");
	    Select deptselect = new Select(driver.findElement(department));
	    deptselect.selectByVisibleText("MPDC");
	    driver.findElement(username).sendKeys("Soumya264");
	    driver.findElement(Password).sendKeys("1234abcdef");
	    driver.findElement(confirmPassword).sendKeys("1234abcdef");
	    driver.findElement(email).sendKeys("soumya26@gmail.com");
	    driver.findElement(contactno).sendKeys("639098765432");
	    driver.findElement(additionalinfo).sendKeys("This is my bio!!");
	    Thread.sleep(Duration.ofSeconds(3));
	    // Add a message indicating that the test case has passed.
	    System.out.println("SignUpTest: Test case passed successfully.");
	    capture("Signup_Filled_Form");

	    driver.findElement(submitbutton).click();

	    // Wait for the confirmation page to load before capturing the screenshot.
	    Thread.sleep(Duration.ofSeconds(5));
	    capture("Signup_Successful");
	    tearDown();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		SignUpTest signUpTest = new SignUpTest();
		signUpTest.register();

	}
}