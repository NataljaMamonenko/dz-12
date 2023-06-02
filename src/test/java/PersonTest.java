import org.example.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonTest {

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        // Код налаштування перед виконанням PersonTest
    }

    @Test(groups = {"GettersTest"}, dataProvider = "firstNameProvider", dataProviderClass = DataProviderPerson.class, description = "validation of method testGetFirstName()")
    public void testGetFirstName(Person person, String expectedFirstName) {
        String firstName = person.getFirstName();
        Assert.assertEquals(firstName, expectedFirstName);
    }

    @Test(groups = {"GettersTest"}, dataProvider = "lastNameProvider", dataProviderClass = DataProviderPerson.class, description = "validation of method testGetLastName()")
    public void testGetLastName(Person person, String expectedLastName) {
        String lastName = person.getLastName();
        Assert.assertEquals(lastName, expectedLastName);
    }

    @Test(groups = {"GettersTest"}, dataProvider = "ageProvider", dataProviderClass = DataProviderPerson.class, description = "validation of method testGetAge()")
    public void testGetAge(Person person, int expectedAge) {
        int age = person.getAge();
        Assert.assertEquals(age, expectedAge);
    }

    @Test(groups = {"GettersTest"}, description = "validation of method testGetMaidenName()")
    public void testGetMaidenName() {
        Person person = new Person("Jane", "Smith", 35);
        String maidenName = person.getMaidenName();
        Assert.assertNull(maidenName);
    }
 }
