import org.example.Man;
import org.example.Woman;
import org.testng.annotations.DataProvider;

public class DataProviderMan {

    @DataProvider(name = "partnerData")
    public static Object[][] providePartnerData() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        return new Object[][]{{woman, man}};
    }

    @DataProvider(name = "retiredData")
    public static Object[][] provideRetiredData() {
        Man man1 = new Man("John", "Doe", 40); // Not retired
        Man man2 = new Man("Adam", "Smith", 70); // Retired
        return new Object[][]{{man1, false}, {man2, true}};
    }

    @DataProvider(name = "partnershipData")
    public static Object[][] providePartnershipData() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        String expectedLastName = "Doe";
        return new Object[][]{{woman, man, expectedLastName}};
    }

    @DataProvider(name = "deregisterPartnershipData")
    public static Object[][] provideDeregisterPartnershipData() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        String expectedLastName = "Smith";
        return new Object[][]{{woman, man, expectedLastName}};
    }
}
