package amazontest;

import base.CommonAPI;
import org.testng.annotations.Test;

public class LanguageTest extends CommonAPI {
    @Test
    public void test1() throws InterruptedException {
        hoverOverNPOM("//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']");
        Thread.sleep(3000);
    }
}
