package es.babel.Services.Clases;

import es.babel.Services.Interfaces.IDistribucionButacas;
import org.springframework.stereotype.Service;

@Service
public class DistribucionButacas implements IDistribucionButacas {

    @Override
    public Butaca[][] inicializarCine(int filas, int columnas) {

        Butaca[][] cine = new Butaca[filas][columnas];
        int puntoMedioColumnasTotales = columnas / 2;
        inicializarButacas(filas, columnas, puntoMedioColumnasTotales, cine);
        centrarButacas(filas, columnas, cine);
        return cine;
    }

    private void centrarButacas(int filas, int columnas, Butaca[][] salaCine) {
        int numeroButacaCentral = 1;
        int filaCentral = filas / 2;
        salaCine[filaCentral][columnas / 2 - 1] = new Butaca(filaCentral + 1, numeroButacaCentral++);
        salaCine[filaCentral][columnas / 2] = new Butaca(filaCentral + 1, numeroButacaCentral++);
    }

    private void inicializarButacas(int filas, int columnas, int puntoMedioColumnas, Butaca[][] cine) {
        for (int fila = 0; fila < filas; fila++) {
            // Coloca los asientos impares a la izquierda
            int numeroButacaImpar = 1;
            int butacaImparInicial = puntoMedioColumnas - 1; // Ajuste para centrar el primer asiento impar
            int butaca = butacaImparInicial;
            while (numeroButacaImpar <= columnas) {
                cine[fila][butaca] = new Butaca(fila + 1, numeroButacaImpar);
                numeroButacaImpar += 2;
                butaca--;
                if (butaca < 0) break;
            }

            // Coloca los asientos pares a la derecha
            int numeroButacaPar = 2;
            int butacaParInicial = puntoMedioColumnas;
            for (butaca = butacaParInicial; butaca < columnas; butaca++) {
                cine[fila][butaca] = new Butaca(fila + 1, numeroButacaPar);
                numeroButacaPar += 2;
            }
        }
    }

    @Override
    public void imprimirButacas(Butaca[][] cine) {
        System.out.println("Disposición de las butacas en el cine:");
        System.out.println("----------------------------------------");
        for (Butaca[] cinema : cine) {
            for (int butaca = 0; butaca < cine[0].length; butaca++) {
                if (cinema[butaca] != null) {
                    System.out.print("[" + cinema[butaca].getFila() + "-" + cinema[butaca].getAsiento() + "]");
                } else {
                    System.out.print("[X-X]");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void reservarButacas(Butaca[][] cine, int espectadores) {
        int butacasReservadas = 0;
        int fila = 0;
        int columnaCentraldeFila = cine[0].length / 2;
        butacasReservadas = reservaDeButacas(cine, espectadores, butacasReservadas, fila, columnaCentraldeFila);

        if (butacasReservadas < espectadores) {
            System.out.println("No hay suficientes butacas disponibles");
        }
    }

    private int reservaDeButacas(Butaca[][] cine, int espectadores, int butacasReservadas, int fila, int columnaCentral) {
        while (butacasReservadas < espectadores && fila < cine.length) {
            int butacasDisponiblesEnFila = 0;
            for (int i = 0; i < cine[0].length; i++) {
                if (cine[fila][i] != null) {
                    butacasDisponiblesEnFila++;
                }
            }
            if (butacasDisponiblesEnFila >= espectadores - butacasReservadas) {
                for (int i = 0; i <= columnaCentral && butacasReservadas < espectadores; i++) {
                    if (cine[fila][columnaCentral - i] != null) {
                        System.out.println("se ha reservado la silla [" + cine[fila][columnaCentral -i] + "]");
                        System.out.println(columnaCentral -i);
                        cine[fila][columnaCentral - i] = null;
                        butacasReservadas++;
                    }
                    if (butacasReservadas < espectadores && cine[fila][columnaCentral + i] != null) {
                        System.out.println("se ha reservado la silla [" + cine[fila][columnaCentral +i] + "]");
                        cine[fila][columnaCentral + i] = null;
                        butacasReservadas++;
                    }
                }
            }
            fila++;
        }
        return butacasReservadas;
    }
}
