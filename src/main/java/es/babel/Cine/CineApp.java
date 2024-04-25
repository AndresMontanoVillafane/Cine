package es.babel.Cine;

import es.babel.Services.Clases.Butaca;
import es.babel.Services.Interfaces.IControlDatoConsola;
import es.babel.Services.Interfaces.IDistribucionButacas;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CineApp {

    private final IControlDatoConsola datoConsola;
    private final IDistribucionButacas distribucionButacas;

    public CineApp(IControlDatoConsola datoConsola, IDistribucionButacas distribucionButacas) {
        this.datoConsola = datoConsola;
        this.distribucionButacas = distribucionButacas;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        Butaca[][] cine = distribucionButacas.inicializarCine(9,10);
        switchMenuInicio(scanner, cine);

    }

    private void mostrarMenu(){
        System.out.println("Bienvenido al cine Los Rodriguez");
        System.out.println("----------------------------------");
        System.out.println("Indique la accion que desee:\n" +
                "1 - Ver las butacas vacias\n" +
                "2 - Reservar butacas\n" +
                "3 - Salir");
    }

    private void switchMenuInicio(Scanner scanner, Butaca[][] cine){
        int opcionEscogida;
        do{
            this.mostrarMenu();
            String opcionString = scanner.nextLine();
            opcionEscogida = datoConsola.opcionEscogida(opcionString);
            switch (opcionEscogida){
                case 1:
                    distribucionButacas.imprimirButacas(cine);
                    break;
                case 2:
                    int reserva = seleccionarEspectadores(scanner);
                    distribucionButacas.reservarButacas(cine, reserva);
                    distribucionButacas.imprimirButacas(cine);
                    break;
                case 3:
                    System.out.println("Cerrando Programa");
                    break;
                default:
                    System.out.println("Opcion invalida, escoja una opcion entre las ofrecidas");
                    break;
            }
        } while(opcionEscogida != 3);

    }

    private int seleccionarEspectadores(Scanner scanner){
        System.out.println("Indique cuantos espectadores serán: ");
        String espectadoresString = scanner.nextLine();
        int espectadores = datoConsola.opcionEscogida(espectadoresString);
        return espectadores;
    }
}
