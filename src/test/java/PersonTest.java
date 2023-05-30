import org.example.Person;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonTest {

    @Test(dataProvider = "personProvider", description = "validation of method testGetFirstName()")
    public void testGetFirstName(Person person, String expectedFirstName) {
        String firstName = person.getFirstName();
        Assert.assertEquals(firstName, expectedFirstName);
    }

    @Test(dataProvider = "personProvider", description = "validation of method testGetLastName()")
    public void testGetLastName(Person person, String expectedLastName) {
        String lastName = person.getLastName();
        Assert.assertEquals(lastName, expectedLastName);
    }

    @Test(dataProvider = "personProvider", description = "validation of method testGetAge()")
    public void testGetAge(Person person, int expectedAge) {
        int age = person.getAge();
        Assert.assertEquals(age, expectedAge);
    }

    @Test(description = "validation of method testGetMaidenName()")
    public void testGetMaidenName() {
        Person person = new Person("Jane", "Smith", 35);
        String maidenName = person.getMaidenName();
        Assert.assertNull(maidenName);
    }

    @DataProvider(name = "personProvider")
    public Object[][] personProvider() {
        Person person = new Person("John", "Doe", 30);
        return new Object[][]{{person, "John", "Doe", 30}};
    }
}
