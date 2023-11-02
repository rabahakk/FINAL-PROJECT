package amazontest;

import base.CommonAPI;
import org.testng.annotations.Test;

public class SelectProductTest extends CommonAPI {

    @Test
    public void test1() throws InterruptedException {
        selectDropdownOptionNPOM("//select[@id='searchDropdownBox']", "Baby");
        System.out.println("baby department is selected");

        typeNPOM("#twotabsearchtextbox","bed");
        System.out.println("type bed on the search field success");
        Thread.sleep(3000);
    }
}
