import org.example.Man;
import org.example.Woman;
import org.testng.annotations.DataProvider;

public class DataProviderWoman {
    @DataProvider(name = "partnershipData")
    public static Object[][] providePartnershipData() {
        Man man = new Man("John", "Doe", 35);
        Woman woman = new Woman("Anna", "Smith", 30);
        String expectedLastName = "Doe";
        return new Object[][]{{man, woman, expectedLastName}};
    }

    @DataProvider(name = "deregisterPartnershipData")
    public static Object[][] provideDeregisterPartnershipData() {
        Woman woman = new Woman("Anna", "Smith", 30);
        Man man = new Man("John", "Doe", 35);
        String expectedLastName = "Smith";
        return new Object[][]{{woman, man, expectedLastName}};
    }
}

