import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserFileReader {

    public static List<User> readUsersList(String fileName) {

        List<User> users = new ArrayList<>();

        int lineIdx = 0;
        String surname = "";
        String name = "";
        String middleName = "";
        Integer age = null;
        String passport = "";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            for (String line = null; (line = br.readLine()) != null;) {
                    switch (lineIdx) {
                        case 0:
                            surname = line;
                            break;
                        case 1:
                            name = line;
                            break;
                        case 2:
                            middleName = line;
                            break;
                        case 3:
                            age = Integer.parseInt(line);  // TODO: exception
                            break;
                        case 4:
                            passport = line;
                            break;
                    }
                    lineIdx++;

                    if (lineIdx == 5) {
                        lineIdx = 0;
                        users.add(new User(surname, name, middleName, age, passport));
                    }
                }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла: " + e);
        }

        return users;
    }

}
