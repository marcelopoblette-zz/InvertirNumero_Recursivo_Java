package presentación;

import negocio.Negocio;

public class Presentación {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("                            Programa que invierte un número ingresado.");
        System.out.println("===================================================================================================");
        Negocio.sleep(2000);
        System.out.println("\n                  El programa solo acepta ingresar números de 2 dígitos o más.");
        Negocio.sleep(2000);
        System.out.println("                            El programa no admite números negativos.\n");
        System.out.println("===================================================================================================");
        Negocio.sleep(2000);
        boolean boolIterador = false;//Se define iterador en false para volver al programa
        int eleccionUsuario = 0;//se define variable para terminar el programa o hacer otra prueba
        boolean menu = false;//Se define iterador en false  salir del programa
        int salida = 0;//se inicializa valor de salida en cero
        do {//ciclo do while para ejecutar la salida del programa u otra prueba
            do {//ciclo do while para ejecutar el programa mientras no haya error
                int numero = Integer.parseInt(Negocio.solicitaEntero()); //se valida que el ingreso sea un número,se convierte a int y se asigna a la variable numero
                if (numero >= 10) {//se condiciona el ingreso de numeros mayor o igual a cero
                    System.out.println("===================================================================================================");
                    System.out.println("                            El número original es: " + numero + ".");//Se muestra resultado por pantalla
                    System.out.println("===================================================================================================");
                    int largoNumero = String.valueOf(numero).length();//Se establece variable para indicar la cantidad de digitos del numero ingresado por teclado
                    int numeroinvertido = Negocio.invertirNumero(numero, largoNumero - 1); //se asigna el valor del numero invertido desde la funcion
                    System.out.println("===================================================================================================\n");
                    System.out.println("            El número ingresado originalmente por el usuario fue el: " + numero + ".\n");//Se muestra resultado por pantalla
                    System.out.println("===================================================================================================\n");
                    System.out.println("La suma de todos los ciclos recursivos, nos da como resultado el número invertido: " + numeroinvertido + ".\n");//Se muestra resultado por pantalla
                    System.out.println("===================================================================================================");
                    boolIterador = false;
                } else {
                    System.out.println("===================================================================================================");
                    System.out.println("El número ingresado, no es un número positivo de dos dígitos o más.");//mensaje en caso de error
                    System.out.println("===================================================================================================");
                    boolIterador = false;
                }
            } while (boolIterador);
            eleccionUsuario = Negocio.seguirIntentando(salida); // hago la llamada al procedimiento seguirIntentando
            if (eleccionUsuario == 1) { //aca consulto si es igual a 1 para seguir en el programa
                menu = true;
            } else { //sino sale al menú principal
                System.out.println("Gracias por su evaluación! \n");
                Negocio.sleep(1000);
                menu = false;
            }
        } while (menu != false);//condición establecida en false para continuar el programa o detenerlo.

    }
}
