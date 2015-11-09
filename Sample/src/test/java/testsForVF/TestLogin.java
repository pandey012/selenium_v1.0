package testsForVF;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestLogin {
	private WebDriver driver = null;

	
	public void testLogin() throws InterruptedException {
		//fail("Not yet implemented");
		
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://cbrands--edgeforce--c.cs11.visual.force.com/apex/CBI_Home?sfdc.tabName=01rG0000000fTpR");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 driver.findElement(By.xpath("//*[@id='username']")).clear();;

		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("himanshu.pandey@cbrands.com.ta");
		driver.findElement(By.xpath("//*[@id='password']")).clear();;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("TestAdmin123");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("Login")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		assertEquals(driver.findElement(By.id("welcome")).getText(),"WELCOME TESTADMIN USER" );
		
		
	}
	
	public void testSearch()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='srch-term']")).sendKeys("news");
		driver.findElement(By.xpath("//*[@id='quicklinks-search']/div/div[1]/button")).click();
		assertEquals(driver.findElement(By.xpath("//*[@id='main-content']/div[1]/div/h2")).getText(),"SEARCH RESULTS");
		
	}
	
	public void testHopePageBrowse()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.className("navbar-brand")).click();
		assertEquals(driver.findElement(By.id("welcome")).getText(),"WELCOME TESTADMIN USER" );
	}
	

	/*public void testQuickLinks()
	{
		driver.findElement(By.xpath("//*[@id='quicklinks-search']/div/div[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='quicklinks-search']/div/div[3]/ul/li/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='modal-edit-quicklinks']/div/div/div[2]/ul/li[1]/div/div[2]/div/div[1]/input")).sendKeys("Test Link 1");
		driver.findElement(By.xpath("//*[@id='modal-edit-quicklinks']/div/div/div[2]/ul/li[1]/div/div[2]/div/div[2]/input")).sendKeys("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='modal-edit-quicklinks']/div/div/div[3]/button[2]")).click();	
		
	}
	*/
	public void testEmpDirectory()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='directory']/a")).click();	
		assertEquals(driver.findElement(By.xpath("//*[@id='main-content']/ol/li[2]")).getText(),"Employee Directory");
		
		
	}
	
	public void testTODO()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='main-content']/div/section[2]/h3/a")).click();
		assertEquals(driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div/h2")).getText(),"TO DOs");
		
		
	}
	
	public void testNewsPage()
	{
		driver.findElement(By.xpath("//*[@id='main-content']/div/section[1]/h3/a")).click();	
		assertEquals(driver.findElement(By.xpath("/html/body/div[1]/form/span/div/div/div[1]/div/h2/span")).getText(),"NEWS");
		
	}

	@Test
	public void CRconfiguration() throws Exception {
	    System.setProperty("webdriver.chrome.driver","/Users/Himanshu/Desktop/selenium/chromedriver");
	   
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--start-maximized");
	    driver = new ChromeDriver(options);
	    testLogin();
	    testSearch();
	    testHopePageBrowse();
	    testEmpDirectory();
	    testHopePageBrowse();
	    testTODO();
	    testHopePageBrowse();
		testNewsPage();
	    driver.close();
	}
	
	@Test
	public void safariDriver() throws InterruptedException
	{
			//Safari Driver will be installed in the browser itself. 
		    driver = new SafariDriver();
		    testLogin();
		    testSearch();
		    testHopePageBrowse();
		    testEmpDirectory();
		    testHopePageBrowse();
		    testTODO();
		    testHopePageBrowse();
			testNewsPage();
		    driver.close();
	}
	
	@Test
	public void ffDriver() throws InterruptedException
	{
		//Firefox driver comes default with jUnit. 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		testLogin();
		testSearch();
		testHopePageBrowse();
		testEmpDirectory();
		testHopePageBrowse();
		testTODO();
		testHopePageBrowse();
		testNewsPage();
		driver.close();
	}

}
