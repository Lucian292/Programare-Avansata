import java.util.*;
// Specialized person class
public class Programmer extends Person {

    private String programmingLanguage;

    public Programmer(String name, Date birthDate, String programmingLanguage) {
        super(name, birthDate);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public String toString() {
        return String.format("%s (Programmer, %s)", super.toString(), programmingLanguage);
    }

}