package pkg1;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DDF_Facebook 
{
	 ChromeDriver driver;
	@BeforeMethod
  public void browerLaunch()
  {
	  System.setProperty("webdriver.chrome.driver","../Practice/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();
  }
  @Test(dataProvider="dp2")
  public void facebook_Test(String Email_Id,String Password) throws InterruptedException
  {

		Thread.sleep(2000);
	  	driver.findElement(By.id("email")).sendKeys(Email_Id);
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.navigate().refresh();
 }
  @DataProvider
	public Object[][] dp2() throws BiffException, IOException {
		File file = new File("../Practice/facebook_data.xls");
		// FileReader fr = new FileReader(file);
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sheet = wb.getSheet(0);
		int r = sheet.getRows();
		int c = sheet.getColumns();
		Object[][] ob = new Object[r][c];
		System.out.println("Welcome");
		for (int i = 1; i < r; i++) {
			for (int j = 0; j < c; j++) {
				Cell cell = sheet.getCell(j, i);
				ob[i][j] = cell.getContents();
			}
		}
		return ob;
	}
  @AfterMethod
  public void tearDown()
  {
	  driver.close();
  }



}
