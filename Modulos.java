import java.util.Scanner;
import java.util.Random;

public class Modulos {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    calculadora();
                    break;
                case 2:
                    validarContrasena();
                    break;
                case 3:
                    numeroPrimo();
                    break;
                case 4:
                    sumaNumerosPares();
                    break;
                case 5:
                    conversionTemperatura();
                    break;
                case 6:
                    contadorVocales();
                    break;
                case 7:
                    factorial();
                    break;
                case 8:
                    juegoAdivinanza();
                    break;
                case 9:
                    pasoPorReferencia();
                    break;
                case 10:
                    tablaMultiplicar();
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Calculadora básica");
        System.out.println("2. Validación de contraseña");
        System.out.println("3. Número primo");
        System.out.println("4. Suma de números pares");
        System.out.println("5. Conversión de temperatura");
        System.out.println("6. Contador de vocales");
        System.out.println("7. Cálculo de factorial");
        System.out.println("8. Juego de adivinanza");
        System.out.println("9. Paso por referencia");
        System.out.println("10. Tabla de multiplicar");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    static int leerEntero() {
        int num = 0;
        boolean valido = false;

        while (!valido) {
            try {
                num = sc.nextInt();
                valido = true;
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
        }
        return num;
    }

    // Este metodo cumple como calculadora 
    static void calculadora() {
        System.out.print("Ingrese primer número: ");
        double a = leerDouble();
        System.out.print("Ingrese segundo número: ");
        double b = leerDouble();

        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.print("Seleccione: ");

        int op = leerEntero();

        switch (op) {
            case 1:
                System.out.println("Resultado: " + (a + b));
                break;
          case 2:
                System.out.println("Resultado: " + (a - b));
                break;
            case 3:
                System.out.println("Resultado: " + (a * b));
                break;
           case 4:
                if (b != 0) {
                    System.out.println("Resultado: " + (a / b));
                } else {
                    System.out.println("No se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    static double leerDouble() {
            double num = 0;
        boolean valido = false;

      while (!valido) {
            try {
                num = sc.nextDouble();
                valido = true;
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
        }
        return num;
    }

  // ESTE METODO ME PREMITE VALIDAR LA CONTRASEÑA
    static void validarContrasena() {
        String clave;
        sc.nextLine();
        do {
            System.out.print("Ingrese contraseña: ");
            clave = sc.nextLine();
        } while (!clave.equals("JERY3714"));

        System.out.println("Acceso concedido.");
    }

       // ESTE METODO LO USE PARA SABER SI UN NUMERO ES PRIMO O NO
    static void numeroPrimo() {
        System.out.print("Ingrese un número: ");
      int n = leerEntero();

        if (esPrimo(n)) {
              System.out.println("Es primo.");
        } else {
            System.out.println("No es primo.");
        }
    }

    static boolean esPrimo(int n) {
     if (n <= 1) return false;
          for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

  // CON ESTE METODO PUEDO SUMAR CUANDO INGRESO NUMEROS PARES Y LOS QUE SON IMPARES NO ME LOS SUMA
        static void sumaNumerosPares() {
      int suma = 0;
        int num;

     do {
              System.out.print("Ingrese un número (0 para terminar): ");
            num = leerEntero();
             if (num % 2 == 0) {
                suma += num;
            }
        } while (num != 0);

        System.out.println("Suma de pares: " + suma);
    }

             // AQUI PUEDO CONVERTIR DE CELSIUS A FAHRENHEIT Y AL REVES
    static void conversionTemperatura() {
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        System.out.print("Seleccione: ");
        int op = leerEntero();

        System.out.print("Ingrese temperatura: ");
        double t = leerDouble();

        if (op == 1) {
            System.out.println("Resultado: " + (t * 9 / 5 + 32));
        } else if (op == 2) {
            System.out.println("Resultado: " + ((t - 32) * 5 / 9));
        } else {
            System.out.println("Opción inválida.");
           }
     }

 // ESTE METODO LO QUE HACE ES CONTAR CUANTAS VOLCALES HAY AL INGRESSAR UN TEXTO
    static void contadorVocales() {
          sc.nextLine();
        System.out.print("Ingrese texto: ");
      String texto = sc.nextLine();
        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }

        System.out.println("Vocales: " + contador);
    }

       // ESTA FUNCION LO QUE HACE ES CALCULAR EL FACTORIAL
    static void factorial() {
        System.out.print("Ingrese número: ");
        int n = leerEntero();

        if (n < 0) {
            System.out.println("No se permite negativo.");
            return;
        }

           long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }

        System.out.println("Factorial: " + f);
    }

  // AQUI EN ESTE METODO PUEDO ADIVINAR UN NUMERO ENTRE 1 Y 100 Y ME DICE SI ES MAYOR O MENOR
    static void juegoAdivinanza() {
           Random r = new Random();
        int secreto = r.nextInt(100) + 1;
          int intento;

        do {
            System.out.print("Adivine el número: ");
            intento = leerEntero();

               if (intento < secreto) {
                System.out.println("Mayor");
             } else if (intento > secreto) {
                  System.out.println("Menor");
            }

        } while (intento != secreto);

        System.out.println("Correcto!");
    }

                // CON ESTE METODO PUEDO INTERCAMBIAR LOS VALORES DE LAS VARIABLES A Y B
    static class Par {
        int a;
        int b;
    }

    static void pasoPorReferencia() {
        Par p = new Par();

         System.out.print("Ingrese A: ");
        p.a = leerEntero();
        System.out.print("Ingrese B: ");
           p.b = leerEntero();

          System.out.println("Antes: A=" + p.a + " B=" + p.b);
           intercambiar(p);
        System.out.println("Después: A=" + p.a + " B=" + p.b);
    }

    static void intercambiar(Par p) {
        int temp = p.a;
        p.a = p.b;
        p.b = temp;
    }

    // AQUIE EN ESTE METODO PUEDO IMPRIMIR LA TABLA DE MULTIPLICAR DE UN NUMERO QUE YO INGRESE
    static void tablaMultiplicar() {
        System.out.print("Ingrese número: ");
        int n = leerEntero();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

}
