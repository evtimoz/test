import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReaderTest {

    @Test
    public void testReader() {
        User lastUserFromFile = null;
        for (User user : UserFileReader.readUsersList("users.txt")) {
            System.out.println(user);
            lastUserFromFile = user;
        }
        Assertions.assertNotNull(lastUserFromFile);
        Assertions.assertEquals(lastUserFromFile.getName(), "Иван");
        Assertions.assertEquals(lastUserFromFile.getSurname(), "Сычев");
        Assertions.assertEquals(lastUserFromFile.getPassport(), "8945 344578");
    }

}
