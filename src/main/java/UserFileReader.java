import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFileReader {

    public static List<User> readUsersList(String fileName) {

        List<User> users = new ArrayList<>();
        Scanner scanner = null;

        try {

            scanner = new Scanner(new File(fileName));

            int lineIdx = 0;
            String surname = "";
            String name = "";
            String middleName = "";
            Integer age = null;
            String passport = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

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
        } catch (final FileNotFoundException e) {
            System.out.println("Файл с таким именем не найден: " + e);
        } finally {
            scanner.close();
        }

        return users;
    }

}
