package negocio;

import java.util.Scanner;

public class Negocio {
    
    public static void sleep(int time) { //Metodo sleep que retrasa el hilo(thread) de ejecucion en la cantidad de milisegundos que se indique como parámetro de tipo int(time).
        try {// Se implementa una estructura de seguridad( try & catch), en caso que el usuario ingrese un tipo de dato que no corresponda,para evitar la caída del método.
            Thread.sleep(time); // Para este caso  basa en la clase Thread y toma el parametro de milisegundos configurados(time).
        } catch (Exception e) {
        }//En caso de error, este se "captura con la excepción, para este caso la genérica "e").

    }
    
    public static boolean validaInt(String num) { //Este metodo valida que el valor que ingrese el usuario sea un entero.
        try {// Se implementa una estructura de seguridad( try & catch), en caso que el usuario ingrese un tipo de dato que no corresponda,para evitar la caída del método.
            Integer.parseInt(num);// El proceso se hace numero través de un "parseo" o conversion de datos en este caso desde texto(String) numero entero (Int).
        } catch (Exception e) {//En caso de error, este se "captura con la excepción, para este caso la genérica "e").
            return false;
        }// Valor booleano que retorna en caso de error.
        return true;//Valor booleano que retorna en caso que la validación sea exitosa.
    }
    
    public static String solicitaEntero() {
        System.out.println("Ingrese un número: ");//solicitud al usuario que ingrese un valor numerico.
        String Numero; //definine variable tipo String para el primerNumero numero ingresado por el usuario.
        Scanner entrada = new Scanner(System.in);// se llama la clase Scanner para tomar los datos ingresados por el usuario.
        boolean boolIterador = false; // se define variable boolIterador  con valor "false" para controlar la salida del ciclo Do-while que contendrá el menú de opciones en una estructura Switch.
        do {//ciclo Do-While que contiene el desarrollo del programa.
            do {//ciclo Do-While que contiene el procesamiento del primerNumero numero.
                //System.out.println("Introduce un número; ");//solicitud al usuario que ingrese un valor numerico.
                // Numero = entrada.nextLine();//asignación de valor ingresado por el usuario numero la variable "primerNumero".
                if (validaInt(Numero = entrada.nextLine()) == true) {//validación del dato ingresado por usuario si es o no numerico (tipo int).
                    boolIterador = false;
                }// se mantiene el valor false para boolIterador si el valor ingresado es numerico y continua el flujo del progarama.
                else {// si el valor no es numerico se imprime por pantalla el mensaje :"El dato ingresado NO es un numero" y se define boolIterador con valor true para volver al inicio del ciclo Do-While.
                    System.out.println("\n===================================================================================================");
                    System.out.println("                        El dato ingresado NO es un numero válido.");
                    System.out.println("===================================================================================================\n");
                    System.out.println("Ingrese un número: ");
                    boolIterador = true;
                }
            } while (boolIterador);//condición establecida en false para continuar el programa si los datos ingresados pasan las validaciones. 
        } while (boolIterador);
        return Numero;
    }
    
    public static int seguirIntentando(int menu) { //Este método toma la respuesta del usuario si quiere volver al programa para probar otros valores o ir al menú principal.
        boolean seguir = false;// Se define valor booleano para condicionar la salida del ciclo Do-While.
        Scanner entrada = new Scanner(System.in);
        do {//Ciclo Do-While que solicitará valores al usuario mientras se cumpla que el valor booleano establecido (!seguir).
            System.out.println("\n* Presione 1 para realizar otra prueba.");// se le solicita al usuario que ingrese un valor entero sea 1 o 2.       
            System.out.println("* Presione 2 para salir del programa.\n");
            String salida = entrada.nextLine();// Se almacena el valor ingresado por el usuario.
            if (validaInt(salida) == true) {//se valida que el valor ingresado sea entero.
                menu = Integer.parseInt(salida);//Una vez validado se asigna el valor numero la variable menu.
                if (menu == 1 || menu == 2) {//Se reducen las opciones para continuar numero 2 y 1
                    seguir = true;// Sólo continúa si el valor ingresado es 1 o 2.
                } else {//si el valor está fuera de las opciones posibles se imprime pro pantalla el mensaje: "Favor ingrese sólo 1 o 2.".
                    System.out.println("===================================================================================================");
                    System.out.println("                                Favor ingrese sólo 1 o 2. ");
                    System.out.println("===================================================================================================");
                    System.out.println("\nVolvamos a intentar!\n"); //Si el valor ingresado no es un enterose imprime pro pantalla el mensaje :"Volvamos numero intentar!".
                    seguir = false;
                }//si el valor ingresado por el usuario está fuera de las opciones posibles 1 ó 2 se vuelve al comienzo del ciclo.
            } else {
                seguir = false;
            }//si el valor ingresado por el usuario no es un entero, se vuelve al comienzo del ciclo.
        } while (!seguir); //condición establecida para el ciclo Ciclo Do-While.
        return menu;//se retorna al main el valor ingresado por el usuario luego de atravesar  las validaciones.
    }
    
    public static int invertirNumero(int numero, int posicionDigito) {

//        se subdivide el método recursivo en 4 variables, para poder explicar lo que hace cada parte en cada ciclo, 
//        se intenta elegir nombres de variables lo más representativos posible de lo que realizan.
        int modulo = numero % 10;//La variable modulo entrega el residuo o modulo de la división del numero ingresado, al divirlo por 10.
        int largoNumero = String.valueOf(numero).length();//La variable largoNumero entrega el largo del numero ingresado.
        int potencia10 = (int) Math.pow(10, largoNumero - 1);// La variable potencia10 entrega la potencia de 10 por el largo del número ingresado(en cada ciclo) - 1 
        int numeroResultante = modulo * potencia10;//La variavle numero resultante, entrega el resultado de el modulo, multiplicado por la potencia de 10 elevado al largo del número ingresado - 1.

        if (numero == 0) {//Caso base, si el numero resultante es 0,  que lo retorne para salir del ciclo recursivo.
            return numero;//Retorna el ultimo digito cuando el numero resultante sea cero.
        } else {

//            en cada ciclo se intenta explicar lo más detalladamente posible, que realiza cada parte desglosada del método recursivo.
            System.out.println("               El número que ingresa al método en este ciclo es el: " + numero + ".");
            System.out.println("===================================================================================================");
            sleep(2000);
            System.out.println("1.- Se extrae el módulo del número " + numero + " dividido por 10 , y el resultado es el n° " + modulo + ".");
            sleep(1000);
            System.out.println("2.- Se multiplica el módulo, que es el n° " + modulo + " * la potencia de 10^ al largo del número - 1, que es " + (largoNumero - 1) + ".\n");
            sleep(1000);
            System.out.println("3.- El cálculo para este ciclo es: " + modulo + " * (10^" + (largoNumero - 1) + ") = " + (numeroResultante) + ", luego se sumará al resto de los números.");
            System.out.println("===================================================================================================\n");
            sleep(2000);
            System.out.println("                El número resultante de este ciclo es el n° " + (numeroResultante) + ".\n");
            System.out.println("===================================================================================================");
            System.out.println("===================================================================================================");
            sleep(2000);

//            acá se realiza la recursividad, ie; se toma al mismo método mientras se cumpla la condicion del caso base, que el numero sea igual a 0.
            int numeroInvertido = modulo * potencia10 + invertirNumero(numero / 10, posicionDigito - 1);
            System.out.println("La suma n°" + (posicionDigito + 1) + " del método recursivo da el número: " + numeroInvertido);
            return numeroInvertido;//se retorna el numero invertido

        }
    }
}
