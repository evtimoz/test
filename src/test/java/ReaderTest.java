import com.sun.org.apache.regexp.internal.RE;
import exceptions.IncorrectFileNameException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReaderTest {

    @SneakyThrows
    @Test
    public void testReader() {
        User lastUserFromFile = null;
        for (User user : UserFileReader.readUsersList("users.txt", ReaderType.BYTE_BUFFER)) {
            System.out.println(user);
            lastUserFromFile = user;
        }
        Assertions.assertNotNull(lastUserFromFile);
        Assertions.assertEquals( "Иван", lastUserFromFile.getFirstname());
        Assertions.assertEquals( "Сычев", lastUserFromFile.getSurname());
        Assertions.assertEquals( "8945", lastUserFromFile.getPassport().getSeries().toString());
        Assertions.assertEquals( "344578", lastUserFromFile.getPassport().getNumber().toString());
        Assertions.assertEquals( "Спб", lastUserFromFile.getPassport().getLocation());

    }

    @Test
    public void testReaderFileNotFound() {
        Assertions.assertThrows(IncorrectFileNameException.class, () -> UserFileReader.readUsersList("wrong_name", ReaderType.BYTE_BUFFER));
    }

    @SneakyThrows
    @Test
    public void testReaderInvalidData() {
        User lastUserFromFile = null;
        for (User user : UserFileReader.readUsersList("users_invalid_data.txt", ReaderType.BYTE_BUFFER)) {
            System.out.println(user);
            lastUserFromFile = user;
        }
        Assertions.assertNotNull(lastUserFromFile);
        Assertions.assertEquals( "Иван", lastUserFromFile.getFirstname());
        Assertions.assertEquals( "Сычев", lastUserFromFile.getSurname());
        Assertions.assertEquals( null, lastUserFromFile.getAge());
    }

}
