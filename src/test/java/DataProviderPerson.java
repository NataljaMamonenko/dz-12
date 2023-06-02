import org.example.Person;
import org.testng.annotations.DataProvider;

public class DataProviderPerson {

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
        Person person1 = new Person("John", "Doe", 30);
        int expectedAge1 = 30;

        Person person2 = new Person("Jane", "Smith", 40);
        int expectedAge2 = 40;

        return new Object[][] {
                {person1, expectedAge1},
                {person2, expectedAge2}
        };
    }
}