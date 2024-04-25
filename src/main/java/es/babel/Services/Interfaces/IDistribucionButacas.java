package es.babel.Services.Interfaces;

import es.babel.Services.Clases.Butaca;

public interface IDistribucionButacas {

    Butaca[][] inicializarCine(int filas, int columnas);

    void imprimirButacas(Butaca[][] salaButacas);

    void reservarButacas(Butaca[][] cine, int reservas);
}
