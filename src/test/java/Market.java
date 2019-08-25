import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Market extends BaseTest {
    private static final Logger logger = LogManager.getLogger(Market.class);


    @Test
    public void tasks() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://market.yandex.kz/");
        logger.info("OPEN https://market.yandex.kz/");
        driver.findElement(By.xpath("//a[@href='/catalog--elektronika/54440']")).click();
        driver.findElement(By.xpath("//a[@href='/catalog--smartfony-v-almaty/16814639/list?glfilter=16816262%3A16816264&hid=91491']")).click();

        driver.findElement(By.xpath("//span[text()='Xiaomi']")).click();
        driver.findElement(By.xpath("//*[@class=\"link link_theme_major n-filter-sorter__link i-bem link_js_inited\"]")).click();


        WebElement searchContainer = driver.findElement(By.cssSelector("div.n-snippet-list")); // все карточки телефонов
        List<WebElement> cards = searchContainer.findElements(By.cssSelector("div.n-snippet-cell2")); // список карточек телефонов
        WebElement card1 = cards.get(0);
        card1.findElement(By.cssSelector("div.n-product-toolbar__item")).click();
//        String infoText1 = driver.findElement(By.cssSelector(".popup-informer__title")).getText();
//        assertThat(infoText1, containsString("добавлен к сравнению"));

//        WebElement element = driver.findElement(By.cssSelector("div.image_name_close"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().perform();

//        Wait explicitWait = new WebDriverWait(driver, 7);
//        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.image_name_close")));
//        driver.findElement(By.cssSelector("div.image_name_close")).click();

        WebElement card2 = cards.get(1);
        card2.findElement(By.cssSelector("div.n-product-toolbar__item")).click();
//        String infoText2 = driver.findElement(By.cssSelector(".popup-informer__title")).getText();
//        assertThat(infoText2, containsString("добавлен к сравнению"));
////        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.image_name_close")));
//        driver.findElement(By.cssSelector("div.image_name_close")).click();

        driver.findElement(By.xpath("//a[@href='/compare?track=head']")).click();
//        driver.findElement(By.xpath("//span[text()='Сравнение']")).click();
        WebElement searchContainer2 = driver.findElement(By.cssSelector("div.n-compare-content__line")); // все карточки сравнения
        List<WebElement> phones = searchContainer2.findElements(By.cssSelector("div.n-compare-cell")); // список карточек сравнения телефонов
        assertThat(phones.size(), equalTo(2));
        driver.findElement(By.xpath("//span[text()='все характеристики']")).click();
        String infoOs = driver.findElement(By.cssSelector("div.n-compare-cell")).getText(); // compare-cell
        assertThat(infoOs, containsString("Android") ); //Android

        driver.findElement(By.xpath("//span[text()='различающиеся характеристики']")).click();




    }
}
