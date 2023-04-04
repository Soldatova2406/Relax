import ru.netology.services.RestCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RestCounterTest {
    @Test
    public void firstDataTest() {
        RestCounter service = new RestCounter();
        int income = 10_000, expenses = 3_000, threshold = 20_000, expected = 3;

        int actual = service.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void secondDataTest() {
        RestCounter service = new RestCounter();
        int income = 100_000, expenses = 60_000, threshold = 150_000, expected = 2;

        int actual = service.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
//    @CsvSource({
//            "3, 10000, 3000, 20000",
//            "2, 100000, 60000, 150000"
//
//    })
    @CsvFileSource(files = "src/test/resources/count.csv")
    public void testDifferentData(int expected, int income, int expenses, int threshold) {
        RestCounter service = new RestCounter();

        int actual = service.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);


    }
}
