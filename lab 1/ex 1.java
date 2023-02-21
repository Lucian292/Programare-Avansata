public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        int result = n * 3; // am inmultit numarul cu 3
        result += 0b10101;  // am adaugat numarul binar 10101
        result += 0xFF;    // am adaugat numarul hexadecimal FF
        result *= 6; // am inmultit rezultatul cu 6

        while (result > 9) {
            int sum = 0;
            while (result != 0) {
                sum += result % 10;
                result /= 10;
            }
            result = sum;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
