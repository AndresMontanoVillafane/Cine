package es.babel.Services.Clases;

public class Butaca {

    public Butaca(){}

    public Butaca(int fila, int asiento) {
        this.fila = fila;
        this.asiento = asiento;
    }
    public Butaca(int fila, int asiento, boolean ocupado) {
        this.fila = fila;
        this.asiento = asiento;
        this.ocupado = ocupado;
    }

    private int fila;
    private int asiento;
    private boolean ocupado;



    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString(){
        return "Butaca [" + fila + ", " + asiento + "]";
    }


}
