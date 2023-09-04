import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MAKER {
    public static void add(WebDriver driver, ExtentTest extentTest, String email, String password, String title, String owner, String type) {
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
        System.out.println(note1txt +" User : "+email);
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

        WebElement newitem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Create Document']")));
        newitem.click();

        WebElement txttitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-formid='title']/input")));
        txttitle.sendKeys(title);

        WebElement txtversion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-formid='version']/input")));
        txtversion.sendKeys("1.0");

        WebElement txtnumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-formid='number']/input")));
        txtnumber.sendKeys("999");

        WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-formid='category']/div[1]")));
        Actions categorya = new Actions(driver);
        categorya.click(category).perform();
        categorya.sendKeys("ANTI-FRAUD").perform();
        categorya.sendKeys(Keys.ENTER).perform();


//        WebElement txtowner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Owner(s)']/following-sibling::div/div")));
//        Actions actions = new Actions(driver);
//
//        actions.click(txtowner).perform();
//
//        String owner1 = owner;
//        if (owner1.equals("OLT")) {
//            actions.click(txtowner).perform();
//            actions.sendKeys("Online Trading").perform();
//            actions.sendKeys(Keys.ENTER).perform();
//        } else if (owner1.equals("IT")) {
//            actions.click(txtowner).perform();
//            actions.sendKeys("Information Technology").perform();
//            actions.sendKeys(Keys.ENTER).perform();
//        }else if (owner1.equals("CS")){
//            actions.click(txtowner).perform();
//            actions.sendKeys("Customer Service").perform();
//            actions.sendKeys(Keys.ENTER).perform();
//        }else{
//            actions.click(txtowner).perform();
//            actions.sendKeys("Human Capital").perform();
//            actions.sendKeys(Keys.ENTER).perform();
//        }

        if (type.equals("C")) {
            WebElement rbconfi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='confidential']")));
            rbconfi.click();
        } else if (type.equals("I")) {
            WebElement rbinter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='internal']")));
            rbinter.click();
        } else if (type.equals("P")) {
            WebElement rbinter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='public']")));
            rbinter.click();
        }



        WebElement attach = driver.findElement(By.xpath("//*[@type='file']"));
        attach.sendKeys("D:\\testing.pdf");

        try {
            Thread.sleep(500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement hod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-formid='headOfDepartmentVal']/div/div/div[2]")));
        Actions hoda = new Actions(driver);
        hoda.click(hod).perform();
        hoda.sendKeys("User Checker").perform();
        hoda.sendKeys(Keys.ENTER).perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement hoc = driver.findElement(By.xpath("//*[@data-formid='headOfComplianceVal']/div/div/div[2]"));
        Actions hoca = new Actions(driver);
        hoca.click(hoc).perform();
        hoca.sendKeys("User Approval").perform();
        hoca.sendKeys(Keys.ENTER).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement agrement = driver.findElement(By.xpath("//*[@class='form_sop_document p-3']/div[14]/input"));
        agrement.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        String desiredDate = "08/08/2023";
        WebElement initialPublish = driver.findElement(By.xpath("//*[@name=\"initialPublishDate\"]"));
        initialPublish.sendKeys(Keys.CONTROL+"a");
        initialPublish.sendKeys(Keys.BACK_SPACE);
        initialPublish.sendKeys(desiredDate);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement effective = driver.findElement(By.xpath("//*[@name=\"effectiveDate\"]"));
        effective.sendKeys(Keys.CONTROL+"a");
        effective.sendKeys(Keys.BACK_SPACE);
        effective.sendKeys(desiredDate);
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
        System.out.println(note2txt +" Doc Name : "+title);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Toastify__toast')]")));
        By closeButtonLocator2 = By.xpath("//button[contains(@class, 'Toastify__close-button') and contains(@class, 'Toastify__close-button--light') and @type='button']");
        WebElement closeButton2 = driver.findElement(closeButtonLocator2);
        if (closeButton2.isDisplayed()) {
            closeButton2.click();
        } else {
        }
        WebElement g3 = driver.findElement(By.xpath("//button[contains(@class, 'button_icon') and contains(@class, 'menu__toggle') and contains(@class, 'button_icon__secondary') and contains(@class, 'button_icon__md') and span[@class='material_icons_outlined' and text()='menu']]"));
        g3.click();
        try {
            Thread.sleep(1000);
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