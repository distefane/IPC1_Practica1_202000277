/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.practica1;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class PACMAN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //VARIABLES PUNTEO
        int puntos = 0;
        int vida = 3;
        int total_premios = 100;
        String name;
        //historial
        String historial[][] = new String[20][2];
        int no_partidas = 0;

        int tacita = 100;
        while (tacita > 0) {
            // Menú inicio
            System.out.println("-----Menú de inicio-----");
            System.out.println("1. Iniciar Juego ");
            System.out.println("2. Mostrar Historial de Partidas");
            System.out.println("3. Salir del Juego");
            System.out.println("Escriba el número de la opción que desea elegir:");
            Scanner sc = new Scanner(System.in);
            int opcion_menu = sc.nextInt();
            switch (opcion_menu) {
                case 1 -> {
                    //System.out. println("Aquí es donde inicia el juego");
                    //Aquí solicita nombre de usuaio
                    System.out.println("Escriba su nombre de usuario (Preferiblemente de 6 caracteres): ");
                    name = sc.next();

                    //tamaño starts 
                    System.out.println("-----Especificaciones del tablero-----");
                    System.out.println("Por favor, elija entre los siguientes parámetros para jugar: ");
                    System.out.println("Tablero (G/P): ");
                    String tamanio = sc.next();

                    while (!tamanio.equals("G") && !tamanio.equals("P")) {
                        System.out.println("Tablero (G/P): ");
                        tamanio = sc.next();
                        if (tamanio.equals("P") && tamanio.equals("G")) {
                            break;
                        }
                    }

                    //solicitando número premios
                    System.out.println("Premios [1-40 en Grande] [1-12 en Pequeño]: ");
                    int premio = sc.nextInt();
                    while (premio < 1 || premio > 40) {
                        System.out.println("Premios [1-40 en Grande] [1-12 en Pequeño]: ");
                        premio = sc.nextInt();
                        if (premio >= 1 && premio <= 40) {
                            break;
                        }
                    }
                    total_premios = premio;
//solicitando número paredes
                    System.out.println("Paredes [1-20 en Grande] [1-6 en Pequeño]: ");
                    int pared = sc.nextInt();

                    while (pared < 1 || pared > 20) {
                        System.out.println("Paredes [1-20 en Grande] [1-6 en Pequeño]: ");
                        pared = sc.nextInt();
                        if (pared >= 1 && pared <= 20) {
                            break;
                        }
                    }
//solicitando número trampas
                    System.out.println("Trampas [1-20 en Grande] [1-6 en Pequeño]: ");
                    int trampa = sc.nextInt();

                    while (trampa < 1 || trampa > 20) {
                        System.out.println("Trampas [1-20 en Grande] [1-6 en Pequeño]: ");
                        trampa = sc.nextInt();
                        if (trampa >= 1 && trampa <= 20) {
                            break;
                        }
                    }
                    //Salida
                    System.out.println("-----Especificaciones del tablero-----");
                    System.out.println("Tablero (G/P): " + tamanio);
                    System.out.println("Premios [1-40 en Grande] [1-12 en Pequeño]: " + premio);
                    System.out.println("Paredes [1-20 en Grande] [1-6 en Pequeño]: " + pared);
                    System.out.println("Trampas [1-20 en Grande] [1-6 en Pequeño]: " + trampa);

                    System.out.println("--------------------------------------");
                    System.out.println(" ");

                    //Si elige el tamaño G se operaría ésto:
                    if (tamanio.equals("G")) {
                        //Debe mostrar el tablero con premios, trampas y paredes para que el usuario elija su posición 
                        System.out.println("*******************");
                        String grande[][] = new String[10][10];
                        for (int i = 0; i < pared; i++) {
                            int x = (int) (Math.random() * (9 - 0 + 1) + 0);
                            int y = (int) (Math.random() * (9 - 0 + 1) + 0);
                            grande[x][y] = "X";
                        }

                        for (int i = 0; i < premio; i++) {
                            int x = (int) (Math.random() * (9 - 0 + 1) + 0);
                            int y = (int) (Math.random() * (9 - 0 + 1) + 0);
                            int z = (int) (Math.random() * (1 - 0 + 1) + 0);
                            if (z == 0) {
                                if (grande[x][y] == null) {
                                    grande[x][y] = "$";
                                } else {
                                    i = i - 1;
                                }
                            } else {
                                if (grande[x][y] == null) {
                                    grande[x][y] = "0";
                                } else {
                                    i = i - 1;
                                }
                            }
                        }

                        for (int i = 0; i < trampa; i++) {
                            int x = (int) (Math.random() * (9 - 0 + 1) + 0);
                            int y = (int) (Math.random() * (9 - 0 + 1) + 0);
                            if (grande[x][y] == null) {
                                grande[x][y] = "@";
                            } else {
                                i = i - 1;
                            }
                        }

                        for (int i = 0; i < grande.length; i++) {
                            for (int j = 0; j < grande[i].length; j++) {
                                if (grande[i][j] == null) {
                                    grande[i][j] = " ";
                                } else {
                                }
                                System.out.print(grande[i][j] + " ");
                            }
                            System.out.println(" ");
                        }

                        //Desde aquí
                        System.out.println("*******************");
                        System.out.println("Escriba la posición VACÍA donde le gustaría empezar. Ahí se posicionará su pacman.");
                        System.out.println("Fila: ");
                        int x = sc.nextInt();
                        System.out.println("Columna: ");
                        int y = sc.nextInt();
                        System.out.println("*******************");

                        grande[x][y] = "<";

                        //Usar while, digo yo xd
                        String movimiento = "";
                        boolean d = false;
                        System.out.println(total_premios);
                        while (total_premios != 0 && vida != 0) {
                            System.out.println("___________________");
                            System.out.println("Nombre: " + name);
                            System.out.println("Vida: " + vida);
                            System.out.println("Puntos: " + puntos);
                            System.out.println("*******************");
                            for (int i = 0; i < grande.length; i++) {
                                for (int j = 0; j < grande[i].length; j++) {
                                    if (grande[i][j] == null) {
                                        grande[i][j] = " ";
                                    } else {
                                    }
                                    System.out.print(grande[i][j] + " ");
                                }
                                System.out.println(" ");
                            }
                            System.out.println("*******************");
                            System.out.println(" ");
                            System.out.println("Muévase en el tablero así: 8 hacia arriba, 5 hacia abajo, 6 hacia la derecha y 4 a la izquierda. F para pausa. ");
                            movimiento = sc.nextLine();
                            //switch para mover el pacman
                            switch (movimiento) {
                                case "8" -> {
                                    x = x - 1;
                                    if (x < 0) {
                                        x = 9;
                                    }
                                    if (grande[x][y].equals(" ")) {
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (x < 0) {
                                                        x = 9;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("X")) {
                                        x = x + 1;
                                        System.out.println("Hay una pared.");
                                    } else if (grande[x][y].equals("$")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 15;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (x < 0) {
                                                        x = 9;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("0")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 10;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (x < 0) {
                                                        x = 9;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("@")) {
                                        vida = vida - 1;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (x < 0) {
                                                        x = 9;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }

                                case "5" -> {
                                    x = x + 1;
                                    if (x > 9) {
                                        x = 0;
                                    }
                                    if (grande[x][y].equals(" ")) {
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (x > 9) {
                                                        x = 0;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("X")) {
                                        x = x - 1;
                                        System.out.println("Hay una pared.");
                                    } else if (grande[x][y].equals("$")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 15;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (x > 9) {
                                                        x = 0;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("0")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 10;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (x > 9) {
                                                        x = 0;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("@")) {
                                        vida = vida - 1;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (x > 9) {
                                                        x = 0;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "6" -> {
                                    y = y + 1;
                                    if (y > 9) {
                                        y = 0;
                                    }
                                    if (grande[x][y].equals(" ")) {
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (y > 9) {
                                                        y = 0;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("X")) {
                                        y = y - 1;
                                        System.out.println("Hay una pared.");
                                    } else if (grande[x][y].equals("$")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 15;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (y > 9) {
                                                        y = 0;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("0")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 10;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (y > 9) {
                                                        y = 0;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("@")) {
                                        vida = vida - 1;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (y > 9) {
                                                        y = 0;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }

                                case "4" -> {
                                    y = y - 1;
                                    if (y < 0) {
                                        y = 9;
                                    }
                                    if (grande[x][y].equals(" ")) {
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (y < 0) {
                                                        y = 9;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("X")) {
                                        y = y + 1;
                                        System.out.println("Hay una pared.");
                                    } else if (grande[x][y].equals("$")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 15;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (y < 0) {
                                                        y = 9;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("0")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 10;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (y < 0) {
                                                        y = 9;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (grande[x][y].equals("@")) {
                                        vida = vida - 1;
                                        for (int i = 0; i < grande.length; i++) {
                                            for (int j = 0; j < grande[i].length; j++) {
                                                if (grande[i][j].equals("<")) {
                                                    grande[i][j] = " ";
                                                    if (y < 0) {
                                                        y = 9;
                                                        grande[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        grande[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "F" -> {
                                    System.out.println("---------------PAUSA---------------");
                                    System.out.println("Por favor, seleccione una opción oprimiendo el número: ");
                                    System.out.println("1. Regresar. ");
                                    System.out.println("2. Terminar partida. ");
                                    String opcion_pausa = sc.nextLine();
                                    if (opcion_pausa.equals("1")) {
                                        continue;
                                    } else {
                                        total_premios = 0;
                                    }
                                }
                            }
                        }
                        System.out.println("Gracias por jugar.");
                        System.out.println("Puntos acumulados: " + puntos);
                        System.out.println("Vida: " + vida);
                    } //Si elige el tamaño P se operaría ésto:
                    else {
                        System.out.println("***********");
                        String pequenio[][] = new String[5][6];
                        for (int i = 0; i < pared; i++) {
                            int x = (int) (Math.random() * (4 - 0 + 1) + 0);
                            int y = (int) (Math.random() * (5 - 0 + 1) + 0);
                            pequenio[x][y] = "X";
                        }

                        for (int i = 0; i < premio; i++) {
                            int x = (int) (Math.random() * (4 - 0 + 1) + 0);
                            int y = (int) (Math.random() * (5 - 0 + 1) + 0);
                            int z = (int) (Math.random() * (1 - 0 + 1) + 0);
                            if (z == 0) {
                                if (pequenio[x][y] == null) {
                                    pequenio[x][y] = "$";
                                } else {
                                    i = i - 1;
                                }
                            } else {
                                if (pequenio[x][y] == null) {
                                    pequenio[x][y] = "0";
                                } else {
                                    i = i - 1;
                                }
                            }
                        }
                        for (int i = 0; i < trampa; i++) {
                            //5 filas, 6 columnas
                            int x = (int) (Math.random() * (4 - 0 + 1) + 0);
                            int y = (int) (Math.random() * (5 - 0 + 1) + 0);
                            if (pequenio[x][y] == null) {
                                pequenio[x][y] = "@";
                            } else {
                                i = i - 1;
                            }
                        }
                        for (int i = 0; i < pequenio.length; i++) {
                            for (int j = 0; j < pequenio[i].length; j++) {
                                if (pequenio[i][j] == null) {
                                    pequenio[i][j] = " ";
                                } else {
                                }
                                System.out.print(pequenio[i][j] + " ");
                            }
                            System.out.println(" ");
                        }
                        System.out.println("***********");
                        //Desde aquí
                        System.out.println("Escriba la posición vacía donde le gustaría empezar. Ahí se posicionará su pacman.");
                        System.out.println("Fila: ");
                        int x = sc.nextInt();
                        System.out.println("Columna: ");
                        int y = sc.nextInt();

                        pequenio[x][y] = "<";
                        String movimiento = "";

                        boolean d = false;
                        while (total_premios != 0 && vida != 0) {
                            System.out.println("_____________");
                            System.out.println("Nombre: " + name);
                            System.out.println("Vida: " + vida);
                            System.out.println("Puntos: " + puntos);
                            System.out.println("***********");
                            //Hasta aquí
                            for (int i = 0; i < pequenio.length; i++) {
                                for (int j = 0; j < pequenio[i].length; j++) {
                                    if (pequenio[i][j] == null) {
                                        pequenio[i][j] = " ";
                                    } else {
                                    }
                                    System.out.print(pequenio[i][j] + " ");
                                }
                                System.out.println(" ");
                            }
                            System.out.println("***********");
                            System.out.println(" ");
                            System.out.println("Muévase en el tablero así: 8 hacia arriba, 5 hacia abajo, 6 hacia la derecha y 4 a la izquierda. F para pausa. ");
                            movimiento = sc.nextLine();
                            //switch para mover el pacman
                            switch (movimiento) {
                                case "8" -> {
                                    x = x - 1;
                                    if (x < 0) {
                                        x = 4;
                                    }
                                    if (pequenio[x][y].equals(" ")) {
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (x < 0) {
                                                        x = 4;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("X")) {
                                        x = x + 1;
                                        System.out.println("Hay una pared.");
                                    } else if (pequenio[x][y].equals("$")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 15;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (x < 0) {
                                                        x = 4;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("0")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 10;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (x < 0) {
                                                        x = 4;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("@")) {
                                        vida = vida - 1;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (x < 0) {
                                                        x = 4;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }

                                case "5" -> {
                                    x = x + 1;
                                    if (x > 4) {
                                        x = 0;
                                    }
                                    if (pequenio[x][y].equals(" ")) {
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (x > 4) {
                                                        x = 0;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("X")) {
                                        x = x - 1;
                                        System.out.println("Hay una pared.");
                                    } else if (pequenio[x][y].equals("$")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 15;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (x > 4) {
                                                        x = 0;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("0")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 10;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (x > 4) {
                                                        x = 0;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("@")) {
                                        vida = vida - 1;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (x > 4) {
                                                        x = 0;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "6" -> {
                                    y = y + 1;
                                    if (y > 5) {
                                        y = 0;
                                    }
                                    if (pequenio[x][y].equals(" ")) {
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (y > 5) {
                                                        y = 0;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("X")) {
                                        y = y - 1;
                                        System.out.println("Hay una pared.");
                                    } else if (pequenio[x][y].equals("$")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 15;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (y > 5) {
                                                        y = 0;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("0")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 10;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (y > 5) {
                                                        y = 0;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("@")) {
                                        vida = vida - 1;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (y > 5) {
                                                        y = 0;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }

                                case "4" -> {
                                    y = y - 1;
                                    if (y < 0) {
                                        y = 5;
                                    }
                                    if (pequenio[x][y].equals(" ")) {
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (y < 0) {
                                                        y = 5;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("X")) {
                                        y = y + 1;
                                        System.out.println("Hay una pared.");
                                    } else if (pequenio[x][y].equals("$")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 15;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (y < 0) {
                                                        y = 5;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("0")) {
                                        total_premios = total_premios - 1;
                                        puntos = puntos + 10;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (y < 0) {
                                                        y = 5;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    } else if (pequenio[x][y].equals("@")) {
                                        vida = vida - 1;
                                        for (int i = 0; i < pequenio.length; i++) {
                                            for (int j = 0; j < pequenio[i].length; j++) {
                                                if (pequenio[i][j].equals("<")) {
                                                    pequenio[i][j] = " ";
                                                    if (y < 0) {
                                                        y = 5;
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                    } else {
                                                        pequenio[x][y] = "<";
                                                        d = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (d == true) {
                                                d = false;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "F" -> {
                                    System.out.println("---------------PAUSA---------------");
                                    System.out.println("Por favor, seleccione una opción oprimiendo el número: ");
                                    System.out.println("1. Regresar. ");
                                    System.out.println("2. Terminar partida. ");
                                    String opcion_pausa = sc.nextLine();
                                    if (opcion_pausa.equals("1")) {
                                        continue;
                                    } else {
                                        total_premios = 0;
                                    }
                                }
                            }

                        }
                    }
                    System.out.println("Gracias por jugar.");
                    historial[no_partidas][0] = name + "  ";
                    historial[no_partidas][1] = puntos + "";
                    no_partidas = no_partidas + 1;
                    System.out.println("Puntos acumulados: " + puntos);
                    System.out.println("Vida: " + vida);
                }

                case 2 -> {
                    System.out.println("*********************************");
                    System.out.println("------Historial de Partidas------");
                    System.out.println(" ");
                    System.out.print("Nombre ");
                    System.out.println(" Puntos");
                    for (int i = 0; i < historial.length; i++) {
                        if (historial[i][0]!=null) {
                            System.out.print(historial[i][0]);
                            System.out.println(historial[i][1]);
                            System.out.println("");
                        } else {
                            break;
                        }
                        System.out.println("*********************************");
                        System.out.println(" ");
                        System.out.println(" ");
                    }
                    break;
                }

                case 3 -> {
                    System.out.println("Saliste del juego.");
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
