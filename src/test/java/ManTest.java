import org.example.Man;
import org.example.Woman;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManTest {

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        // Код настройки перед выполнением тестов ManTest
    }

    @Test(description = "validation of method testGetPartner()", dataProvider = "partnerData")
    public void testGetPartner(Woman woman, Man man) {
        man.setPartner(woman);

        Woman partner = man.getPartner();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(partner, woman, "Partner is not retrieved correctly");
        softAssert.assertAll();
    }

    @DataProvider(name = "partnerData")
    public Object[][] providePartnerData() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        return new Object[][]{{woman, man}};
    }

    @Test(description = "validation of method testIsRetired()", dataProvider = "retiredData")
    public void testIsRetired(Man man, boolean expectedIsRetired) {
        boolean isRetired = man.isRetired();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(isRetired, expectedIsRetired, "Retirement status is incorrect");
        softAssert.assertAll();
    }

    @DataProvider(name = "retiredData")
    public Object[][] provideRetiredData() {
        Man man1 = new Man("John", "Doe", 40); // Not retired
        Man man2 = new Man("Adam", "Smith", 70); // Retired
        return new Object[][]{{man1, false}, {man2, true}};
    }

    @Test(description = "validation of method testRegisterPartnership()", dataProvider = "partnershipData")
    public void testRegisterPartnership(Woman woman, Man man, String expectedLastName) {
        man.registerPartnership(woman);
        Woman partner = man.getPartner();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(partner, woman, "Partner is not registered correctly");
        softAssert.assertEquals(woman.getLastName(), expectedLastName, "Last name is wrong for woman");
        softAssert.assertAll();
    }

    @DataProvider(name = "partnershipData")
    public Object[][] providePartnershipData() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        String expectedLastName = "Doe";
        return new Object[][]{{woman, man, expectedLastName}};
    }

    @Test(description = "validation of method testDeregisterPartnership()", dataProvider = "deregisterPartnershipData")
    public void testDeregisterPartnership(Woman woman, Man man, String expectedLastName) {
        man.setPartner(woman);

        man.deregisterPartnership(false);
        Woman partner = man.getPartner();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNull(partner, "Partnership is not deregistered correctly");
        softAssert.assertEquals(woman.getLastName(), expectedLastName, "Last name is wrong for woman");
        softAssert.assertAll();
    }

    @DataProvider(name = "deregisterPartnershipData")
    public Object[][] provideDeregisterPartnershipData() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        String expectedLastName = "Smith";
        return new Object[][]{{woman, man, expectedLastName}};
    }
}
