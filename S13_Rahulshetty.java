package basics;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class S13_Rahulshetty {

	public static void main(String[] args) throws InterruptedException
	
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//radio button
		
		WebElement R1 = driver.findElement(By.xpath("//input[@class='radioButton'][@value='radio1']"));
		
		R1.click();
		
		boolean radio1 = R1.isDisplayed();
				
		System.out.println("Radio1 is displayed = " + radio1);
		
	    WebElement R2 = driver.findElement(By.xpath("//input[@class='radioButton'][@value='radio2']"));
	    
	    R2.click();
		
		boolean radio2 = R2.isEnabled();
				
		System.out.println("Radio2 is enabled = " + radio2);
		
	    WebElement R3 = driver.findElement(By.xpath("//input[@class='radioButton'][@value='radio3']"));
		
	    R3.click();
	    
		boolean radio3 = R3.isSelected();
							
		System.out.println("Radio3 is selected = " + radio3);
		
		//auto complete
		
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
				
		WebElement cn = driver.findElement(By.xpath("//ul[@id='ui-id-1']//li[2]"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(cn).build().perform();
		
		act.doubleClick(cn).build().perform();
		
		//dropdown example
		
		WebElement dd = driver.findElement(By.id("dropdown-class-example"));
			
		Select sel = new Select(dd);
		
		sel.selectByValue("option3");
		
		//checkbox example
		
		WebElement C1 = driver.findElement(By.id("checkBoxOption1"));
		
		C1.click();
		
		boolean Checkbox1 = C1.isEnabled();
		
		System.out.println("Checkbox is enabled = " + Checkbox1);
		
		
		WebElement C2 = driver.findElement(By.id("checkBoxOption2"));
		
		C2.click();
		
		boolean Checkbox2 = C2.isDisplayed();
		
		System.out.println("Checkbox is displayed = " + Checkbox2);
		
		
		WebElement C3 = driver.findElement(By.id("checkBoxOption3"));
		
		C3.click();
		
		boolean Checkbox3 = C3.isSelected();
		
		System.out.println("Checkbox is selected = " + Checkbox3);
		
		//switchwindow
		
			
		String parentwindow = driver.getWindowHandle();
		
		driver.findElement(By.id("openwindow")).click();
		
        Set<String> childWindow = driver.getWindowHandles();
		
		
		for(String child   : childWindow)
		{
			if(!parentwindow.equals(child))
			{
				driver.switchTo().window(child);
				
				Thread.sleep(3000);
				
				System.out.println("Child window title =" + driver.getTitle());
				
				driver.findElement(By.linkText("Access all our Courses"));
				
				driver.close();
							
			}
		}
		
		driver.switchTo().window(parentwindow);
	
		// Switch tab
				
		driver.findElement(By.id("opentab")).click();
		
		Set<String> childwindow = driver.getWindowHandles();
						
		for(String child   : childwindow)
		{
			if(!parentwindow.equals(child))
			{
				driver.switchTo().window(child);
				
				Thread.sleep(3000);
				
				driver.navigate().refresh();
								
				Thread.sleep(3000);
				
				driver.findElement(By.linkText("Access all our Courses"));
				
				driver.close();
							
			}
		}
		
		driver.switchTo().window(parentwindow);
		
		//switch to alert popup
		
		driver.findElement(By.id("name")).sendKeys("Pavithra");
		
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alt = driver.switchTo().alert();
		
		alt.accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		
		Alert alt1 = driver.switchTo().alert();
		
		alt1.dismiss();
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,200)");
		
		Thread.sleep(3000);
		
		//webtable
		
		String tableheader = driver.findElement(By.xpath("(//table[@id='product']/tbody/tr[1])[1]")).getText();
		
		System.out.println(tableheader);
		
		String column1 = driver.findElement(By.xpath("(//table[@id='product']/tbody/tr[2])[1]")).getText();
		
		System.out.println("===============");
		
		System.out.println(column1);
		
		System.out.println("===============");
		
		System.out.println("webtable");
		
		List<WebElement> li = driver.findElements(By.xpath("(//table[@id='product']/tbody)[1]"));
		
		for(WebElement aa : li)
		{
			System.out.println(aa.getText());
			
		}
		
		//Element Displayed Example
		
		driver.findElement(By.id("displayed-text")).sendKeys("pavithra");
		
		driver.findElement(By.id("hide-textbox")).click();
		
		driver.findElement(By.id("show-textbox")).click();
		
		//Web Table Fixed header 2
		
		System.out.println("================================================");
		
				
		List<WebElement> list = driver.findElements(By.xpath("(//table[@id='product']/tbody)[2]"));
		
		for(WebElement aa : list)
			
		{
			System.out.println(aa.getText());
		}
		
		System.out.println("================================================");
		
		//mousehover
		
		js.executeScript("window.scroll(0,800)");
		
		Thread.sleep(3000);
		
		WebElement mh = driver.findElement(By.id("mousehover"));
		
		String mhtext = mh.getText();
		
		System.out.println(mhtext);
						
		act.moveToElement(mh).build().perform();
			
		
		WebElement mht = driver.findElement(By.linkText("Top"));
		
		act.moveToElement(mht).build().perform();
		
		act.click(mht).build().perform();
		
		js.executeScript("window.scroll (0,800)");
		
		Thread.sleep(3000);
		
		act.moveToElement(mh).build().perform();
						
		WebElement mhr = driver.findElement(By.linkText("Reload"));
		
		act.moveToElement(mhr).build().perform();
		
		act.click(mhr).build().perform();
					
		js.executeScript("window.scroll(0,700)");
		
		Thread.sleep(3000);
		
		js.executeScript("window.scroll(0,1300)");
		
		//iframe
		
		driver.switchTo().frame("courses-iframe");
				
		Thread.sleep(3000);
		
		js.executeScript("window.scroll(0,100)");
		
		List<WebElement> iframelinks = driver.findElements(By.tagName("a"));
		
		System.out.println(iframelinks.size());
		
		for(int i=0; i<iframelinks.size(); i++)
			
		{
			String Iframelinks = iframelinks.get(i).getText();
			
			
			System.out.println(Iframelinks);
		}
		
//		WebElement more = driver.findElement(By.xpath("(//a[text()='More '])[2]"));
//		
//		act.moveToElement(more).build().perform();
		
//		Thread.sleep(3000);
//		
//		WebElement aboutus = driver.findElement(By.xpath("(//a[text()='About us'])[2]"));
//		
//		act.moveToElement(aboutus).build().perform();
//		
//		Thread.sleep(1000);
//		
//		act.click(aboutus).build().perform();
//		
//		
//		String aboutuspara = driver.findElement(By.className("about-us-para")).getText();
//				
//		System.out.println(aboutuspara);
		
		driver.switchTo().defaultContent();
		
		
		
	}

}
