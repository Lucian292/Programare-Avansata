package org.example;

import java.util.Scanner;

public class RegularGraph {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        System.out.print("Enter the vertex degree: ");
        int k = scanner.nextInt();

        // Check if the number of vertices is greater than the vertex degree
        if (n <= k) {
            System.out.println("The number of vertices must be greater than the vertex degree.");
            return;
        }

        // Create the adjacency matrix of the regular graph
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) { //parcurgem fiecare nod i al grafului
            for (int j = 1; j <= k/2; j++) { //parcurgem vecinii nodului
                int neighbor1 = (i + j) % n; //se calculeaza vecinii din partea dreaptă a nodului i
                int neighbor2 = (i - j + n) % n;// se calculeaza vecinii din partea stângă a nodului i
                adjMatrix[i][neighbor1] = 1;
                adjMatrix[neighbor1][i] = 1;
                adjMatrix[i][neighbor2] = 1;
                adjMatrix[neighbor2][i] = 1;
            }
            if (k % 2 == 1) { //Dacă k este impar, atunci nodul i va avea un vecin suplimentar în mijloc,
                            // deci se calculează indexul vecinului de mijloc
                int neighbor = (i + k/2) % n;
                adjMatrix[i][neighbor] = 1;
                adjMatrix[neighbor][i] = 1;
            }
        }

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        printMatrix(adjMatrix);
    }

    // Function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

