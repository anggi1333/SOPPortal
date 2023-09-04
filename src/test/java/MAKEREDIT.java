import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MAKEREDIT {
    public static void ed(WebDriver driver, ExtentTest extentTest, String email, String password, String title) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement txtemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        WebElement txtpw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));

        txtemail.sendKeys(email);
        txtpw.sendKeys(password);
        txtpw.sendKeys(Keys.ENTER);


        try {
            Thread.sleep(1500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement note1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light') and contains(@class, 'Toastify__toast--success') and contains(@class, 'Toastify__toast--close-on-click')]")));
        String note1txt = note1.getText();
        System.out.println(note1txt + " User : " + email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast')]")));

        // Check if the close button is visible
        By closeButtonLocator = By.xpath("//button[contains(@class, 'Toastify__close-button') and contains(@class, 'Toastify__close-button--light') and @type='button']");
        WebElement closeButton = driver.findElement(closeButtonLocator);

        if (closeButton.isDisplayed()) {
            closeButton.click();

        } else {

        }

        WebElement sop1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Standard Operations Procedure']")));
        sop1.click();
        WebElement sopworkspace = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/sop/sop-workspace']")));
        sopworkspace.click();


        WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-tag='allowRowEvents']/div/button[2])[1]")));
        edit.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement titletxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-formid='title']/input")));
        String titletxt2 = titletxt.getAttribute("value");
        WebElement agrement = driver.findElement(By.xpath("//*[@class='form_sop_document p-3']/div[14]/input"));
        agrement.click();
        WebElement sumbit = driver.findElement(By.xpath("//*[text()='Submit']"));
        sumbit.click();
        WebElement sumbit2 = driver.findElement(By.xpath("//*[@aria-labelledby='swal2-title']/div[6]/button[1]"));
        sumbit2.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement note2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light') and contains(@class, 'Toastify__toast--success') and contains(@class, 'Toastify__toast--close-on-click')]")));
        String note2txt = note2.getText();
        System.out.println(note2txt +" Doc Name : "+titletxt2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast')]")));
        By closeButtonLocator2 = By.xpath("//button[contains(@class, 'Toastify__close-button') and contains(@class, 'Toastify__close-button--light') and @type='button']");
        WebElement closeButton2 = driver.findElement(closeButtonLocator2);
        if (closeButton2.isDisplayed()) {
            closeButton2.click();
        } else {
        }
        WebElement dev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'button_icon') and contains(@class, 'menu__toggle') and contains(@class, 'button_icon__secondary') and contains(@class, 'button_icon__md') and span[@class='material_icons_outlined' and text()='menu']]")));
        dev1.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement logout = driver.findElement(By.xpath("//*[text()='Sign Out']"));
        logout.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement note3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light') and contains(@class, 'Toastify__toast--success') and contains(@class, 'Toastify__toast--close-on-click')]")));
        String note3txt = note3.getText();
        System.out.println(note3txt +" User : "+email);
        By closeButtonLocator3 = By.xpath("//button[contains(@class, 'Toastify__close-button') and contains(@class, 'Toastify__close-button--light') and @type='button']");
        WebElement closeButton3 = driver.findElement(closeButtonLocator3);

        if (closeButton3.isDisplayed()) {
            closeButton3.click();

        } else {

        }
        System.out.println("------------------------------------------");
    }
}