package org.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void url(String url) {
		driver.get(url);
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}

	public static void closeEntireBrowser() {
		driver.quit();
	}

	public static Actions a;

	public static void movecursor(WebElement Target) {
		a = new Actions(driver);
		a.moveToElement(Target).perform();
	}
	
	public static void click(WebElement ele) {
		ele.click();
	}

	public static void dragdrop(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement);
	}

	public void classScreenShot() throws IOException {

		TakesScreenshot shot = (TakesScreenshot) driver;
		File image = shot.getScreenshotAs(OutputType.FILE);
		File f = new File(" Here Paste commonio link\\.png");
		FileUtils.copyFile(image, f);
		;

	}

	public void classHandling() {
		System.setProperty("webdriver.chrome.driver", "");
		WebDriver w = new ChromeDriver();
		w.get("");
		w.manage().window().maximize();
		WebElement itre = w.findElement(By.xpath(""));
		String one = w.getWindowHandle();
		Set<String> two = w.getWindowHandles();

		for (String s : two) {
			if (s != one) {
				w.switchTo().window(s);
			}
		}
	}

	public static Robot r;

	public static void key() throws AWTException {
		r = new Robot();
	}

	public static JavascriptExecutor js;

	public static void scrollDown(WebElement down) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntiView(true)", down);
	}

	public static void scrollUp(WebElement up) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", up);
	}

	public static void sendKey(WebElement send) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','')", send);
	}

	public static void getValue(WebElement get) {
		js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute(value)", get);
	}

	public static Alert al;

	public void classAlert() {

		al = new Alert() {

			@Override
			public void sendKeys(String keysToSend) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void dismiss() {
				// TODO Auto-generated method stub

			}

			@Override
			public void accept() {
				// TODO Auto-generated method stub

			}
		};

	}

	private void classDragDrop() {
		System.setProperty("webdriver.chrome.driver", "");
		WebDriver w = new ChromeDriver();
		w.get("");
		w.manage().window().maximize();
		WebElement itre = w.findElement(By.xpath(""));

		Select s = new Select(itre);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
		s.selectByIndex(0);
		s.selectByVisibleText("balck color text");
		s.selectByValue(" value ex: id (or)name");

		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			WebElement all = allSelectedOptions.get(i);
			String text = all.getText();
			System.out.println(text);
		}
		s.deselectAll();
	}

	public void classDataDrivn() throws FileNotFoundException {

		File f = new File(" sheet location ");
		FileInputStream in = new FileInputStream(f);
		Workbook book = new XSSFWorkbook();
		Sheet s = book.getSheet("paste sheet name");
		Row row = s.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell);
	}

	public void classDataDriven2(String sheetName, int rowNum, int cellNum) throws FileNotFoundException {
		File f = new File(" sheet location ");
		FileInputStream in = new FileInputStream(f);
		Workbook book = new XSSFWorkbook();
		Sheet s = book.getSheet(sheetName);
		Row row2 = s.getRow(rowNum);
		Cell cell2 = row2.getCell(cellNum);

		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row = s.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType == 1) {
					String stvalue = cell2.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(cell2)) {
					Date dtvalue = cell2.getDateCellValue();

					SimpleDateFormat dt = new SimpleDateFormat("dd/MMM/yyyy");
					String format = dt.format(dtvalue);
				} else {
					double d = cell2.getNumericCellValue();

					long l = (long) d;
					String valueOf = String.valueOf(l);
				}
			}
		}
	}

	public static void createNewExcel(int rowNum, int cellNum, String newData) throws IOException {

		File f = new File("C:\\Users\\abiseik\\eclipse-workspace\\DdrivenModule\\Excel\\Createclas.xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("Driven1");
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(newData);
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
	}

	public  static void createCell( int rowNum , int cellNum , String newData) throws IOException {
		File f = new File("C:\\Users\\abiseik\\eclipse-workspace\\DdrivenModule\\Excel\\Createclas.xlsx");
		FileInputStream in = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(in);
		Sheet sheet = book.getSheet("Driven1");
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		
		cell.setCellValue(newData);
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
	}
	public static void createRow( int createRow , int CreateCell , String data ) throws IOException {
		File f = new File("C:\\Users\\abiseik\\eclipse-workspace\\DdrivenModule\\Excel\\Createclas.xlsx");
		FileInputStream in = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(in);
		Sheet sheet = book.getSheet("Driven1");
		Row row = sheet.createRow(createRow);
		Cell cell = row.createCell(CreateCell);
		
		cell.setCellValue(data);
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
	}
	public static void updateCell(int gettherow,int getthecell, String oldData, String writeNewData) throws IOException {
		File f = new File("C:\\Users\\abiseik\\eclipse-workspace\\DdrivenModule\\Excel\\Createclas.xlsx");
		FileInputStream in = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(in);
		Sheet sheet = book.getSheet("Driven1");
		Row row = sheet.getRow(gettherow);
		Cell cell = row.getCell(getthecell);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(writeNewData);
		}
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
	}
}
