import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CHECKER {
    public static void ck(WebDriver driver, ExtentTest extentTest, String email, String password, String title, String action) {
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

        By closeButtonLocator = By.xpath("//button[contains(@class, 'Toastify__close-button') and contains(@class, 'Toastify__close-button--light') and @type='button']");
        WebElement closeButton = driver.findElement(closeButtonLocator);

        if (closeButton.isDisplayed()) {
            closeButton.click();


        }

        WebElement sop1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Standard Operations Procedure']")));
        sop1.click();
        WebElement approval = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/sop/sop-approval']")));
        approval.click();
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by Title or Doc Number']")));
        search.sendKeys(title);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement view = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-tag='allowRowEvents']/div/button[2])[1]")));
        view.click();
        WebElement titletxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-formid='title']/input")));
        String titletxt2 = titletxt.getText();
        WebElement agrement = driver.findElement(By.xpath("//*[@class='form_sop_document p-3']/div[14]/input"));
        agrement.click();
        if (action.equals("APPROVE")) {
            WebElement appr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Approve']")));
            appr.click();
            WebElement sumbit2 = driver.findElement(By.xpath("//div[@class='swal2-actions']/button[1]"));
            sumbit2.click();
            WebElement note2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light') and contains(@class, 'Toastify__toast--success') and contains(@class, 'Toastify__toast--close-on-click')]")));
            String note2txt = note2.getText();
            System.out.println(note2txt + " Doc Name : " + title);
        } else if (action.equals("SENDBACK")) {
            WebElement sb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Send Back']")));
            sb.click();
            WebElement sbnote = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Notes']/following-sibling::textarea")));
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder randomString = new StringBuilder();
            Random random = new Random();
            int length = 6;
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                randomString.append(characters.charAt(index));
            }
            sbnote.sendKeys("SENBACK DOKUMENT " + randomString);
            WebElement sb2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='d-flex justify-content-between']/button[2]")));
            sb2.click();
            WebElement sb3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='swal2-actions']/button[1]")));
            sb3.click();
            WebElement note3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light') and contains(@class, 'Toastify__toast--success') and contains(@class, 'Toastify__toast--close-on-click')]")));
            String note3txt = note3.getText();
            System.out.println(note3txt+" Doc Name : "+title);
        } else {
            WebElement reject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Reject']")));
            reject.click();
            WebElement rjnote = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Notes']/following-sibling::textarea")));
            rjnote.sendKeys("REJECT DOKUMENT " + title);
            WebElement reject2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='d-flex justify-content-between']/button[2]")));
            reject2.click();
            WebElement note4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light') and contains(@class, 'Toastify__toast--success') and contains(@class, 'Toastify__toast--close-on-click')]")));
            String note4txt = note4.getText();
            System.out.println(note4txt + " Doc Name : " + title);
        }
        By closeButtonLocator4 = By.xpath("//button[contains(@class, 'Toastify__close-button') and contains(@class, 'Toastify__close-button--light') and @type='button']");
        WebElement closeButton4 = driver.findElement(closeButtonLocator4);

        if (closeButton4.isDisplayed()) {
            closeButton4.click();


        }
        WebElement dev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'button_icon') and contains(@class, 'menu__toggle') and contains(@class, 'button_icon__secondary') and contains(@class, 'button_icon__md') and span[@class='material_icons_outlined' and text()='menu']]")));
        dev1.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign Out']")));

        logout.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement note3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast-theme--light') and contains(@class, 'Toastify__toast--success') and contains(@class, 'Toastify__toast--close-on-click')]")));
        String note3txt = note3.getText();
        System.out.println(note3txt + " User : " + email);
        By closeButtonLocator3 = By.xpath("//button[contains(@class, 'Toastify__close-button') and contains(@class, 'Toastify__close-button--light') and @type='button']");
        WebElement closeButton3 = driver.findElement(closeButtonLocator3);

        if (closeButton3.isDisplayed()) {
            closeButton3.click();


        }
        System.out.println("------------------------------------------");

    }
}
