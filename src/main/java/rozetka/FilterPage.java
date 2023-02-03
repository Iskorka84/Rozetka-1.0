package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage {
    public final WebDriver driver;

    private static final By ROZETKA_SELLER = By.xpath("//a[@data-id='Rozetka']");
    private static final By OTHER_SELLERS = By.xpath("//a[@data-id='Інші продавці']");
    private static final By SELECTION_RESULT = By.xpath("//p[@class='catalog-selection__label ng-star-inserted']");

    public FilterPage (WebDriver driver) {
        this.driver = driver;
    }

    public void filteringBySellerRozetka () {
        driver.findElement(ROZETKA_SELLER).click();
    }

    public void filteringByOtherSellers () {
        driver.findElement(OTHER_SELLERS).click();
    }

    public WebElement verifySearchResult() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(SELECTION_RESULT));
    }

}
