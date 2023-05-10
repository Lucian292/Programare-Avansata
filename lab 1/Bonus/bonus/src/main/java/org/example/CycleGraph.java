package org.example;

import java.util.Scanner;

public class CycleGraph {

    public static void main(String[] args) {

        // Prompt the user for the number of vertices
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        // Create the adjacency matrix of the cycle graph
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            adjMatrix[i][(i + 1) % n] = 1;
            adjMatrix[(i + 1) % n][i] = 1;
        }

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        printMatrix(adjMatrix);

        // Compute the powers of the adjacency matrix
        int[][] matrixPower = adjMatrix;
        for (int i = 2; i <= n; i++) {
            matrixPower = multiplyMatrices(matrixPower, adjMatrix);
            System.out.println("Adjacency Matrix to the power of " + i + ":");
            printMatrix(matrixPower);
        }

        scanner.close();
    }

    // Function to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
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
