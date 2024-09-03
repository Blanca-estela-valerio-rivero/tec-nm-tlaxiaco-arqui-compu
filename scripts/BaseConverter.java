/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidor;

/**
 *
 * @author bka
 */
 import java.util.Scanner;

public class BaseConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el número al usuario
        System.out.println("Introduce el numero a convertir:");
        String number = scanner.nextLine();

        // Solicitar la base del número introducido
        System.out.println("Introduce la base del numero (2, 8, 10, 16):");
        int fromBase = scanner.nextInt();

        // Solicitar la base a la que convertir
        System.out.println("Introduce la base a la que convertir (2, 8, 10, 16):");
        int toBase = scanner.nextInt();

        try {
            // Convertir el número a base decimal
            int decimalNumber = Integer.parseInt(number, fromBase);

            // Convertir el número decimal a la base deseada
            String convertedNumber = convertFromDecimal(decimalNumber, toBase);

            // Mostrar el resultado
            System.out.println("Numero convertido: " + convertedNumber);

        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para convertir un número decimal a una base específica
    private static String convertFromDecimal(int number, int base) {
        if (base == 10) {
            return Integer.toString(number);
        }

        StringBuilder result = new StringBuilder();
        String digits = "0123456789ABCDEF";

        while (number > 0) {
            result.insert(0, digits.charAt(number % base));
            number /= base;
        }

        return result.toString();
    }
}
   

