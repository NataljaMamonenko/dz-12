import org.example.Person;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonTest {

    @Test(dataProvider = "firstNameProvider", description = "validation of method testGetFirstName()")
    public void testGetFirstName(Person person, String expectedFirstName) {
        String firstName = person.getFirstName();
        Assert.assertEquals(firstName, expectedFirstName);
    }

    @Test(dataProvider = "lastNameProvider", description = "validation of method testGetLastName()")
    public void testGetLastName(Person person, String expectedLastName) {
        String lastName = person.getLastName();
        Assert.assertEquals(lastName, expectedLastName);
    }

    @Test(dataProvider = "ageProvider", description = "validation of method testGetAge()")
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

    @DataProvider(name = "firstNameProvider")
    public Object[][] firstNameProvider() {
        Person person = new Person("John", "Doe", 30);
        String expectedFirstName = "John";
        return new Object[][]{{person, expectedFirstName}};
    }

    @DataProvider(name = "lastNameProvider")
    public Object[][] lastNameProvider() {
        Person person = new Person("John", "Doe", 30);
        String expectedLastName = "Doe";
        return new Object[][]{{person, expectedLastName}};
    }

    @DataProvider(name = "ageProvider")
    public Object[][] ageProvider() {
        Person person = new Person("John", "Doe", 30);
        int expectedAge = 30;
        return new Object[][]{{person, expectedAge}};
    }
}
