package rozetka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = null;
        try {
            chromeDriver = new ChromeDriver();
            RozetkaPage rozetkaPage = new RozetkaPage(chromeDriver);
            rozetkaPage.loadPage();

            chromeDriver.manage().window().fullscreen();

            WebElement pagination = rozetkaPage.goToPaginationArea();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToTheNextPage();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToThePreviousPage();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToPageByNumber(5);
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToPageByNumber(8);
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToPageByNumber(67);
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToPageByNumber(1);
 //           chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            FilterPage filter = new FilterPage(chromeDriver);
            filter.filteringBySellerRozetka();
            System.out.println(filter.verifySearchResult().getText());




        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(chromeDriver != null) {
                chromeDriver.quit();
            }
        }
    }
}
