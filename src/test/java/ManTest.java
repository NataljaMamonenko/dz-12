import org.example.Man;
import org.example.Woman;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManTest {

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        // Код налаштування перед виконанням ManTest
    }

    @Test(groups = {"GettersTest"}, description = "validation of method testGetPartner()", dataProvider = "partnerData", dataProviderClass = DataProviderMan.class)
    public void testGetPartner(Woman woman, Man man) {
        man.setPartner(woman);

        Woman partner = man.getPartner();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(partner, woman, "Partner is not retrieved correctly");
        softAssert.assertAll();
    }

    @Test(description = "validation of method testIsRetired()", dataProvider = "retiredData", dataProviderClass = DataProviderMan.class)
    public void testIsRetired(Man man, boolean expectedIsRetired) {
        boolean isRetired = man.isRetired();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(isRetired, expectedIsRetired, "Retirement status is incorrect");
        softAssert.assertAll();
    }

    @Test(groups = {"GettersTest"}, description = "validation of method testRegisterPartnership()", dataProvider = "partnershipData", dataProviderClass = DataProviderMan.class)
    public void testRegisterPartnership(Woman woman, Man man, String expectedLastName) {
        man.registerPartnership(woman);
        Woman partner = man.getPartner();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(partner, woman, "Partner is not registered correctly");
        softAssert.assertEquals(woman.getLastName(), expectedLastName, "Last name is wrong for woman");
        softAssert.assertAll();
    }

    @Test(groups = {"GettersTest"}, description = "validation of method testDeregisterPartnership()", dataProvider = "deregisterPartnershipData", dataProviderClass = DataProviderMan.class)
    public void testDeregisterPartnership(Woman woman, Man man, String expectedLastName) {
        man.setPartner(woman);

        man.deregisterPartnership(false);
        Woman partner = man.getPartner();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNull(partner, "Partnership is not deregistered correctly");
        softAssert.assertEquals(woman.getLastName(), expectedLastName, "Last name is wrong for woman");
        softAssert.assertAll();
    }
}
