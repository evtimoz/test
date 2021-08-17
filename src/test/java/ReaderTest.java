import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ReaderTest {

    @SneakyThrows
    @Test
    public void testReader() {
        User lastUserFromFile = null;
        for (User user : UserFileReader.readUsersList("users.txt")) {
            System.out.println(user);
            lastUserFromFile = user;
        }
        Assertions.assertNotNull(lastUserFromFile);
        Assertions.assertEquals( "Иван", lastUserFromFile.getFirstname());
        Assertions.assertEquals( "Сычев", lastUserFromFile.getSurname());
        Assertions.assertEquals( "8945 344578", lastUserFromFile.getPassport());
    }

    @Test
    public void testReaderFileNotFound() {
        Assertions.assertThrows(IOException.class, () -> UserFileReader.readUsersList("wrong_name"));
    }

    @Test
    public void testReaderInvalidData() {
        Assertions.assertThrows(NumberFormatException.class, () -> UserFileReader.readUsersList("users_invalid_data.txt"));
    }

}
