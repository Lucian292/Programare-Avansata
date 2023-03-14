import java.util.*;
// Another specialized person class
public class Designer extends Person {

    private String specialization;

    public Designer(String name, Date birthDate, String specialization) {
        super(name, birthDate);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return String.format("%s (Designer, %s)", super.toString(), specialization);
    }

}