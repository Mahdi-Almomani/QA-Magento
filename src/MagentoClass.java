import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class MagentoClass {

	WebDriver driver = new EdgeDriver();
	String[] FirstNameRand = { "Mahdi", "Mohammad", "Dawoud", "Almomani", "Braa" };

	String[] LastNameRand = { "Ali", "Ahmad", "Anas", "Faisal", "Osaid" };

	// String [] EmailRand=
	// {"Mahdi@gmail.com","Mohammad@gmail.com","Dawoud@gmail.com","Ali@gmail.com"};
	Random rand = new Random();
	int index = rand.nextInt(0, 5);

	int EmailIndex = rand.nextInt(0, 200);
	String emailUser = "user";
	String EmailComplete = "@gmail.com";

	Assertion myAssert = new Assertion();
	String MainWebSite = "https://magento.softwaretestingboard.com/";
	String SignUpWebSite = "https://magento.softwaretestingboard.com/customer/account/create/";
	String SignInSite = "https://magento.softwaretestingboard.com/customer/account/login/";
	String SignOut = "https://magento.softwaretestingboard.com/customer/account/logout/";
	String MutualPassword = "Mahdi1234@@2";
	String EmailUsed;

	@BeforeTest
	public void MgentoBeforeTest() {
		driver.get(MainWebSite);

		driver.manage().window().maximize();
	}

//	@Test(description = "Test 1")
//	public void TestASignUp() throws InterruptedException {
//		driver.get(SignUpWebSite);
//
//		WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
//		FirstName.sendKeys(FirstNameRand[index]);
//
//		WebElement LastName = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
//		LastName.sendKeys(LastNameRand[index]);
//
//		WebElement Email = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
//		Email.sendKeys(emailUser + EmailIndex + EmailComplete);
//
//		EmailUsed = emailUser + EmailIndex + EmailComplete;
//
//		WebElement Password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
//		Password.sendKeys(MutualPassword);
//
//		WebElement ConfirmPassword = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
//		ConfirmPassword.sendKeys(MutualPassword);
//
//		Thread.sleep(2000);
//		WebElement Create = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
//		Create.click();
//		Thread.sleep(2000);
//		driver.get(SignOut);
//
//	}

	// user11@gmail.com Mahdi1234@@2 Mahdi Ali
	@Test(description = "Test 2")
	public void TestBSignIn() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(SignInSite);

		WebElement EmailLogin = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		EmailLogin.sendKeys("user156@gmail.com");
		// EmailLogin.sendKeys(EmailUsed);

		WebElement PasswordLogin = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		PasswordLogin.sendKeys(MutualPassword);

		Thread.sleep(2000);

		WebElement SignInButton = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		SignInButton.click();
	}

//	@Test(description = "Test 3")
//	public void TestCSearchForIteams() throws InterruptedException {
//		driver.get(MainWebSite);
//		String[] RandomlyIteams = { "Jacket", "t-shirt", "jeans for men", " jeans for women", "pants" };
//
//		WebElement SearchBar = driver.findElement(By.xpath("//*[@id=\"search\"]"));
//		Thread.sleep(2000);
//		String IteamsRandomly = RandomlyIteams[index] + Keys.ENTER;
//
//		SearchBar.sendKeys(IteamsRandomly);
//		System.out.println(IteamsRandomly);
//
//	}
	@Test(description = "Test 4")
	public void TestDAddIteams() throws InterruptedException {

		String[] IteamsPages = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html",
				"https://magento.softwaretestingboard.com/fusion-backpack.html" };
		for (int i = 0; i < IteamsPages.length; i++) {
			driver.get(IteamsPages[i]);
			Thread.sleep(2000);

			if (driver.getCurrentUrl().contains("radiant")) {
				WebElement Qty = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Qty.clear();
				Qty.sendKeys("3");
				
				WebElement colors = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));

				List<WebElement> color = colors.findElements(By.tagName("div"));
				int randomIndexColor = rand.nextInt(0, color.size());

				color.get(randomIndexColor).click();
				
				WebElement Size = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));

				List<WebElement> Sizes = Size.findElements(By.tagName("div"));
				int randomIndex = rand.nextInt(0, Sizes.size());
				Sizes.get(randomIndex).click();

				

				WebElement AddToChart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToChart.click();
				Thread.sleep(3000);

			} else if (driver.getCurrentUrl().contains("breathe")) {
				WebElement Qty = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Qty.clear();
				Qty.sendKeys("2");
				
				WebElement colors = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));

				List<WebElement> color = colors.findElements(By.tagName("div"));
				int randomIndexColor = rand.nextInt(0, color.size());

				color.get(randomIndexColor).click();

				
				WebElement Size = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));

				List<WebElement> Sizes = Size.findElements(By.tagName("div"));
				int randomIndex = rand.nextInt(0, Sizes.size());
				Sizes.get(randomIndex).click();

			

				WebElement AddToChart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToChart.click();
				Thread.sleep(3000);
			}

			else if (driver.getCurrentUrl().contains("argus")) {
				

				WebElement Qty = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Qty.clear();
				Qty.sendKeys("4");
				
				
				WebElement colors = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));

				List<WebElement> color = colors.findElements(By.tagName("div"));
				int randomIndexColor = rand.nextInt(0, color.size());

				color.get(randomIndexColor).click();
				
				WebElement Size = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));

				List<WebElement> Sizes = Size.findElements(By.tagName("div"));
				int randomIndex = rand.nextInt(0, Sizes.size());
				Sizes.get(randomIndex).click();
				

				WebElement AddToChart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToChart.click();
				Thread.sleep(3000);

			} else if (driver.getCurrentUrl().contains("hero")) {
				
				WebElement Qty = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Qty.clear();
				Qty.sendKeys("1");
				
				WebElement colors = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));

				List<WebElement> color = colors.findElements(By.tagName("div"));
				int randomIndexColor = rand.nextInt(0, color.size());
				color.get(randomIndexColor).click();
				
				WebElement Size = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));

				List<WebElement> Sizes = Size.findElements(By.tagName("div"));
				int randomIndex = rand.nextInt(0, Sizes.size());
				Sizes.get(randomIndex).click();
				
				
				WebElement AddToChart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToChart.click();
				Thread.sleep(3000);
			} else if (driver.getCurrentUrl().contains("fusion")) {

				WebElement Qty = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Qty.clear();
				Qty.sendKeys("5");

				WebElement AddToChart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToChart.click();
				Thread.sleep(3000);
			}

		}

	}

	@AfterTest
	public void MagentoAfterTest() {

	}

}
