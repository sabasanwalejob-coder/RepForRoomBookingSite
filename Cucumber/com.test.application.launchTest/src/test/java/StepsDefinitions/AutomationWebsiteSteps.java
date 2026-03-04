package StepsDefinitions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class AutomationWebsiteSteps {
     
	WebDriver driver= null;
	String loginpagecontent;
	

	@Given("user automation URL must be loaded")
	public void user_automation_url_must_be_loaded() {
		driver = new ChromeDriver();
		driver.get("https://www.automationtesting.co.uk/loginPortal.html");
		driver.manage().window().fullscreen();
		//driver.quit();
        System.out.println("Page got Opened ");
          }

	@When("user clicks to login portal test link")
	public void user_clicks_to_login_portal_test_link() {
	   driver.findElement(By.xpath("//a[normalize-space()='Login Portal Test']"));
	   
	}

	@Then("user will get navigate to the login portal test page")
	public void user_will_get_navigate_to_the_login_portal_test_page() {
		List<WebElement> elements = driver.findElements(By.xpath("//h2[@id='content']"));

        if (elements.size() > 0) {
            System.out.println("Text is present");
        } else {
            System.out.println("Text is not present");
        }

		}
	@When("user will add username")
	public void user_will_add_username() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='login_text']")).sendKeys("test");
		Thread.sleep(5000);
	}
	
	@When("user will add password")
	public void user_will_add_password() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@id='login_password'])[1]")).sendKeys("test123");
        Thread.sleep(5000);

}
	
	
	@When("user will click to the login button")
	public void user_will_click_to_the_login_button() {
		driver.findElement(By.xpath("//button[@id='login_btn']")).click();
	}
	
	@Then("user will get the succsufull pop up")
	public void user_will_get_the_succsufull_pop_up() throws InterruptedException {
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();

		// Get alert text
		System.out.println("Pop up Clicked" +alert.getText());

		// Accept (OK)
		alert.accept();

		// Dismiss (Cancel)
		//alert.dismiss();

		// For prompt alert
		//alert.sendKeys("Test input");
		//alert.accept();
		
	}

	
	
	}
