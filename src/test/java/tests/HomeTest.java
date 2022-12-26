package tests;

import org.junit.Test;
import pageobject.HomePageObject;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomeTest extends BaseTest {
    @Test
    public void testDropDownList(){
        HomePageObject pageObject = new HomePageObject(driver);
        pageObject.clickAcceptCookiesButton();
        List<String> dropDownListIds = pageObject.getDropDownListIds();
        for (String id : dropDownListIds) {
            pageObject.clickDropDownListItem(id);
            assertEquals(id, pageObject.getVisibleDropDownListTextBlockId());
        }
    }
}
