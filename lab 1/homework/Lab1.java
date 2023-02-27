public class Lab1 {
    public static void main(String[] args) {
        // Verificăm dacă a fost dat un argument și dacă acesta este un număr întreg pozitiv
        if (args.length != 1) {
            System.out.println("Va rugam introduceti un argument intreg.");
            return;
        }
        int n;
        try {
            n = Integer.parseInt(args[0]); // Convertim primul argument din linia de comandă într-un număr întreg
        } catch (NumberFormatException e) { // Dacă argumentul nu este un număr întreg valid, tratăm excepția aruncată de metoda parseInt()
            System.out.println("Argument invalid. Va rugam introduceti un numar intreg."); // Afisam un mesaj de eroare pe ecran
            return;
        }
        if (n <= 0) {
            System.out.println("Argument invalid. Va rugam introduceti un numar pozitiv.");
            return;
        }
        // Dacă n este mai mare decât 30,000, vom afișa doar timpul de executare și nu vom crea matricea
        if (n > 30000) {
            long startTime = System.nanoTime(); // Memorăm timpul de început în nanosecunde
            long endTime; // Declaram variabila pentru timpul de sfarsit
            long duration; // Declaram variabila pentru durata totala
            System.out.println("Crearea Matricei Latine de marime " + n + "...");
            int[][] matrix = new int[n][n];
            // Cream matricea
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = (i + j) % n + 1; // Populam matricea cu numere de la 1 la n
                }
            }
            endTime = System.nanoTime(); // Memorăm timpul de sfârșit în nanosecunde
            duration = endTime - startTime; // Calculăm durata de executare
            System.out.println("Matrice creata in " + duration + " nanosecunde."); // Afișăm durata de executare
            return;
        }
        // Dacă n este mai mic sau egal cu 30,000, vom crea matricea și vom afișa concatenările pentru fiecare rând și coloană
        System.out.println("Crearea Matricei Latine de marime " + n + "...");
        int[][] matrix = new int[n][n];
        // Cream matricea
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i + j) % n + 1; // Populam matricea cu numere de la 1 la n
            }
        }
        System.out.println("Matrice creata.");
        System.out.println("concatenările pentru fiecare rând:");
        // Afișăm concatenările pentru fiecare rând
        for (int i = 0; i < n; i++) {
            String rowString = ""; // Declaram variabila de tip String in care vom aduna valorile pentru randul curent
            for (int j = 0; j < n; j++) {
                rowString += matrix[i][j] + " "; // Adunam fiecare valoare din rand la variabila rowString
            }
            System.out.println(rowString); // Afișăm concatenarea valorilor din rand
        }
        System.out.println("concatenările pentru fiecare coloană:");
        // Afișăm concatenările pentru fiecare coloană
        for (int j = 0; j < n; j++) {
            String columnString = ""; // Declaram variabila de tip String in care vom aduna valorile pentru coloana curenta
            for (int i = 0; i < n; i++) {
                columnString += matrix[i][j] + " "; // Adunam fiecare valoare din coloana la variabila columnString
            }
            System.out.println(columnString); // Afișăm concatenarea valorilor din coloană
        }
    }
}
