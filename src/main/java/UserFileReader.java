import exceptions.IncorrectFileNameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserFileReader {

    final static String DEFAULT_FILE_NAME = "users.txt";
    static List<User> users = new ArrayList<>();
    static User newUser = new User();
    static int lineIdx = 0;

    public static List<User> readUsersList(String fileName, ReaderType readerType) throws IncorrectFileNameException {

        switch(readerType) {
            case BYTE_BUFFER:
            try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
                for (String line; (line = br.readLine()) != null; ) {
                    readUserInfoFromLine(line);
                }
            } catch (IOException e) {
                if (!fileName.equals(DEFAULT_FILE_NAME)) {
                    throw new IncorrectFileNameException("Incorrect filename : " + fileName);
                }
            }
            break;
            case SEEKABLE_BYTE_CHANNEL:
            break;
            case SCANNER:
            break;

        }

        return users;
    }

    public static void readUserInfoFromLine( String line) {
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
                newUser.addPassport(line);
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
