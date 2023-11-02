package amazontest;
import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearchTest extends CommonAPI {
    @Test
    public void test() {
        //validate the title
        String currentTitle = getCurrentTitle();
        Assert.assertEquals("Amazon.com. Spend less. Smile more.",currentTitle);
        System.out.println("amazon main page loaded success");

        //type "java book" in search field
        typeNPOM("#twotabsearchtextbox","java book");
        System.out.println("type java book on the search field success");

        //click on search button
        clickOnNPOM("#nav-search-submit-button");
        String currentText = getElementTextNPOM("/html/body/div[1]/div[1]/span[2]/div/h1/div/div[1]/div/div/span[1]");
        System.out.println("text is: "+currentText);
        Assert.assertTrue(currentText.contains("results for"));
        System.out.println("search page loaded success");
    }
}
