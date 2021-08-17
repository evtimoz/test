import exceptions.IncorrectPassportDataException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ToString
@Data
@Slf4j
public class User {

    @ToString.Exclude
    private UUID uuid = UUID.randomUUID();
    private String surname;
    private String firstname;
    private String middlename;
    private Integer age;
    private Passport passport;

    void addPassport(String passportInfo) {
        this.passport = new Passport(passportInfo, this);
    }

    @ToString
    @Data
    public static class Passport {
        private Integer series;
        private Integer number;
        private String location;

        @ToString.Exclude
        final int DEFAULT_PASSPORT_SERIES_LENGTH = 4;
        @ToString.Exclude
        final int DEFAULT_PASSPORT_NUMBER_LENGTH = 6;

        public Passport(String passport, User user) {
            String[] info = passport.split(" ");
            if (info.length != 3) {
                log.error("Invalid passport info for user with UUID" + user.uuid);
                return;
            }
            try {
                this.series = getPassportSeries(info[0]);
                this.number = getPassportNumber(info[1]);
                this.location = info[2];
            } catch (NumberFormatException e) {
                log.error("Invalid serial/number format for user passport with UUID" + user.uuid);
            }
        }

        Integer getPassportSeries(String series) throws NumberFormatException {
            if (series.length() != DEFAULT_PASSPORT_SERIES_LENGTH ) {
                throw new IncorrectPassportDataException("");
            }
            return Integer.parseInt(series);
        }

        Integer getPassportNumber(String number) throws NumberFormatException {
            if (number.length() != DEFAULT_PASSPORT_NUMBER_LENGTH ) {
                throw new IncorrectPassportDataException("");
            }
            return Integer.parseInt(number);
        }
    }

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
