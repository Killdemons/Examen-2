package examen2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Examen2 {

    public static void Cine(String[] args) {
        String matriz[][] = new String[8][9];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                switch (j) {
                    case 0:
                        matriz[i][j] = i + 1 + "A";
                        break;
                    case 1:
                        matriz[i][j] = i + 1 + "B";
                        break;
                    case 2:
                        matriz[i][j] = i + 1 + "C";
                        break;
                    case 3:
                        matriz[i][j] = i + 1 + "D";
                        break;
                    case 4:
                        matriz[i][j] = i + 1 + "E";
                        break;
                    case 5:
                        matriz[i][j] = i + 1 + "F";
                        break;
                    case 6:
                        matriz[i][j] = i + 1 + "G";
                        break;
                    case 7:
                        matriz[i][j] = i + 1 + "H";
                        break;
                    case 8:
                        matriz[i][j] = i + 1 + "I";
                        break;
                    default:
                        break;
                }
            }
        }
        int cont = 0;
        String rojo = "\033[31m", negro = "\033[30m", azul= "\033[34m";
        Random rand = new Random();
        ArrayList coloreado = new ArrayList();
        while (cont < 25) {
            int row = rand.nextInt(7);
            int column = rand.nextInt(8);
            if (coloreado.contains(matriz[row][column]) == false) {
                matriz[row][column] = rojo + matriz[row][column];
                coloreado.add(matriz[row][column]);
                cont += 1;
            }
        }
        for (int i = 7; i >= 0; i--) {
            for (int j = 8; j >= 0; j--) {
                if(coloreado.contains(matriz[i][j])){
                    System.out.print(matriz[i][j]);
                }
                else{
                    System.out.print(negro+matriz[i][j]);
                }
            }
            System.out.print("\n");
        }
        Scanner var = new Scanner(System.in);
        while (true) {
            System.out.print("Selecione el campo que desea reservar: ");
            String option = var.next();
            if (coloreado.contains(rojo+option)==false) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (option.equals(matriz[i][j])) {
                            matriz[i][j] = azul + matriz[i][j];
                            coloreado.add(matriz[i][j]);
                            break;
                        }
                    }
                }
                break;
            } else if (coloreado.contains(azul+option)) {
                System.out.println("Ese espacio ya esta reservado, por favor seleccione uno que no lo este");
            } else if (coloreado.contains(rojo+option)) {
                System.out.println("Ese espacio ya esta reservado, por favor seleccione uno que no lo este");
            } else {
                System.out.println("Lo digitado es erroneo por favor vuelva a intentar");
            }
        }
        for (int i = 7; i >= 0; i--) {
            for (int j = 8; j >= 0; j--) {
                if(coloreado.contains(matriz[i][j])){
                    System.out.print(matriz[i][j]);
                }
                else{
                    System.out.print(negro+matriz[i][j]);
                }
            }
            System.out.print("\n");
        }
        menu(args);
    }

    public static void Numeros(String[] args) {
        Scanner var = new Scanner(System.in);
        System.out.println("Digite 2 numeros");
        System.out.print("Numero 1: ");
        int num1 = var.nextInt();
        System.out.print("Numero 2: ");
        int num2 = var.nextInt();
        ArrayList par = new ArrayList();
        ArrayList impar = new ArrayList();
        ArrayList rango = new ArrayList();
        for (int i = num1 + 1; i < num2; i++) {
            rango.add(i);
            if (i % 2 == 0) {
                par.add(i);
            } else {
                impar.add(i);
            }
        }
        System.out.println("Rango: " + rango);
        System.out.println("Numeros pares: " + par);
        System.out.println("Numeros impares: " + impar);
        menu(args);
    }

    public static void Ppt(String[] args) {
        System.out.println("Juego de Piedra, Papel o tijera");
        System.out.println("1-Piedra\n2-Papel\n3-Tijera");
        System.out.print("Seleccione que desea jugar: ");
        Scanner var = new Scanner(System.in);
        int option = var.nextInt();
        String player = null, compu = null;
        Random rand = new Random();
        int opcionpc = rand.nextInt(3) + 1;
        int opcion = 0;
        while (opcion < 2) {
            if (opcion == 0) {
                if (opcionpc == 1) {
                    compu = "Piedra";
                } else if (opcionpc == 2) {
                    compu = "Papel";
                } else if (opcionpc == 3) {
                    compu = "Tijeras";
                }
            } else if (opcion == 1) {
                if (option == 1) {
                    player = "Piedra";
                } else if (option == 2) {
                    player = "Papel";
                } else if (option == 3) {
                    player = "Tijeras";
                }
            }
            opcion += 1;
        }
        if (("Piedra".equals(player) && "Papel".equals(compu)) || ("Papel".equals(player) && "Tijeras".equals(compu)) || ("Tijeras".equals(player) && "Piedra".equals(compu))) {
            System.out.println("Gano la computadora. Computadora: " + compu + " Usuario: " + player);
        } else if (("Piedra".equals(compu) && "Papel".equals(player)) || ("Papel".equals(compu) && "Tijeras".equals(player)) || ("Tijeras".equals(compu) && "Piedra".equals(player))) {
            System.out.println("Gano el usuario. Computadora: " + compu + " Usuario: " + player);
        } else if (compu.equals(player)) {
            System.out.println("Empate. Computadora: " + compu + " Usuario: " + player);
        }
        menu(args);
    }

    public static void menu(String[] args) {
        System.out.println("Menu\n1-PPT\n2-Numeros\n3-Cine\n4-Salir");
        int opcion;
        Scanner var = new Scanner(System.in);
        System.out.print("Seleccione una opcion: ");
        opcion = var.nextInt();
        switch (opcion) {
            case 1:
                Ppt(args);
                break;
            case 2:
                Numeros(args);
                break;
            case 3:
                Cine(args);
                break;
            case 4:
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        menu(args);
    }

}
