package tests;

import org.junit.Test;
import pageobject.HomePageObject;
import pageobject.OrderPageObject;

import static org.junit.Assert.assertTrue;

public class OrderTest extends BaseTest {
    @Test
    public void testOrderingScooterFromOrderButtonInHeader() {
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickOrderButtonInHeader();
        OrderPageObject orderPageObject = new OrderPageObject(driver);
        orderPageObject.fill("йцуке", "йцуке", "йцуке", "11111111111", "27.12.2022");
        orderPageObject.orderButtonClick();
        orderPageObject.confirmOrderCreationButtonClick();
        assertTrue(orderPageObject.isOrderCreatedModalHeaderVisible());
    }

    @Test
    public void testOrderingScooterFromOrderButtonInBody() {
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickAcceptCookiesButton();
        homePageObject.clickOrderButtonInBody();
        OrderPageObject orderPageObject = new OrderPageObject(driver);
        orderPageObject.fill("йцуке", "йцуке", "йцуке", "11111111111", "27.12.2022");
        orderPageObject.orderButtonClick();
        orderPageObject.confirmOrderCreationButtonClick();
        assertTrue(orderPageObject.isOrderCreatedModalHeaderVisible());
    }
}
