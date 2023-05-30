import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManTest {

    @Test(dataProvider = "partnersProvider", description = "validation of method testGetPartner()")
    public void testGetPartner(Woman woman, Man man) {
        man.setPartner(woman);
        Woman partner = man.getPartner();
        Assert.assertEquals(partner, woman);
    }

    @Test(dataProvider = "retirementProvider", description = "validation of method testIsRetired()")
    public void testIsRetired(Man man, boolean expectedResult) {
        boolean isRetired = man.isRetired();
        Assert.assertEquals(isRetired, expectedResult);
    }

    @Test(dataProvider = "partnershipProvider", description = "validation of method testRegisterPartnership()")
    public void testRegisterPartnership(Woman woman, Man man) {
        man.registerPartnership(woman);
        Woman partner = man.getPartner();
        Assert.assertEquals(partner, woman);
        Assert.assertEquals(woman.getLastName(), "Doe");
    }

    @Test(dataProvider = "deregisterProvider", description = "validation of method testDeregisterPartnership()")
    public void testDeregisterPartnership(Woman woman, Man man, boolean preserveLastName) {
        man.setPartner(woman);
        man.deregisterPartnership(preserveLastName);
        Woman partner = man.getPartner();
        Assert.assertNull(partner);
        Assert.assertEquals(woman.getLastName(), preserveLastName ? "Doe" : "Smith");
    }

    @DataProvider(name = "partnersProvider")
    public Object[][] partnersProvider() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        return new Object[][]{{woman, man}};
    }

    @DataProvider(name = "retirementProvider")
    public Object[][] retirementProvider() {
        Man man1 = new Man("John", "Doe", 40); // Not retired
        Man man2 = new Man("Adam", "Smith", 70); // Retired
        return new Object[][]{{man1, false}, {man2, true}};
    }

    @DataProvider(name = "partnershipProvider")
    public Object[][] partnershipProvider() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        return new Object[][]{{woman, man}};
    }

    @DataProvider(name = "deregisterProvider")
    public Object[][] deregisterProvider() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        return new Object[][]{{woman, man, false}, {woman, man, true}};
    }
}

