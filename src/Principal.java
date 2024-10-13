import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultarConversion consulta = new ConsultarConversion();

        while (true) {
            System.out.println("\n*************************************");
            System.out.println("Bienvenido al Conversor de Monedas!");
            System.out.println("""
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Peso Dólar
                7) Salir
                """);
            System.out.println("Elija una opción válida");
            System.out.println("*************************************");
            Scanner lectura = new Scanner(System.in);
            var opcion = Integer.valueOf(lectura.nextLine());
            if (opcion.equals(7)){
                break;
            } if (opcion > 7) {
                System.out.println("La opcion ingresada no es valida");
                break;
            } else {
                try {
                    String segundaMoneda = null;
                    String primerMoneda = null;
                    switch (opcion) {
                        case 1:
                            primerMoneda = "USD";
                            segundaMoneda = "ARS";
                            break;
                        case 2:
                            primerMoneda = "ARS";
                            segundaMoneda = "USD";
                            break;
                        case 3:
                            primerMoneda = "USD";
                            segundaMoneda = "BRL";
                            break;
                        case 4:
                            primerMoneda = "BRL";
                            segundaMoneda = "USD";
                            break;
                        case 5:
                            primerMoneda = "USD";
                            segundaMoneda = "COP";
                            break;
                        case 6:
                            primerMoneda = "COP";
                            segundaMoneda = "USD";
                            break;
                    }
                    System.out.println("Ingrese el valor a convertir");
                    var valorUser = Double.parseDouble(lectura.nextLine());
                    Valor valor = consulta.buscarConversion(primerMoneda, segundaMoneda, valorUser);
                    System.out.println("El valor "+valorUser + " ["+primerMoneda+"] corresponse al valor final de =>>> " + valor + " [" +segundaMoneda + "]");
                } catch (NumberFormatException e) {
                    System.out.println("Número no encontrado " + e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Finalizando la aplicación.");
                }
            }
        }

    }
}
