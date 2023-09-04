import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.util.Random;

public class RUN {

    public static void main(String[] args) {


        System.setProperty("webdriver.edge.driver", "D:\\MicrosoftWebDriver.exe");

        EdgeOptions options = new EdgeOptions();
        RemoteWebDriver driver = new EdgeDriver(options);


        driver.get("https://appdev.bnisekuritas.co.id/sop/sop-workspace");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'button_icon') and contains(@class, 'menu__toggle') and contains(@class, 'button_icon__secondary') and contains(@class, 'button_icon__md') and span[@class='material_icons_outlined' and text()='menu']]")));
        dev1.click();
        WebElement dev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Network']")));
        dev2.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException f) {
            f.printStackTrace();
            Thread.currentThread().interrupt();
        }
        WebElement dev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/aside/div/div[1]/div[6]/div/div[1]/div[2]/div/div/div[1]/div[2]")));
        dev3.click();
        WebElement dev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Development']")));
        dev4.click();
        dev1.click();
        ExtentReports extent = new ExtentReports();
        ExtentTest makerAddEx = extent.createTest("MAKER", "Description of Test Scenario MAKER ADD");
        ExtentTest makerEditEx = extent.createTest("MAKER EDIT", "Description of Test Scenario MAKER EDIT");
        ExtentTest checkerEx = extent.createTest("CHECKER", "Description of Test Scenario CHECKER");


        for (int i = 0; i < 100; i++) {
            String characters = "0123456789";
            StringBuilder randomString = new StringBuilder();
            Random random = new Random();
            int length = 6;
            for (int d = 0; d < length; d++) {
                int index = random.nextInt(characters.length());
                randomString.append(characters.charAt(index));
            }
            String namadokument = "Dokument Test "+randomString;
            MAKER.add(driver, makerAddEx, "sop.maker@mail.com", "password", namadokument, "IT", "C");
            CHECKER.ck(driver, checkerEx, "sop.checker@mail.com", "password", namadokument, "APPROVE");
            CHECKER.ck(driver, checkerEx, "sop.app@mail.com", "password", namadokument, "APPROVE");

        }
    }
}