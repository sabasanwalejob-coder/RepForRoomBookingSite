package StepsDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class RoomBookingSteps {
	
	WebDriver driver= null;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	
	@Given("automation URL must be loaded")
	public void automation_url_must_be_loaded() {
		driver = new ChromeDriver();
		driver.get("https://automationintesting.online/#booking");
		driver.manage().window().fullscreen();
		//driver.quit();
        System.out.println("Page got Opened ");
          }
	

	@When("user selected check in & check out date")
	public void user_selected_check_in_check_out_date() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement checkIn = wait.until(
		        ExpectedConditions.presenceOfElementLocated(
		                By.xpath("(//input[@class='form-control'])[1]")
		        )
		);

		// 🔥 Scroll FIRST
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", checkIn);

		Thread.sleep(500); // small pause

		// 🔥 THEN click (only once)
		checkIn.click();
		
		// ===============================
		// SELECT CHECK-IN DATE (10th)
		// ===============================

		// Wait for calendar to appear
		WebElement checkInDate = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//div[contains(@class,'react-datepicker__day') and text()='10']")
		        )
		);

		// Click Check-In date
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", checkInDate);


		// ===============================
		// SELECT CHECK-OUT DATE (15th)
		// ===============================

		// Click Check-Out input
		WebElement checkOut = wait.until(
		        ExpectedConditions.presenceOfElementLocated(
		                By.xpath("(//input[@class='form-control'])[2]")
		        )
		);

		// Scroll & click checkout
		js1.executeScript("arguments[0].scrollIntoView({block:'center'});", checkOut);
		Thread.sleep(500);
		js1.executeScript("arguments[0].click();", checkOut);


		// Wait for calendar again
		WebElement checkOutDate = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//div[contains(@class,'react-datepicker__day') and text()='15']")
		        )
		);

		// Click Check-Out date
		js1.executeScript("arguments[0].click();", checkOutDate);
		
		driver.findElement(By.xpath("//button[normalize-space()='Check Availability']")).click();
		
	}
		

//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//	    // Wait until booking section loads
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.id("booking")
//	    ));
//
//	    // Now wait for check-in field
//	    WebElement checkIn = wait.until(
//	            ExpectedConditions.visibilityOfElementLocated(
//	                    By.cssSelector("input[placeholder='Check In']")
//	            )
//	    );
//
//	    checkIn.click();
//
//	    // Select date 4
//	    WebElement checkInDate = wait.until(
//	            ExpectedConditions.elementToBeClickable(
//	                    By.xpath("//div[contains(@class,'react-datepicker__day') and text()='4']")
//	            )
//	    );
//	    checkInDate.click();
//
//	    // Select date 8
//	    WebElement checkOutDate = wait.until(
//	            ExpectedConditions.elementToBeClickable(
//	                    By.xpath("//div[contains(@class,'react-datepicker__day') and text()='8']")
//	            )
//	    );
//	    checkOutDate.click();
//	}
//		
		
		
//		Thread.sleep(5000);
//	     // Click check-in field to open calendar
//        driver.findElement(By.xpath("//body/div[@id='root-container']/div/div/section[@id='booking']/div[@class='container']/div[@class='card shadow booking-card']/div[@class='card-body p-4']/form/div[@class='row g-3']/div[1]/div[1]")).click();
//
//        String month = "April 2026";
//        String day = "10";
//
//        // Loop until correct month appears
//        while (true) {
//            String currentMonth = driver.findElement(By.xpath("//div[@aria-label='Choose Friday, 10 April 2026']")).getText();
//
//            if (currentMonth.equals(month)) {
//                break;
//            } else {
//                driver.findElement(By.xpath("//span[@class='react-datepicker__navigation-icon react-datepicker__navigation-icon--next']")).click();
//            }
//        }
//
//        // Select date
//        driver.findElement(By.xpath("//div[@aria-label='Choose Monday, 10 August 2026']='" + day + "']")).click();
//
//        // -------- CHECKOUT --------
//
//        String checkoutDay = "15";
//        driver.findElement(By.xpath("//div[@aria-label='Choose Wednesday, 15 April 2026']='" + checkoutDay + "']")).click();
//
//        driver.quit();
    

		

	@Then("user clicks to book now option")
	public void user_clicks_to_book_now_option() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement booknow = wait.until(
		        ExpectedConditions.presenceOfElementLocated(
		                By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Book now'])[1]")
		        )
		);

		// 🔥 Scroll FIRST
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", booknow);

		Thread.sleep(500); // small pause

		// 🔥 THEN click (only once)
		booknow.click();
	}
	
	@When("user clicks reserve now")
	public void user_clicks_reserve_now() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement reservenow = wait.until(
		        ExpectedConditions.presenceOfElementLocated(
		                By.xpath("//button[@id='doReservation']")
		        )
		);

		// 🔥 Scroll FIRST
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", reservenow);

		Thread.sleep(500); // small pause

		// 🔥 THEN click (only once)
		reservenow.click();
		
		// reserve now form steps -----> First name 
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement fname = wait1.until(
		        ExpectedConditions.presenceOfElementLocated(
		                By.xpath("//input[@placeholder='Firstname']")
		        )
		);

		// 🔥 Scroll FIRST
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", fname);

		Thread.sleep(500); // small pause

		// 🔥 THEN click (only once)
		fname.sendKeys("Noorussaba");
		
		//---------------->last name 
		
		driver.findElement(By.xpath("//input[@placeholder='Lastname']")).sendKeys("Sanwale");
		
//		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//		WebElement lname = wait11.until(
//		        ExpectedConditions.presenceOfElementLocated(
//		                By.xpath("//input[@placeholder='Lastname']")
//		        )
//		);
//
//		// 🔥 Scroll FIRST
//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
//		js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", lname);
//
//		Thread.sleep(500); // small pause
//
//		// 🔥 THEN click (only once)
//		lname.sendKeys("Sanwale ");
		 
		//---------------------------->email 
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test123@gmail.com");
		
		//------------------------->phone 
		driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("89716736363");
		
		//click reserve now at the end 
		
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(15));
		
			WebElement RN = wait11.until(
			        ExpectedConditions.presenceOfElementLocated(
				                By.xpath("//button[normalize-space()='Reserve Now']")
				        )
				);
		
				// 🔥 Scroll FIRST
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", RN);
		
			Thread.sleep(500); // small pause
		
			// 🔥 THEN click (only once)
			RN.click();
			
			//phone number validation field - worked as expected 
		
//			WebDriverWait wait111 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//			wait111.until(ExpectedConditions.visibilityOfElementLocated(
//			        By.xpath("//li[normalize-space()='size must be between 11 and 21']")
//			));
//
//			List<WebElement> elements = driver.findElements(
//			        By.xpath("//li[normalize-space()='size must be between 11 and 21']")
//			);
//
//			if (elements.size() > 0) {
//			    System.out.println("Validation Text is present when phone number exceeds the limit - PASS");
//			} else {
//			    System.out.println("Validation Text not  present ");
//
//			}
			
	       
	}
			
}
