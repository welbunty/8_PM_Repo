package pkg1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenTesting {
	@Test(dataProvider = "dp2")
	public void testcase1(String username, String password) {
		if((username!=null)&&(password!=null))
		{
			System.out.println(username);
			System.out.println(password);
		}
		
		
	}

	/*@DataProvider
	public Object[][] dp1()// Array of Object
	{
		Object[][] ob = new Object[3][2];
		ob[0][0] = "user1";
		ob[0][1] = "password1";
		ob[1][0] = "user2";
		ob[1][1] = "password2";
		ob[2][0] = "user3";
		ob[2][1] = "password3";
		return ob;
	}*/

	@DataProvider
	public Object[][] dp2() throws BiffException, IOException {
		File file = new File("../Practice/DDF_Data.xls");
		// FileReader fr = new FileReader(file);
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sheet = wb.getSheet(0);
		int r = sheet.getRows();
		int c = sheet.getColumns();
		Object[][] ob = new Object[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				Cell cell = sheet.getCell(j, i);
				ob[i][j] = cell.getContents();
			}
		}
		return ob;
	}
}


