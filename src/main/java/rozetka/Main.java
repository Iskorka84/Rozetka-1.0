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
            rozetkaPage.goToPaginationArea();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToThePreviousPage();
            rozetkaPage.goToPaginationArea();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToPageByNumber(5);
            rozetkaPage.goToPaginationArea();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToPageByNumber(8);
            rozetkaPage.goToPaginationArea();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToPageByNumber(67);
            rozetkaPage.goToPaginationArea();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", pagination);

            rozetkaPage.goToPageByNumber(1);

            rozetkaPage.loadPage();

            FilterPage filterPage = new FilterPage(chromeDriver);
            WebElement filter = filterPage.goToFilterMenu();
            chromeDriver.executeScript("arguments[0].scrollIntoView(true);", filter);
            filterPage.filteringBySellerRozetka();
            System.out.println(filterPage.verifySearchResult().getText());




        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(chromeDriver != null) {
                chromeDriver.quit();
            }
        }
    }
}
