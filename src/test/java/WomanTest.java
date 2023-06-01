import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanTest {

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        // Код настройки перед выполнением тестов WomanTest
    }

    @Test(groups = {"GettersTest"}, description = "validation of method testGetPartner()")
    public void testGetPartner() {
        Man man = new Man("John", "Doe", 35);
        Woman woman = new Woman("Anna", "Smith", 30);
        woman.setPartner(man);

        Man partner = woman.getPartner();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(partner, man);
        softAssert.assertAll();
    }

    @Test(description = "validation of method testSetMaidenName()")
    public void testSetMaidenName() {
        String maidenName = "Johnson";
        Woman woman = new Woman("Anna", "Smith", 30);
        woman.setMaidenName(maidenName);

        String retrievedMaidenName = woman.getMaidenName();
        Assert.assertEquals(retrievedMaidenName, maidenName, "Maiden name is wrong for woman");
    }

    @Test(description = "validation of method testGetMaidenName()")
    public void testGetMaidenName() {
        Woman woman = new Woman("Anna", "Smith", 30);
        String retrievedMaidenName = woman.getMaidenName();
        Assert.assertEquals(retrievedMaidenName, "Smith", "Maiden name is wrong for woman");
    }

    @Test(groups = {"GettersTest"}, description = "validation of method testIsRetired()")
    public void testIsRetired() {
        Woman woman1 = new Woman("Anna", "Smith", 50); // Not retired
        Woman woman2 = new Woman("Jane", "Doe", 65); // Retired

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(woman1.isRetired(), "Woman1 should not be retired");
        softAssert.assertTrue(woman2.isRetired(), "Woman2 should be retired");
        softAssert.assertAll();
    }

    @Test(groups = {"GettersTest"}, description = "validation of method testRegisterPartnership()", dataProvider = "partnershipData")
    public void testRegisterPartnership(Man man, Woman woman, String expectedLastName) {
        woman.registerPartnership(man);
        Man partner = woman.getPartner();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(partner, man, "Partner is not registered correctly");
        softAssert.assertEquals(woman.getLastName(), expectedLastName, "Last name is wrong for woman");
        softAssert.assertAll();
    }

    @DataProvider(name = "partnershipData")
    public Object[][] providePartnershipData() {
        Man man = new Man("John", "Doe", 35);
        Woman woman = new Woman("Anna", "Smith", 30);
        String expectedLastName = "Doe";
        return new Object[][]{{man, woman, expectedLastName}};
    }

    @Test(groups = {"GettersTest"}, description = "validation of method testDeregisterPartnership()", dataProvider = "deregisterPartnershipData")
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
