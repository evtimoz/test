public class User {

    private String surname;
    private String name;
    private String middleName;
    private Integer age;
    private String passport;

    @Override
    public String toString() {
        return "User{" +
               "surname='" + surname + '\'' +
               ", name='" + name + '\'' +
               ", middleName='" + middleName + '\'' +
               ", age=" + age +
               ", passport='" + passport + '\'' +
               ", FIELDS_COUNT=" + FIELDS_COUNT +
               '}';
    }

    final int FIELDS_COUNT = 5;

    public User(final String surname, final String name, final String middleName, final Integer age, final String passport) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(final String passport) {
        this.passport = passport;
    }
}
