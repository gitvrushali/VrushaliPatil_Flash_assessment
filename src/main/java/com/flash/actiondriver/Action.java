package com.flash.actiondriver;



	
	import java.io.File;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.Date;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import com.flash.base.BaseClass;



	public class Action extends BaseClass {

		public static void implicitWait(WebDriver driver, int timeOut) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		public void explicitWait(WebDriver driver, WebElement element, Duration timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		
	
		public static boolean switchToFrameByIndex(WebDriver driver,int index) {
			boolean flag = false;
			try {
				driver.switchTo().frame(index);
				flag = true;
				return true;
			} catch (Exception e) {

				return false;
			} finally {
				if (flag) {
					System.out.println("Frame with index \"" + index + "\" is selected");
				} else {
					System.out.println("Frame with index \"" + index + "\" is not selected");
				}
			}
		}
		
		
		
		public static  boolean switchToFrameByName(WebDriver driver,String nameValue) {
			boolean flag = false;
			try {
				driver.switchTo().frame(nameValue);
				flag = true;
				return true;
			} catch (Exception e) {

				return false;
			} finally {
				if (flag) {
					System.out.println("Frame with Name \"" + nameValue + "\" is selected");
				} else if (!flag) {
					System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
				}
			}
		}

		
		
		
		
		
		public void click(WebDriver driver, WebElement ele) {
		}

		public boolean switchToNewWindow(WebDriver driver) {
			boolean flag = false;
			try {

				Set<String> s = driver.getWindowHandles();
				Object popup[] = s.toArray();
				driver.switchTo().window(popup[1].toString());
				flag = true;
				return flag;
			} catch (Exception e) {
				flag = false;
				return flag;
			} finally {
				if (flag) {
					System.out.println("Window is Navigated with title");
				} else {
					System.out.println("The Window with title: is not Selected");
				}
			}
		}

		public boolean switchToOldWindow(WebDriver driver) {
			boolean flag = false;
			try {

				Set<String> s = driver.getWindowHandles();
				Object popup[] = s.toArray();
				driver.switchTo().window(popup[0].toString());
				flag = true;
				return flag;
			} catch (Exception e) {
				flag = false;
				return flag;
			} finally {
				if (flag) {
					System.out.println("Focus navigated to the window with title");
				} else {
					System.out.println("The Window with title: is not Selected");
				}
			}
		}
		
		
		public static boolean switchToFrameById(WebDriver driver,String idValue) {
			boolean flag = false;
			try {
				driver.switchTo().frame(idValue);
				flag = true;
				return true;
			} catch (Exception e) {

				e.printStackTrace();
				return false;
			} finally {
				if (flag) {
					System.out.println("Frame with Id \"" + idValue + "\" is selected");
				} else {
					System.out.println("Frame with Id \"" + idValue + "\" is not selected");
				}
			}
		}
		
		
		
		

		public void mouseOverElement(WebDriver driver, WebElement element) {
			boolean flag = false;
			try {
				new Actions(driver).moveToElement(element).build().perform();
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (flag) {
					System.out.println(" MouserOver Action is performed on ");
				} else {
					System.out.println("MouseOver action is not performed on");
				}
			}
		}

		public boolean type(WebElement ele, String name) {
			boolean flag = false;
			try {
				flag = ele.isDisplayed();
				ele.clear();
				ele.sendKeys(name);
				// logger.info("Entered text :"+text);
				flag = true;
			} catch (Exception e) {
				System.out.println("Location Not found");
				flag = false;
			} finally {
				if (flag) {
					System.out.println("Successfully entered value");
				} else {
					System.out.println("Unable to enter value");
				}

			}
			return flag;
		}

		public static boolean click1(WebElement locator, String locatorName) {
			boolean flag = false;
			try {
				locator.click();
				flag = true;
				return true;
			} catch (Exception e) {
				return false;
			} finally {
				if (flag) {
					System.out.println("Able to click on \"" + locatorName + "\"");
				} else {
					System.out.println("Click Unable to click on \"" + locatorName + "\"");
				}
			}

		}

		
		

		public static boolean mouseHoverByJavaScript(WebElement ele) {
			boolean flag = false;
			try {
				WebElement mo = ele;
				String javaScript = "var evObj = document.createEvent('MouseEvents');"
						+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
						+ "arguments[0].dispatchEvent(evObj);";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(javaScript, mo);
				flag = true;
				return true;
			}

			catch (Exception e) {

				return false;
			} finally {
				if (flag) {
					System.out.println("MouseOver Action is performed");
				} else {
					System.out.println("MouseOver Action is not performed");
				}
			}
		}
		
		
		public boolean JSClick(WebDriver driver, WebElement ele) {
			boolean flag = false;
			try {
				// WebElement element = driver.findElement(locator);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", ele);
				// driver.executeAsyncScript("arguments[0].click();", element);

				flag = true;

			}

			catch (Exception e) {
				throw e;

			} finally {
				if (flag) {
					System.out.println("Click Action is performed");
				} else if (!flag) {
					System.out.println("Click Action is not performed");
				}
			}
			return flag;
		}

		public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
			driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		}

		public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
		}

		public String screenShot(WebDriver driver, String filename) {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;
		}
	}


