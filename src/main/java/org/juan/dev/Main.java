package org.juan.dev;

import org.juan.dev.Model.ApiConexion;
import org.juan.dev.Model.ExchangeRateAPI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ApiConexion moneyChanges = new ApiConexion();

        while (true) {
            showMenu();
            var option = input.nextInt();

            if (option == 7) {
                System.out.println("Gracias por usar el conversor de moneda. ¡Bye! ;)");
                break;
            }
            if (option < 1 || option > 6) {
                System.out.println("Opción no válida, intenta de nuevo: ");
                continue;
            }

            System.out.println("Ingresa el valor que deseas transformar: ");
            double conversion = input.nextDouble();

            ExchangeRateAPI money = moneyChanges.getChangesMoney(option, conversion);
            System.out.printf("--- El valor de %.2f [%s] corresponde al valor final de ==> %.2f [%s] --- %n",
                    conversion, moneyChanges.getValor1(), money.conversion_result(), moneyChanges.getValor2());

        }

        input.close();
    }

    private static void showMenu() {
        System.out.println("************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda :)");

        System.out.println("1) Dolar ==> Peso Argentino");
        System.out.println("2) Peso Argentino ==> Dolar");
        System.out.println("3) Dolar ==> Real Brasileno");
        System.out.println("4) Real Brasileno ==> Dolar");
        System.out.println("5) Dolar ==> Peso Colombiano");
        System.out.println("6) Peso Colombiano ==> Dolar");
        System.out.println("7) Salir");

        System.out.println("************************************************");

        System.out.println("Elija una opcion valida: ");
    }
}