import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanTest {

    @Test(dataProvider = "partnerProvider", description = "validation of method testGetPartner()")
    public void testGetPartner(Man man, Woman woman) {
        woman.setPartner(man);
        Man partner = woman.getPartner();
        Assert.assertEquals(partner, man);
    }

    @Test(dataProvider = "maidenNameProvider", description = "validation of method testGetMaidenName()")
    public void testGetMaidenName(String maidenName) {
        Woman woman = new Woman("Anna", "Smith", 30);
        woman.setMaidenName(maidenName);

        String retrievedMaidenName = woman.getMaidenName();
        Assert.assertEquals(retrievedMaidenName, maidenName);
    }

    @Test(dataProvider = "retirementProvider", description = "validation of method testIsRetired()")
    public void testIsRetired(Woman woman, boolean expectedResult) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(woman.isRetired());
        softAssert.assertTrue(woman.isRetired());
        softAssert.assertAll();
    }

    @Test(dataProvider = "partnershipProvider", description = "validation of method testRegisterPartnership()")
    public void testRegisterPartnership(Man man, Woman woman) {
        woman.registerPartnership(man);
        Man partner = woman.getPartner();
        Assert.assertEquals(partner, man);
        Assert.assertEquals(woman.getLastName(), "Doe");
    }

    @Test(dataProvider = "deregisterProvider", description = "validation of method testDeregisterPartnership()")
    public void testDeregisterPartnership(Woman woman, Man man, boolean preserveLastName) {
        man.setPartner(woman);
        man.deregisterPartnership(false);
        Woman partner = man.getPartner();
        Assert.assertNull(partner);
        Assert.assertEquals(woman.getLastName(), preserveLastName ? "Doe" : "Smith");
    }

    @DataProvider(name = "partnerProvider")
    public Object[][] partnerProvider() {
        Man man = new Man("John", "Doe", 35);
        Woman woman = new Woman("Anna", "Smith", 30);
        return new Object[][]{{man, woman}};
    }

    @DataProvider(name = "maidenNameProvider")
    public Object[][] maidenNameProvider() {
        String maidenName = "Johnson";
        return new Object[][]{{maidenName}};
    }

    @DataProvider(name = "retirementProvider")
    public Object[][] retirementProvider() {
        Woman woman1 = new Woman("Anna", "Smith", 50); // Not retired
        Woman woman2 = new Woman("Jane", "Doe", 65); // Retired
        return new Object[][]{{woman1, false}, {woman2, true}};
    }

    @DataProvider(name = "partnershipProvider")
    public Object[][] partnershipProvider() {
        Man man = new Man("John", "Doe", 35);
        Woman woman = new Woman("Anna", "Smith", 30);
        return new Object[][]{{man, woman}};
    }

    @DataProvider(name = "deregisterProvider")
    public Object[][] deregisterProvider() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        return new Object[][]{{woman, man, false}, {woman, man, true}};
    }
}

