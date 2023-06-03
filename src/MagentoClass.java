import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class MagentoClass {

	WebDriver driver = new ChromeDriver();
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
	String SignOut="https://magento.softwaretestingboard.com/customer/account/logout/";
	String MutualPassword = "Mahdi1234@@2";
	String EmailUsed;

	@BeforeTest
	public void MgentoBeforeTest() {
		driver.get(MainWebSite);

		driver.manage().window().maximize();
	}

	@Test(description = "Test 1")
	public void TestASignUp() throws InterruptedException {
		driver.get(SignUpWebSite);

		WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		FirstName.sendKeys(FirstNameRand[index]);
		
		WebElement LastName = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
		LastName.sendKeys(LastNameRand[index]);
		
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
		Email.sendKeys(emailUser+EmailIndex+EmailComplete);
		
		EmailUsed=emailUser+EmailIndex+EmailComplete;
		
		WebElement Password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		Password.sendKeys(MutualPassword);
		
		WebElement ConfirmPassword = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
		ConfirmPassword.sendKeys(MutualPassword);
		
		Thread.sleep(2000);
		WebElement Create = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
		Create.click();
		 Thread.sleep(2000);
		 driver.get(SignOut);
		 
		
	}
	// user11@gmail.com Mahdi1234@@2 Mahdi Ali
	@Test(description = "Test 2")
	public void TestBSignIn() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		 
		driver.get(SignInSite);

		WebElement EmailLogin = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		EmailLogin.sendKeys(EmailUsed);

		WebElement PasswordLogin = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		PasswordLogin.sendKeys(MutualPassword);

		Thread.sleep(2000);

		WebElement SignInButton = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		SignInButton.click();
	}

	@Test(description = "Test 3")
	public void TestCSearchForIteams() throws InterruptedException {
		driver.get(MainWebSite);
		String[] RandomlyIteams = { "Jacket", "t-shirt", "jeans for men", " jeans for women", "pants" };

		WebElement SearchBar = driver.findElement(By.xpath("//*[@id=\"search\"]"));
		Thread.sleep(2000);
		String IteamsRandomly = RandomlyIteams[index] + Keys.ENTER;

		SearchBar.sendKeys(IteamsRandomly);
		System.out.println(IteamsRandomly);

	}
	@Test(description = "Test 4")
	public void TestDAddIteams() {
		
		
		
	}
	

	@AfterTest
	public void MagentoAfterTest() {

	}

}
