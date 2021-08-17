import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserFileReader {

    public static List<User> readUsersList(String fileName) throws IOException {

        List<User> users = new ArrayList<>();
        User newUser = new User();

        int lineIdx = 0;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            for (String line; (line = br.readLine()) != null; ) {
                switch (lineIdx) {
                    case 0:
                        newUser.setSurname(line);
                        break;
                    case 1:
                        newUser.setFirstname(line);
                        break;
                    case 2:
                        newUser.setMiddlename(line);
                        break;
                    case 3:
                        newUser.setAge(line);
                        break;
                    case 4:
                        newUser.setPassport(line);
                        break;
                }

                lineIdx++;

                if (lineIdx == User.FIELDS_COUNT) {
                    lineIdx = 0;
                    users.add(newUser);
                    newUser = new User();
                }
            }
        }

        return users;
    }

}
