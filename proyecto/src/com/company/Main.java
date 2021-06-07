package com.company;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//C:\Users\EPA\Desktop\PruebaTxt
//"C:\Users\ENRIQUE\Desktop\Practica1\Prueba\prueba.txt"

public class Main {
    static Scanner lec = new Scanner(System.in);
    double MatrizA[][];
    double MatrizB[][];
    double MatrizC[][];
    double MatrizD[][];
    double MatrizE[][];
    double MatrizF[][];
    double MatrizG[][];
    double MatrizH[][];
    double MatrizI[][];
    double MatrizJ[][];
    double MatrizK[][];
    double MatrizL[][];
    double MatrizM[][];
    double MatrizN[][];
    double MatrizO[][];
    double MatrizP[][];
    double MatrizQ[][];
    double MatrizS[][];
    double MatrizT[][];
    double MatrizU[][];
    double MatrizV[][];
    double MatrizW[][];
    double MatrizX[][];
    double MatrizY[][];
    double MatrizZ[][];
    double R[][];
    double PrimeraMatriz[][];
    double SegundaMatriz[][];
    double RR[][];
    Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Main menu = new Main();
        menu.Menu();
    }

    void Menu() {
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("===Seleccione lo que desea cargar===");
            System.out.println(" 1. Cargar Matrices");
            System.out.println(" 2. Sumar Matrices ");
            System.out.println(" 3. Restar Matrices");
            System.out.println(" 4. Multiplicar Matirices ");
            //   System.out.println(" 5. Por un numero");
            // System.out.println(" 6. Por otra Matriz");
            System.out.println(" 5. Dividir Matrices");
            System.out.println(" 6. Transpuesta de Matriz");
            System.out.println(" 7. Matriz Inversa");
            System.out.println(" 8. Potencia de una Matriz");
            System.out.println(" 9. Determinante de una Matriz");
            System.out.println("10. Salir");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: ");
            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();
            while (opccion < 1 || 10 < opccion) {
                System.out.println(">>>Error, Escribir una opción del 1 al 11>>>");
                opccion = lec.nextInt();
            }
            switch (opccion) {
                case 1:
                    lectura();
                    break;
                case 2:
                    SumaMatriz();
                    break;
                case 3:
                    RestaMatriz();
                    break;
                case 4:
                    Menu_Mult();
                    // MultMatriz();
                    break;
                case 5:
                    DivMatriz();

                    //Mult1Matriz();
                    break;
                case 6:
                    TransMatriz();
                    break;
                case 7:
                    Inversa();
                    break;
                case 8:
                    break;
                case 9:
                    Determinante();
                    break;
                case 10:
                    System.out.println("Gracias por usar el Menú bye :v ");
                    entrar_menu = false;
                    break;
            }
        }
    }

    void Menu_Mult() {
        boolean entrar_menu1 = true;
        while (entrar_menu1 == true) {
            System.out.println("===Menú_Multiplicación===");
            System.out.println(" 1. Multiplicar por un número");
            System.out.println(" 2. Multiplicar por otra matriz");
            System.out.println(" 3. Salir");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: ");
            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();
            while (opccion < 1 || 3 < opccion) {
                System.out.println(">>>Error, Escribir una opción del 1 al 3>>>");
                opccion = lec.nextInt();
            }
            switch (opccion) {
                case 1:
                    MultMatriz_por_numero();
                    break;
                case 2:
                    MultMatriz_Matriz();
                    break;
                case 3:
                    System.out.println("Gracias por usar el Menú_Multiplicación bye :v ");
                    entrar_menu1 = false;
                    break;
            }
        }

    }

    void lectura() {
        try {
            System.out.println("Ingrese la ruta de las matrices");
            System.out.print(">");
            String R1 = leer.nextLine();
            R1 = R1.replaceAll("\"", "");//REEMPLAZAR COMILLAS
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            try {
                archivo = new File(R1);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String contenido[] = linea.split(":");
                    char letra = contenido[0].charAt(0);

                    String Dfilas[] = contenido[1].split(";");
                    boolean vFilas = true;
                    String temporal[] = Dfilas[0].split(",");

                    int cantidad = temporal.length; // 3

                    for (int i = 1; i < Dfilas.length; i++) {
                        String pivote[] = Dfilas[i].split(",");
                        Dfilas[i] = Dfilas[i].trim();
                        int aux = pivote.length;
                        if (cantidad != aux) {
                            vFilas = false;
                        }
                    }
                    if (vFilas) {
                        asignacion(letra, Dfilas.length, cantidad, Dfilas);
                    } else {
                        System.out.println("Ocurrio un error");
                    }
                }
                while ((linea = br.readLine()) != null) {

                }
            } catch (IOException e) {
                leer.nextLine();
                System.out.println("error");
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (IOException e2) {
                    leer.nextLine();
                    System.out.println("otro error");
                }
            }
        } catch (Exception e) {
            leer.nextLine();
            System.out.println("Ocurrio un error.//" + "--");
        }
    }

    void asignacion(char Id, int filas, int columnas, String[] datos) {
        System.out.println(Id);
        switch (Id) {
            case 'A':
                MatrizA = llenado(filas, columnas, datos);
                I_double(MatrizA, 'A');
                break;
            case 'B':
                MatrizB = llenado(filas, columnas, datos);
                I_double(MatrizB, 'B');
                break;
            case 'C':
                MatrizC = llenado(filas, columnas, datos);
                I_double(MatrizC, 'C');
                break;
            case 'D':
                MatrizD = llenado(filas, columnas, datos);
                I_double(MatrizD, 'D');
                break;
            case 'E':
                MatrizE = llenado(filas, columnas, datos);
                I_double(MatrizE, 'E');
                break;
            case 'F':
                MatrizF = llenado(filas, columnas, datos);
                I_double(MatrizF, 'F');
                break;
            case 'G':
                MatrizG = llenado(filas, columnas, datos);
                I_double(MatrizG, 'G');
                break;
            case 'H':
                MatrizH = llenado(filas, columnas, datos);
                I_double(MatrizH, 'H');
                break;
            case 'I':
                MatrizI = llenado(filas, columnas, datos);
                I_double(MatrizI, 'I');
                break;
            case 'J':
                MatrizJ = llenado(filas, columnas, datos);
                I_double(MatrizJ, 'J');
                break;
            case 'K':
                MatrizK = llenado(filas, columnas, datos);
                I_double(MatrizK, 'K');
                break;
            case 'L':
                MatrizL = llenado(filas, columnas, datos);
                I_double(MatrizL, 'L');
                break;
            case 'M':
                MatrizM = llenado(filas, columnas, datos);
                I_double(MatrizM, 'M');
                break;
            case 'N':
                MatrizN = llenado(filas, columnas, datos);
                I_double(MatrizN, 'N');
                break;
            case 'O':
                MatrizO = llenado(filas, columnas, datos);
                I_double(MatrizO, 'O');
                break;
            case 'P':
                MatrizP = llenado(filas, columnas, datos);
                I_double(MatrizP, 'P');
                break;
            case 'Q':
                MatrizQ = llenado(filas, columnas, datos);
                I_double(MatrizQ, 'Q');
                break;
            case 'R':
                R = llenado(filas, columnas, datos);
                I_double(R, 'R');
                break;
            case 'S':
                MatrizS = llenado(filas, columnas, datos);
                I_double(MatrizS, 'S');
                break;
            case 'T':
                MatrizT = llenado(filas, columnas, datos);
                I_double(MatrizT, 'T');
                break;
            case 'U':
                MatrizU = llenado(filas, columnas, datos);
                I_double(MatrizU, 'U');
                break;
            case 'V':
                MatrizV = llenado(filas, columnas, datos);
                I_double(MatrizV, 'V');
                break;
            case 'W':
                MatrizW = llenado(filas, columnas, datos);
                I_double(MatrizW, 'W');
                break;
            case 'X':
                MatrizX = llenado(filas, columnas, datos);
                I_double(MatrizX, 'X');
                break;
            case 'Y':
                MatrizY = llenado(filas, columnas, datos);
                I_double(MatrizY, 'Y');
                break;
            case 'Z':
                MatrizZ = llenado(filas, columnas, datos);
                I_double(MatrizZ, 'Z');
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    double[][] llenado(int filas, int columnas, String[] datos) {
        int aux = 0;
        double[][] numeros = new double[filas][columnas];
        double[] pivote = new double[columnas];

        for (int i = 0; i < filas; i++) {
            String datosFilas[] = datos[i].split(",");
            for (int j = 0; j < columnas; j++) {
                pivote[j] = Double.parseDouble(datosFilas[j]);
            }
            if (aux < filas) {
                double temp[] = new double[pivote.length];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = pivote[j];
                }
                numeros[aux] = temp;
                aux++;
            }
        }
        return numeros;
    }

    void I_double(double[][] Nombre, char letra) {
        System.out.println("Matriz: " + letra);
        for (double[] Nombre1 : Nombre) {
            for (int j = 0; j < Nombre[0].length; j++) {
                // System.out.print("|" + matriz[i][j] + "|" + "\t");
                System.out.print(((double) (Math.round(Nombre1[j] * 100000d) / 100000d)) + "\t"); //imprimir
            }
            System.out.println("");//Imprimir
        }
        System.out.println("");
    }

    void SumaMatriz() {
        try {
            System.out.println("Ingrese el nombre de la Matriz 1: ");
            String A = leer.nextLine();
            A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            if (A != null) {
                if (A.equals("A")) {
                    PrimeraMatriz = MatrizA;
                }
                if (A.equals("B")) {
                    PrimeraMatriz = MatrizB;
                }
                if (A.equals("C")) {
                    PrimeraMatriz = MatrizC;
                }
                if (A.equals("D")) {
                    PrimeraMatriz = MatrizD;
                }
                if (A.equals("E")) {
                    PrimeraMatriz = MatrizE;
                }
                if (A.equals("F")) {
                    PrimeraMatriz = MatrizF;
                }
                if (A.equals("G")) {
                    PrimeraMatriz = MatrizG;
                }
                if (A.equals("H")) {
                    PrimeraMatriz = MatrizH;
                }
                if (A.equals("I")) {
                    PrimeraMatriz = MatrizI;
                }
                if (A.equals("J")) {
                    PrimeraMatriz = MatrizJ;
                }
                if (A.equals("K")) {
                    PrimeraMatriz = MatrizK;
                }
                if (A.equals("L")) {
                    PrimeraMatriz = MatrizL;
                }
                if (A.equals("M")) {
                    PrimeraMatriz = MatrizM;
                }
                if (A.equals("N")) {
                    PrimeraMatriz = MatrizN;
                }
                if (A.equals("O")) {
                    PrimeraMatriz = MatrizO;
                }
                if (A.equals("P")) {
                    PrimeraMatriz = MatrizP;
                }
                if (A.equals("Q")) {
                    PrimeraMatriz = MatrizQ;
                }
                if (A.equals("R")) {
                    PrimeraMatriz = R;
                }
                if (A.equals("S")) {
                    PrimeraMatriz = MatrizS;
                }
                if (A.equals("T")) {
                    PrimeraMatriz = MatrizT;
                }
                if (A.equals("U")) {
                    PrimeraMatriz = MatrizU;
                }
                if (A.equals("V")) {
                    PrimeraMatriz = MatrizV;
                }
                if (A.equals("W")) {
                    PrimeraMatriz = MatrizW;
                }
                if (A.equals("X")) {
                    PrimeraMatriz = MatrizX;
                }
                if (A.equals("Y")) {
                    PrimeraMatriz = MatrizY;
                }
                if (A.equals("Z")) {
                    PrimeraMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
            }

            I_double(PrimeraMatriz, 'A');

            System.out.println("Ingrese el nombre de la Matriz 2: ");
            String B = leer.nextLine();
            B = B.toUpperCase();// conviertiendo el mensaje a MAYUSCULA

            if (B != null) {
                if (B.equals("A")) {
                    SegundaMatriz = MatrizA;
                }
                if (B.equals("B")) {
                    SegundaMatriz = MatrizB;
                }
                if (B.equals("C")) {
                    SegundaMatriz = MatrizC;
                }
                if (B.equals("D")) {
                    SegundaMatriz = MatrizD;
                }
                if (B.equals("E")) {
                    SegundaMatriz = MatrizE;
                }
                if (B.equals("F")) {
                    SegundaMatriz = MatrizF;
                }
                if (B.equals("G")) {
                    SegundaMatriz = MatrizG;
                }
                if (B.equals("H")) {
                    SegundaMatriz = MatrizH;
                }
                if (B.equals("I")) {
                    SegundaMatriz = MatrizI;
                }
                if (B.equals("J")) {
                    SegundaMatriz = MatrizJ;
                }
                if (B.equals("K")) {
                    SegundaMatriz = MatrizK;
                }
                if (B.equals("L")) {
                    SegundaMatriz = MatrizL;
                }
                if (B.equals("M")) {
                    SegundaMatriz = MatrizM;
                }
                if (B.equals("N")) {
                    SegundaMatriz = MatrizN;
                }
                if (B.equals("O")) {
                    SegundaMatriz = MatrizO;
                }
                if (B.equals("P")) {
                    SegundaMatriz = MatrizP;
                }
                if (B.equals("Q")) {
                    SegundaMatriz = MatrizQ;
                }
                if (B.equals("R")) {
                    SegundaMatriz = R;
                }
                if (B.equals("S")) {
                    SegundaMatriz = MatrizS;
                }
                if (B.equals("T")) {
                    SegundaMatriz = MatrizT;
                }
                if (B.equals("U")) {
                    SegundaMatriz = MatrizU;
                }
                if (B.equals("V")) {
                    SegundaMatriz = MatrizV;
                }
                if (B.equals("W")) {
                    SegundaMatriz = MatrizW;
                }
                if (B.equals("X")) {
                    SegundaMatriz = MatrizX;
                }
                if (B.equals("Y")) {
                    SegundaMatriz = MatrizY;
                }
                if (B.equals("Z")) {
                    SegundaMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + B + " Esta vacia o tienen mal sus datos ");
            }

            I_double(SegundaMatriz, 'B');

            double[][] R = new double[PrimeraMatriz.length][SegundaMatriz[0].length];//instanciando matriz final


            if (PrimeraMatriz.length == SegundaMatriz.length && PrimeraMatriz[0].length == SegundaMatriz[0].length) {
                for (int i = 0; i < PrimeraMatriz.length; i++) {
                    for (int j = 0; j < PrimeraMatriz[i].length; j++) {
                        R[i][j] = PrimeraMatriz[i][j] + SegundaMatriz[i][j];
                    }
                }
                System.out.println("------------------");
                System.out.println("La Suma es:");

                //  I_double(R, 'R');
                System.out.println("-|La Matriz Resultante es|-");
                Mostrarmatriz(R);
                System.out.println("------------------");
            } else {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Las Matrices no tienen las mismas dimensiones para realizar la operacion");
                System.out.println("------------------------------------------------------------------------");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void RestaMatriz() {
        try {
            System.out.println("Ingrese el nombre de la Matriz 1: ");
            String A = leer.nextLine();
            A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            if (A != null) {

                if (A.equals("A")) {
                    PrimeraMatriz = MatrizA;
                }
                if (A.equals("B")) {
                    PrimeraMatriz = MatrizB;
                }
                if (A.equals("C")) {
                    PrimeraMatriz = MatrizC;
                }
                if (A.equals("D")) {
                    PrimeraMatriz = MatrizD;
                }
                if (A.equals("E")) {
                    PrimeraMatriz = MatrizE;
                }
                if (A.equals("F")) {
                    PrimeraMatriz = MatrizF;
                }
                if (A.equals("G")) {
                    PrimeraMatriz = MatrizG;
                }
                if (A.equals("H")) {
                    PrimeraMatriz = MatrizH;
                }
                if (A.equals("I")) {
                    PrimeraMatriz = MatrizI;
                }
                if (A.equals("J")) {
                    PrimeraMatriz = MatrizJ;
                }
                if (A.equals("K")) {
                    PrimeraMatriz = MatrizK;
                }
                if (A.equals("L")) {
                    PrimeraMatriz = MatrizL;
                }
                if (A.equals("M")) {
                    PrimeraMatriz = MatrizM;
                }
                if (A.equals("N")) {
                    PrimeraMatriz = MatrizN;
                }
                if (A.equals("O")) {
                    PrimeraMatriz = MatrizO;
                }
                if (A.equals("P")) {
                    PrimeraMatriz = MatrizP;
                }
                if (A.equals("Q")) {
                    PrimeraMatriz = MatrizQ;
                }
                if (A.equals("R")) {
                    PrimeraMatriz = R;
                }
                if (A.equals("S")) {
                    PrimeraMatriz = MatrizS;
                }
                if (A.equals("T")) {
                    PrimeraMatriz = MatrizT;
                }
                if (A.equals("U")) {
                    PrimeraMatriz = MatrizU;
                }
                if (A.equals("V")) {
                    PrimeraMatriz = MatrizV;
                }
                if (A.equals("W")) {
                    PrimeraMatriz = MatrizW;
                }
                if (A.equals("X")) {
                    PrimeraMatriz = MatrizX;
                }
                if (A.equals("Y")) {
                    PrimeraMatriz = MatrizY;
                }
                if (A.equals("Z")) {
                    PrimeraMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + A + " Esta vacia o tienen mal sus datos ");
            }

            I_double(PrimeraMatriz, 'A');

            System.out.println("Ingrese el nombre de la Matriz 2: ");
            String B = leer.nextLine();
            B = B.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            if (A != null) {
                if (B.equals("A")) {
                    SegundaMatriz = MatrizA;
                }
                if (B.equals("B")) {
                    SegundaMatriz = MatrizB;
                }
                if (B.equals("C")) {
                    SegundaMatriz = MatrizC;
                }
                if (B.equals("D")) {
                    SegundaMatriz = MatrizD;
                }
                if (B.equals("E")) {
                    SegundaMatriz = MatrizE;
                }
                if (B.equals("F")) {
                    SegundaMatriz = MatrizF;
                }
                if (B.equals("G")) {
                    SegundaMatriz = MatrizG;
                }
                if (B.equals("H")) {
                    SegundaMatriz = MatrizH;
                }
                if (B.equals("I")) {
                    SegundaMatriz = MatrizI;
                }
                if (B.equals("J")) {
                    SegundaMatriz = MatrizJ;
                }
                if (B.equals("K")) {
                    SegundaMatriz = MatrizK;
                }
                if (B.equals("L")) {
                    SegundaMatriz = MatrizL;
                }
                if (B.equals("M")) {
                    SegundaMatriz = MatrizM;
                }
                if (B.equals("N")) {
                    SegundaMatriz = MatrizN;
                }
                if (B.equals("O")) {
                    SegundaMatriz = MatrizO;
                }
                if (B.equals("P")) {
                    SegundaMatriz = MatrizP;
                }
                if (B.equals("Q")) {
                    SegundaMatriz = MatrizQ;
                }
                if (B.equals("R")) {
                    SegundaMatriz = R;
                }
                if (B.equals("S")) {
                    SegundaMatriz = MatrizS;
                }
                if (B.equals("T")) {
                    SegundaMatriz = MatrizT;
                }
                if (B.equals("U")) {
                    SegundaMatriz = MatrizU;
                }
                if (B.equals("V")) {
                    SegundaMatriz = MatrizV;
                }
                if (B.equals("W")) {
                    SegundaMatriz = MatrizW;
                }
                if (B.equals("X")) {
                    SegundaMatriz = MatrizX;
                }
                if (B.equals("Y")) {
                    SegundaMatriz = MatrizY;
                }
                if (B.equals("Z")) {
                    SegundaMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + B + " Esta vacia o tiene mal sus datos ");

            }

            I_double(SegundaMatriz, 'B');

            double[][] R = new double[PrimeraMatriz.length][SegundaMatriz[0].length];//instanciando matriz final
            if (PrimeraMatriz.length == SegundaMatriz.length && PrimeraMatriz[0].length == SegundaMatriz[0].length) {
                for (int i = 0; i < PrimeraMatriz.length; i++) {
                    for (int j = 0; j < PrimeraMatriz[i].length; j++) {
                        R[i][j] = PrimeraMatriz[i][j] - SegundaMatriz[i][j];
                    }
                }
                System.out.println("------------------");
                System.out.println("La Resta es:");

                //  I_double(R, 'R');
                System.out.println("-|La Matriz Resultante es|-");
                Mostrarmatriz(R);
                System.out.println("------------------");
            } else {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Las Matrices no tienen las mismas dimensiones para realizar la operacion");
                System.out.println("------------------------------------------------------------------------");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void MultMatriz_por_numero() {
        try {
            System.out.println("Ingrese el nombre de la Matriz: ");
            String A = leer.nextLine();
            A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            if (A != null) {

                if (A.equals("A")) {
                    PrimeraMatriz = MatrizA;
                }
                if (A.equals("B")) {
                    PrimeraMatriz = MatrizB;
                }
                if (A.equals("C")) {
                    PrimeraMatriz = MatrizC;
                }
                if (A.equals("D")) {
                    PrimeraMatriz = MatrizD;
                }
                if (A.equals("E")) {
                    PrimeraMatriz = MatrizE;
                }
                if (A.equals("F")) {
                    PrimeraMatriz = MatrizF;
                }
                if (A.equals("G")) {
                    PrimeraMatriz = MatrizG;
                }
                if (A.equals("H")) {
                    PrimeraMatriz = MatrizH;
                }
                if (A.equals("I")) {
                    PrimeraMatriz = MatrizI;
                }
                if (A.equals("J")) {
                    PrimeraMatriz = MatrizJ;
                }
                if (A.equals("K")) {
                    PrimeraMatriz = MatrizK;
                }
                if (A.equals("L")) {
                    PrimeraMatriz = MatrizL;
                }
                if (A.equals("M")) {
                    PrimeraMatriz = MatrizM;
                }
                if (A.equals("N")) {
                    PrimeraMatriz = MatrizN;
                }
                if (A.equals("O")) {
                    PrimeraMatriz = MatrizO;
                }
                if (A.equals("P")) {
                    PrimeraMatriz = MatrizP;
                }
                if (A.equals("Q")) {
                    PrimeraMatriz = MatrizQ;
                }
                if (A.equals("R")) {
                    PrimeraMatriz = R;
                }
                if (A.equals("S")) {
                    PrimeraMatriz = MatrizS;
                }
                if (A.equals("T")) {
                    PrimeraMatriz = MatrizT;
                }
                if (A.equals("U")) {
                    PrimeraMatriz = MatrizU;
                }
                if (A.equals("V")) {
                    PrimeraMatriz = MatrizV;
                }
                if (A.equals("W")) {
                    PrimeraMatriz = MatrizW;
                }
                if (A.equals("X")) {
                    PrimeraMatriz = MatrizX;
                }
                if (A.equals("Y")) {
                    PrimeraMatriz = MatrizY;
                }
                if (A.equals("Z")) {
                    PrimeraMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
            }
            I_double(PrimeraMatriz, 'R');

            System.out.println("Ingrese el numero para la multiplicación: ");
            String num;
            int n1;
            num = leer.nextLine();
            n1 = Integer.parseInt(num);


            double[][] R = new double[PrimeraMatriz.length][PrimeraMatriz[0].length];
            for (int i = 0; i < PrimeraMatriz.length; i++) {
                for (int j = 0; j < PrimeraMatriz[i].length; j++) {
                    R[i][j] = n1 * (PrimeraMatriz[i][j]);
                }
            }


            System.out.println("------------------");
            System.out.println("La Multiplicación es:");
            System.out.println("La Matriz Resultante  ");
            Mostrarmatriz(R);

            //  I_double(R, 'R');
            System.out.println("------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void MultMatriz_Matriz() {
        try {
            System.out.println("Ingrese el nombre de la Matriz: ");
            String A = leer.nextLine();
            A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            if (A != null) {
                if (A.equals("A")) {
                    PrimeraMatriz = MatrizA;
                }
                if (A.equals("B")) {
                    PrimeraMatriz = MatrizB;
                }
                if (A.equals("C")) {
                    PrimeraMatriz = MatrizC;
                }
                if (A.equals("D")) {
                    PrimeraMatriz = MatrizD;
                }
                if (A.equals("E")) {
                    PrimeraMatriz = MatrizE;
                }
                if (A.equals("F")) {
                    PrimeraMatriz = MatrizF;
                }
                if (A.equals("G")) {
                    PrimeraMatriz = MatrizG;
                }
                if (A.equals("H")) {
                    PrimeraMatriz = MatrizH;
                }
                if (A.equals("I")) {
                    PrimeraMatriz = MatrizI;
                }
                if (A.equals("J")) {
                    PrimeraMatriz = MatrizJ;
                }
                if (A.equals("K")) {
                    PrimeraMatriz = MatrizK;
                }
                if (A.equals("L")) {
                    PrimeraMatriz = MatrizL;
                }
                if (A.equals("M")) {
                    PrimeraMatriz = MatrizM;
                }
                if (A.equals("N")) {
                    PrimeraMatriz = MatrizN;
                }
                if (A.equals("O")) {
                    PrimeraMatriz = MatrizO;
                }
                if (A.equals("P")) {
                    PrimeraMatriz = MatrizP;
                }
                if (A.equals("Q")) {
                    PrimeraMatriz = MatrizQ;
                }
                if (A.equals("R")) {
                    PrimeraMatriz = R;
                }
                if (A.equals("S")) {
                    PrimeraMatriz = MatrizS;
                }
                if (A.equals("T")) {
                    PrimeraMatriz = MatrizT;
                }
                if (A.equals("U")) {
                    PrimeraMatriz = MatrizU;
                }
                if (A.equals("V")) {
                    PrimeraMatriz = MatrizV;
                }
                if (A.equals("W")) {
                    PrimeraMatriz = MatrizW;
                }
                if (A.equals("X")) {
                    PrimeraMatriz = MatrizX;
                }
                if (A.equals("Y")) {
                    PrimeraMatriz = MatrizY;
                }
                if (A.equals("Z")) {
                    PrimeraMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
            }
            I_double(PrimeraMatriz, 'R');

            System.out.println("Ingrese el nombre de la Matriz 2: ");
            String B = leer.nextLine();
            B = B.toUpperCase();// conviertiendo el mensaje a MAYUSCULA


            if (B != null) {
                if (B.equals("A")) {
                    SegundaMatriz = MatrizA;
                }
                if (B.equals("B")) {
                    SegundaMatriz = MatrizB;
                }
                if (B.equals("C")) {
                    SegundaMatriz = MatrizC;
                }
                if (B.equals("D")) {
                    SegundaMatriz = MatrizD;
                }
                if (B.equals("E")) {
                    SegundaMatriz = MatrizE;
                }
                if (B.equals("F")) {
                    SegundaMatriz = MatrizF;
                }
                if (B.equals("G")) {
                    SegundaMatriz = MatrizG;
                }
                if (B.equals("H")) {
                    SegundaMatriz = MatrizH;
                }
                if (B.equals("I")) {
                    SegundaMatriz = MatrizI;
                }
                if (B.equals("J")) {
                    SegundaMatriz = MatrizJ;
                }
                if (B.equals("K")) {
                    SegundaMatriz = MatrizK;
                }
                if (B.equals("L")) {
                    SegundaMatriz = MatrizL;
                }
                if (B.equals("M")) {
                    SegundaMatriz = MatrizM;
                }
                if (B.equals("N")) {
                    SegundaMatriz = MatrizN;
                }
                if (B.equals("O")) {
                    SegundaMatriz = MatrizO;
                }
                if (B.equals("P")) {
                    SegundaMatriz = MatrizP;
                }
                if (B.equals("Q")) {
                    SegundaMatriz = MatrizQ;
                }
                if (B.equals("R")) {
                    SegundaMatriz = R;
                }
                if (B.equals("S")) {
                    SegundaMatriz = MatrizS;
                }
                if (B.equals("T")) {
                    SegundaMatriz = MatrizT;
                }
                if (B.equals("U")) {
                    SegundaMatriz = MatrizU;
                }
                if (B.equals("V")) {
                    SegundaMatriz = MatrizV;
                }
                if (B.equals("W")) {
                    SegundaMatriz = MatrizW;
                }
                if (B.equals("X")) {
                    SegundaMatriz = MatrizX;
                }
                if (B.equals("Y")) {
                    SegundaMatriz = MatrizY;
                }
                if (B.equals("Z")) {
                    SegundaMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + B + " Esta vacia o tiene mal sus datos ");
            }
            I_double(SegundaMatriz, 'B');

            R = multiplicar(PrimeraMatriz, SegundaMatriz);

            System.out.println("------------------");
            System.out.println("La Multiplicación es:");
            Mostrarmatriz(R);
            // I_double(R, 'R');
            System.out.println("------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static double[][] multiplicar(double[][] a, double[][] b) {
        double[][] producto = new double[a.length][b[0].length];//instanciando matriz final
        // se comprueba si las matrices se pueden multiplicar
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {//recorre filas
                for (int j = 0; j < b[0].length; j++) {//recorre columnas
                    for (int k = 0; k < a[0].length; k++) {
                        // aquí se multiplica la matriz
                        producto[i][j] += a[i][k] * b[k][j]; //son operadores de asignación combinados,
                        //o sea, que en vez de reemplazar el valor de una variable,
                        //utilizando el igual (=), suma ese valor a dicha variable (+=), ejemplo:
//x = 3
//x = 10
//x += 5 }
                    }
                }
                // MostrarmatrizC(producto);
            }
        }
        return producto;

    }

    public static double[][] inversa_orden3(double B[][]) {
        //Declaramos variables
        double determinante, x00, x01, x02, x10, x11, x12, x20, x21, x22;
        // Declaramos nuestra matriz principal

        // Matriz inversa
        double C[][] = new double[B.length][B[0].length];

        //Hallamos determinante de nuestra matriz principal
        determinante = (B[0][0] * ((B[1][1] * B[2][2]) - (B[1][2] * B[2][1]))) - (B[0][1] * ((B[1][0] * B[2][2]) - (B[2][0] * B[1][2]))) + (B[0][2] * ((B[1][0] * B[2][1]) - (B[2][0] * B[1][1])));
        System.out.println();
        // System.out.println("Determinante:" + determinante);
        System.out.println();
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if (determinante != 0) {
            x00 = ((B[1][1] * B[2][2] - B[2][1] * B[1][2])) / determinante;
            x01 = (-(B[1][0] * B[2][2] - B[2][0] * B[1][2])) / determinante;
            x02 = ((B[1][0] * B[2][1] - B[2][0] * B[1][1])) / determinante;
            x10 = (-(B[0][1] * B[2][2] - B[2][1] * B[0][2])) / determinante;
            x11 = ((B[0][0] * B[2][2] - B[2][0] * B[0][2])) / determinante;
            x12 = (-(B[0][0] * B[2][1] - B[2][0] * B[0][1])) / determinante;
            x20 = ((B[0][1] * B[1][2] - B[1][1] * B[0][2])) / determinante;
            x21 = (-(B[0][0] * B[1][2] - B[1][0] * B[0][2])) / determinante;
            x22 = ((B[0][0] * B[1][1] - B[1][0] * B[0][1])) / determinante;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0] = x00;
            C[0][1] = x10;
            C[0][2] = x20;
            C[1][0] = x01;
            C[1][1] = x11;
            C[1][2] = x21;
            C[2][0] = x02;
            C[2][1] = x12;
            C[2][2] = x22;
            // Mostramos la matriz inversa
            System.out.println("--------------------------------------------------");
            System.out.println(">> Matriz inversa  es <<");
            System.out.println("--------------------------------------------------");
            /*for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print("|"+ C[i][j] +"|");
                }
                System.out.println();
            } */
        } else {
            //  System.out.print("Error la matriz no tiene inversa");
        }
        return C;

    }

    public static double[][] inversa_orden2(double B[][]) {
        //Declaramos variables
        double determinante, x00, x01, x10, x11;
        // Declaramos nuestra matriz principal

        // Matriz inversa
        double C[][] = new double[B.length][B[0].length];

        //Hallamos determinante de nuestra matriz principal
        determinante = ((B[0][0] * (B[1][1])) - (B[0][1] * ((B[1][0]))));
        System.out.println();
        // System.out.println("Determinante:" + determinante);
        System.out.println();
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if (determinante != 0) {
            x00 = ((B[1][1])) / determinante;
            x01 = (-(B[1][0])) / determinante;
            x10 = (-(B[0][1])) / determinante;
            x11 = ((B[0][0])) / determinante;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0] = x00;
            C[0][1] = x10;
            C[1][0] = x01;
            C[1][1] = x11;
            // Mostramos la matriz inversa
            System.out.println("--------------------------------------------------");
            System.out.println(">> Matriz inversa  es <<");
            System.out.println("--------------------------------------------------");
            /*for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print("|"+ C[i][j] +"|");
                }
                System.out.println();
            } */
        } else {
            // System.out.print("Error la matriz no tiene inversa");
        }
        return C;

    }

    public static double[][] Det_orden2(double B[][]) {
        //Declaramos variables
        double determinante, x00, x01, x10, x11;
        // Declaramos nuestra matriz principal

        // Matriz inversa
        double C[][] = new double[B.length][B[0].length];
        //Hallamos determinante de nuestra matriz principal
        determinante = ((B[0][0] * (B[1][1])) - (B[0][1] * ((B[1][0]))));
        System.out.println("------------------------------------------");
        System.out.println("Determinante es:" + determinante);
        System.out.println("------------------------------------------");
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if (determinante != 0) {
            x00 = ((B[1][1])) / determinante;
            x01 = (-(B[1][0])) / determinante;
            x10 = (-(B[0][1])) / determinante;
            x11 = ((B[0][0])) / determinante;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0] = x00;
            C[0][1] = x10;
            C[1][0] = x01;
            C[1][1] = x11;
            // Mostramos la matriz inversa

            /*for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print("|"+ C[i][j] +"|");
                }
                System.out.println();
            } */
        } else {
            // System.out.print("Error la matriz no tiene inversa");
        }
        return C;


    }

    public static double[][] Det_orden3(double B[][]) {
        //Declaramos variables
        double determinante, x00, x01, x02, x10, x11, x12, x20, x21, x22;
        // Declaramos nuestra matriz principal

        // Matriz inversa
        double C[][] = new double[B.length][B[0].length];

        //Hallamos determinante de nuestra matriz principal
        determinante = (B[0][0] * ((B[1][1] * B[2][2]) - (B[1][2] * B[2][1]))) - (B[0][1] * ((B[1][0] * B[2][2]) - (B[2][0] * B[1][2]))) + (B[0][2] * ((B[1][0] * B[2][1]) - (B[2][0] * B[1][1])));
        System.out.println("---------------------------------");
        System.out.println("Determinante es :" + determinante);
        System.out.println("---------------------------------");
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if (determinante != 0) {
            x00 = ((B[1][1] * B[2][2] - B[2][1] * B[1][2])) / determinante;
            x01 = (-(B[1][0] * B[2][2] - B[2][0] * B[1][2])) / determinante;
            x02 = ((B[1][0] * B[2][1] - B[2][0] * B[1][1])) / determinante;
            x10 = (-(B[0][1] * B[2][2] - B[2][1] * B[0][2])) / determinante;
            x11 = ((B[0][0] * B[2][2] - B[2][0] * B[0][2])) / determinante;
            x12 = (-(B[0][0] * B[2][1] - B[2][0] * B[0][1])) / determinante;
            x20 = ((B[0][1] * B[1][2] - B[1][1] * B[0][2])) / determinante;
            x21 = (-(B[0][0] * B[1][2] - B[1][0] * B[0][2])) / determinante;
            x22 = ((B[0][0] * B[1][1] - B[1][0] * B[0][1])) / determinante;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0] = x00;
            C[0][1] = x10;
            C[0][2] = x20;
            C[1][0] = x01;
            C[1][1] = x11;
            C[1][2] = x21;
            C[2][0] = x02;
            C[2][1] = x12;
            C[2][2] = x22;
            // Mostramos la matriz inversa

            /*for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print("|"+ C[i][j] +"|");
                }
                System.out.println();
            } */
        } else {
            //  System.out.print("Error la matriz no tiene inversa");
        }
        return C;


    }

    void DivMatriz() {
        try {
            System.out.println("Ingrese el nombre de la Matriz 1: ");
            String A = leer.nextLine();
            A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            if (A != null) {
                if (A.equals("A")) {
                    PrimeraMatriz = MatrizA;
                }
                if (A.equals("B")) {
                    PrimeraMatriz = MatrizB;
                }
                if (A.equals("C")) {
                    PrimeraMatriz = MatrizC;
                }
                if (A.equals("D")) {
                    PrimeraMatriz = MatrizD;
                }
                if (A.equals("E")) {
                    PrimeraMatriz = MatrizE;
                }
                if (A.equals("F")) {
                    PrimeraMatriz = MatrizF;
                }
                if (A.equals("G")) {
                    PrimeraMatriz = MatrizG;
                }
                if (A.equals("H")) {
                    PrimeraMatriz = MatrizH;
                }
                if (A.equals("I")) {
                    PrimeraMatriz = MatrizI;
                }
                if (A.equals("J")) {
                    PrimeraMatriz = MatrizJ;
                }
                if (A.equals("K")) {
                    PrimeraMatriz = MatrizK;
                }
                if (A.equals("L")) {
                    PrimeraMatriz = MatrizL;
                }
                if (A.equals("M")) {
                    PrimeraMatriz = MatrizM;
                }
                if (A.equals("N")) {
                    PrimeraMatriz = MatrizN;
                }
                if (A.equals("O")) {
                    PrimeraMatriz = MatrizO;
                }
                if (A.equals("P")) {
                    PrimeraMatriz = MatrizP;
                }
                if (A.equals("Q")) {
                    PrimeraMatriz = MatrizQ;
                }
                if (A.equals("R")) {
                    PrimeraMatriz = R;
                }
                if (A.equals("S")) {
                    PrimeraMatriz = MatrizS;
                }
                if (A.equals("T")) {
                    PrimeraMatriz = MatrizT;
                }
                if (A.equals("U")) {
                    PrimeraMatriz = MatrizU;
                }
                if (A.equals("V")) {
                    PrimeraMatriz = MatrizV;
                }
                if (A.equals("W")) {
                    PrimeraMatriz = MatrizW;
                }
                if (A.equals("X")) {
                    PrimeraMatriz = MatrizX;
                }
                if (A.equals("Y")) {
                    PrimeraMatriz = MatrizY;
                }
                if (A.equals("Z")) {
                    PrimeraMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
            }

            I_double(PrimeraMatriz, 'A');

            System.out.println("Ingrese el nombre de la Matriz 2 (A-Z): ");
            String B = leer.nextLine();
            B = B.toUpperCase();// conviertiendo el mensaje a MAYUSCULA

            if (B != null) {
                if (B.equals("A")) {
                    SegundaMatriz = MatrizA;
                }
                if (B.equals("B")) {
                    SegundaMatriz = MatrizB;
                }
                if (B.equals("C")) {
                    SegundaMatriz = MatrizC;
                }
                if (B.equals("D")) {
                    SegundaMatriz = MatrizD;
                }
                if (B.equals("E")) {
                    SegundaMatriz = MatrizE;
                }
                if (B.equals("F")) {
                    SegundaMatriz = MatrizF;
                }
                if (B.equals("G")) {
                    SegundaMatriz = MatrizG;
                }
                if (B.equals("H")) {
                    SegundaMatriz = MatrizH;
                }
                if (B.equals("I")) {
                    SegundaMatriz = MatrizI;
                }
                if (B.equals("J")) {
                    SegundaMatriz = MatrizJ;
                }
                if (B.equals("K")) {
                    SegundaMatriz = MatrizK;
                }
                if (B.equals("L")) {
                    SegundaMatriz = MatrizL;
                }
                if (B.equals("M")) {
                    SegundaMatriz = MatrizM;
                }
                if (B.equals("N")) {
                    SegundaMatriz = MatrizN;
                }
                if (B.equals("O")) {
                    SegundaMatriz = MatrizO;
                }
                if (B.equals("P")) {
                    SegundaMatriz = MatrizP;
                }
                if (B.equals("Q")) {
                    SegundaMatriz = MatrizQ;
                }
                if (B.equals("R")) {
                    SegundaMatriz = R;
                }
                if (B.equals("S")) {
                    SegundaMatriz = MatrizS;
                }
                if (B.equals("T")) {
                    SegundaMatriz = MatrizT;
                }
                if (B.equals("U")) {
                    SegundaMatriz = MatrizU;
                }
                if (B.equals("V")) {
                    SegundaMatriz = MatrizV;
                }
                if (B.equals("W")) {
                    SegundaMatriz = MatrizW;
                }
                if (B.equals("X")) {
                    SegundaMatriz = MatrizX;
                }
                if (B.equals("Y")) {
                    SegundaMatriz = MatrizY;
                }
                if (B.equals("Z")) {
                    SegundaMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + B + " Esta vacia o tienen mal sus datos ");
            }

            I_double(SegundaMatriz, 'B');
            if (SegundaMatriz.length == SegundaMatriz[0].length) {//si son cuadradas entra para hacer la inversa
                //de lo contrario nel
                int aux = 0;//SE UTILIZA el aux para saber la dimension de la matriz
                for (int i = 0; i < SegundaMatriz.length; i++) {
                    for (int j = 0; j < SegundaMatriz[i].length; j++) {
                        //System.out.print("|" + matriz[i][j] + "|" + "\t");

                    }
                    aux++;//se usa el contador para saber que dimension es
                }
                //System.out.println("el aux tiene valor de "+aux);
                if (aux == 2) {
                    RR = inversa_orden2(SegundaMatriz);//llamando metodo de inversa orden 2
                    Mostrarmeinversa(RR);//imprimiendo matriz
                    R = multiplicar(RR, PrimeraMatriz);
                    System.out.println("La division es:");
                    Mostrarmatriz(R);

                }
                if (aux == 3) {
                    RR = inversa_orden3(SegundaMatriz);//llamando metodo de inversa orden 3
                    Mostrarmeinversa(RR);//imprimiendo matriz
                    R = multiplicar(RR, PrimeraMatriz);
                    System.out.println("La division es:");
                    Mostrarmatriz(R);
                } else {
                    System.out.println("No es posible resolver la inversa de la matriz");
                    System.out.println("Solo se puede resolver hasta grado 3 revisar la matriz entrante.");
                }
            }


            System.out.println("------------------");
            System.out.println("La División es:");
            System.out.println("-|Matriz Resultante|-");
            Mostrarmatriz(R);
            // I_double(R, 'R');
            System.out.println("------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void Inversa() {
        try {
            System.out.println("Ingrese el nombre de la Matriz (A-Z): ");
            String A = leer.nextLine();
            A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            if (A != null) {
                if (A.equals("A")) {
                    PrimeraMatriz = MatrizA;
                }
                if (A.equals("B")) {
                    PrimeraMatriz = MatrizB;
                }
                if (A.equals("C")) {
                    PrimeraMatriz = MatrizC;
                }
                if (A.equals("D")) {
                    PrimeraMatriz = MatrizD;
                }
                if (A.equals("E")) {
                    PrimeraMatriz = MatrizE;
                }
                if (A.equals("F")) {
                    PrimeraMatriz = MatrizF;
                }
                if (A.equals("G")) {
                    PrimeraMatriz = MatrizG;
                }
                if (A.equals("H")) {
                    PrimeraMatriz = MatrizH;
                }
                if (A.equals("I")) {
                    PrimeraMatriz = MatrizI;
                }
                if (A.equals("J")) {
                    PrimeraMatriz = MatrizJ;
                }
                if (A.equals("K")) {
                    PrimeraMatriz = MatrizK;
                }
                if (A.equals("L")) {
                    PrimeraMatriz = MatrizL;
                }
                if (A.equals("M")) {
                    PrimeraMatriz = MatrizM;
                }
                if (A.equals("N")) {
                    PrimeraMatriz = MatrizN;
                }
                if (A.equals("O")) {
                    PrimeraMatriz = MatrizO;
                }
                if (A.equals("P")) {
                    PrimeraMatriz = MatrizP;
                }
                if (A.equals("Q")) {
                    PrimeraMatriz = MatrizQ;
                }
                if (A.equals("R")) {
                    PrimeraMatriz = R;
                }
                if (A.equals("S")) {
                    PrimeraMatriz = MatrizS;
                }
                if (A.equals("T")) {
                    PrimeraMatriz = MatrizT;
                }
                if (A.equals("U")) {
                    PrimeraMatriz = MatrizU;
                }
                if (A.equals("V")) {
                    PrimeraMatriz = MatrizV;
                }
                if (A.equals("W")) {
                    PrimeraMatriz = MatrizW;
                }
                if (A.equals("X")) {
                    PrimeraMatriz = MatrizX;
                }
                if (A.equals("Y")) {
                    PrimeraMatriz = MatrizY;
                }
                if (A.equals("Z")) {
                    PrimeraMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
            }
            Mostrarmatriz(PrimeraMatriz);
            int aux = 0;//SE UTILIZA el aux para saber la dimension de la matriz
            for (int i = 0; i < PrimeraMatriz.length; i++) {
                for (int j = 0; j < PrimeraMatriz[i].length; j++) {
                    //System.out.print("|" + matriz[i][j] + "|" + "\t");

                }
                aux++;//se usa el contador para saber que dimension es
            }
            //System.out.println("el aux tiene valor de "+aux);

            if (PrimeraMatriz.length == PrimeraMatriz[0].length) {//si son cuadradas entra para hacer la inversa
                //de lo contrario nel
                if (aux == 2) {
                    R = inversa_orden2(PrimeraMatriz);//llamando metodo de inversa orden 2
                    Mostrarmeinversa(R);//imprimiendo matriz
                }
                if (aux == 3) {
                    R = inversa_orden3(PrimeraMatriz);//llamando metodo de inversa orden 3
                    Mostrarmeinversa(R);//imprimiendo matriz
                } else {
                    System.out.println("No es posible resolver la inversa de la matriz");
                    System.out.println("Solo se puede resolver hasta grado 3 revisar la matriz entrante.");
                }
            }


            //R=inversa_funcion(PrimeraMatriz);
            // R=inversa_orden2(PrimeraMatriz);
            // Mostrarmeinversa(R);
            //  I_double(PrimeraMatriz, 'A');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void TransMatriz() {
        try {
            System.out.println("Ingrese el nombre de la Matriz: ");
            String A = leer.nextLine();

            if (A.equals("A")) {
                PrimeraMatriz = MatrizA;
            }
            if (A.equals("B")) {
                PrimeraMatriz = MatrizB;
            }
            if (A.equals("C")) {
                PrimeraMatriz = MatrizC;
            }
            if (A.equals("D")) {
                PrimeraMatriz = MatrizD;
            }
            if (A.equals("E")) {
                PrimeraMatriz = MatrizE;
            }
            if (A.equals("F")) {
                PrimeraMatriz = MatrizF;
            }
            if (A.equals("G")) {
                PrimeraMatriz = MatrizG;
            }
            if (A.equals("H")) {
                PrimeraMatriz = MatrizH;
            }
            if (A.equals("I")) {
                PrimeraMatriz = MatrizI;
            }
            if (A.equals("J")) {
                PrimeraMatriz = MatrizJ;
            }
            if (A.equals("K")) {
                PrimeraMatriz = MatrizK;
            }
            if (A.equals("L")) {
                PrimeraMatriz = MatrizL;
            }
            if (A.equals("M")) {
                PrimeraMatriz = MatrizM;
            }
            if (A.equals("N")) {
                PrimeraMatriz = MatrizN;
            }
            if (A.equals("O")) {
                PrimeraMatriz = MatrizO;
            }
            if (A.equals("P")) {
                PrimeraMatriz = MatrizP;
            }
            if (A.equals("Q")) {
                PrimeraMatriz = MatrizQ;
            }
            if (A.equals("R")) {
                PrimeraMatriz = R;
            }
            if (A.equals("S")) {
                PrimeraMatriz = MatrizS;
            }
            if (A.equals("T")) {
                PrimeraMatriz = MatrizT;
            }
            if (A.equals("U")) {
                PrimeraMatriz = MatrizU;
            }
            if (A.equals("V")) {
                PrimeraMatriz = MatrizV;
            }
            if (A.equals("W")) {
                PrimeraMatriz = MatrizW;
            }
            if (A.equals("X")) {
                PrimeraMatriz = MatrizX;
            }
            if (A.equals("Y")) {
                PrimeraMatriz = MatrizY;
            }
            if (A.equals("Z")) {
                PrimeraMatriz = MatrizZ;
            }
            I_double(PrimeraMatriz, 'A');

            double[][] R = new double[PrimeraMatriz[0].length][PrimeraMatriz.length];
            for (int i = 0; i < PrimeraMatriz.length; i++) {
                for (int j = 0; j < PrimeraMatriz[i].length; j++) {
                    R[j][i] = PrimeraMatriz[i][j];
                }

            }
            System.out.println("------------------");
            System.out.println("La Transpuesta es:");
            I_double(R, 'R');
            System.out.println("------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Determinante() {
        try {
            System.out.println("Ingrese el nombre de la Matriz (A-Z): ");
            String A = leer.nextLine();
            A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            if (A != null) {
                if (A.equals("A")) {
                    PrimeraMatriz = MatrizA;
                }
                if (A.equals("B")) {
                    PrimeraMatriz = MatrizB;
                }
                if (A.equals("C")) {
                    PrimeraMatriz = MatrizC;
                }
                if (A.equals("D")) {
                    PrimeraMatriz = MatrizD;
                }
                if (A.equals("E")) {
                    PrimeraMatriz = MatrizE;
                }
                if (A.equals("F")) {
                    PrimeraMatriz = MatrizF;
                }
                if (A.equals("G")) {
                    PrimeraMatriz = MatrizG;
                }
                if (A.equals("H")) {
                    PrimeraMatriz = MatrizH;
                }
                if (A.equals("I")) {
                    PrimeraMatriz = MatrizI;
                }
                if (A.equals("J")) {
                    PrimeraMatriz = MatrizJ;
                }
                if (A.equals("K")) {
                    PrimeraMatriz = MatrizK;
                }
                if (A.equals("L")) {
                    PrimeraMatriz = MatrizL;
                }
                if (A.equals("M")) {
                    PrimeraMatriz = MatrizM;
                }
                if (A.equals("N")) {
                    PrimeraMatriz = MatrizN;
                }
                if (A.equals("O")) {
                    PrimeraMatriz = MatrizO;
                }
                if (A.equals("P")) {
                    PrimeraMatriz = MatrizP;
                }
                if (A.equals("Q")) {
                    PrimeraMatriz = MatrizQ;
                }
                if (A.equals("R")) {
                    PrimeraMatriz = R;
                }
                if (A.equals("S")) {
                    PrimeraMatriz = MatrizS;
                }
                if (A.equals("T")) {
                    PrimeraMatriz = MatrizT;
                }
                if (A.equals("U")) {
                    PrimeraMatriz = MatrizU;
                }
                if (A.equals("V")) {
                    PrimeraMatriz = MatrizV;
                }
                if (A.equals("W")) {
                    PrimeraMatriz = MatrizW;
                }
                if (A.equals("X")) {
                    PrimeraMatriz = MatrizX;
                }
                if (A.equals("Y")) {
                    PrimeraMatriz = MatrizY;
                }
                if (A.equals("Z")) {
                    PrimeraMatriz = MatrizZ;
                }
            } else {
                System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
            }
            Mostrarmatriz(PrimeraMatriz);
            int aux = 0;//SE UTILIZA el aux para saber la dimension de la matriz
            for (int i = 0; i < PrimeraMatriz.length; i++) {
                for (int j = 0; j < PrimeraMatriz[i].length; j++) {
                    //System.out.print("|" + matriz[i][j] + "|" + "\t");

                }
                aux++;//se usa el contador para saber que dimension es
            }
            //System.out.println("el aux tiene valor de "+aux);

            if (PrimeraMatriz.length == PrimeraMatriz[0].length) {//si son cuadradas entra para hacer la inversa
                //de lo contrario nel
                if (aux == 2) {
                    Det_orden2(PrimeraMatriz);//llamando metodo de inversa orden 2
                }
                if (aux == 3) {
                    Det_orden3(PrimeraMatriz);//llamando metodo de inversa orden 3
                } else {
                    System.out.println("No es posible resolver la Determinante de la matriz");
                    System.out.println("Solo se puede resolver hasta grado 3 revisar la matriz entrante.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Mostrarmatriz(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" | " + matriz[i][j] + "  | ");

            }
            System.out.println("\t");
        }
    }

    public static void Mostrarmeinversa(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|" + matriz[i][j] + "|" + "\t");
            }
            System.out.println("\t");
        }
    }
}

