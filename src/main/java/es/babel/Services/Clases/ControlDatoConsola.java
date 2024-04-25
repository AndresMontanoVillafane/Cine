package es.babel.Services.Clases;

import es.babel.Services.Interfaces.IControlDatoConsola;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ControlDatoConsola implements IControlDatoConsola {

    @Override
    public int opcionEscogida(String datoInsertado) {
        int opcion = 0;
        boolean formatoCorrecto = false;
        while (!formatoCorrecto){
            try{
                opcion = Integer.parseInt(datoInsertado);
                formatoCorrecto = true;
            }catch (Exception e){
                System.out.println("Dato incorrecto. Por favor, ingrese un numero entre las opciones");
            }
        }
        return opcion;
    }

}
