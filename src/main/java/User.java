import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ToString
@Data
@RequiredArgsConstructor
@Slf4j
public class User {

    @ToString.Exclude
    private UUID uuid = UUID.randomUUID();
    private String surname;
    private String firstname;
    private String middlename;
    private Integer age;
    private String passport;

    @ToString.Exclude
    static final int FIELDS_COUNT = 5;

    public void setAge(final String age) {
        try {
            this.age = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            log.error("Invalid age for user with UUID" + this.uuid);
        }
    }

}
