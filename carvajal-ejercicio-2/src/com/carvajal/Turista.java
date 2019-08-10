package com.carvajal;

import com.carvajal.excepciones.ErrorValidacion;

public class Turista {
    public String nombre;
    public String telefono;
    public int numeroVisitas = 0;

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    public void setNombre(String nombre) throws ErrorValidacion {

        if(nombre.length() > 50) {
            throw new ErrorValidacion("El nombre no debe contener mas de 50 caracteres");
        }
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) throws ErrorValidacion {
        if(!telefono.matches("^[0-9]{4}\\-[0-9]{4}")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }

    public void setNumeroVisitas(int numeroVisitas){
        this.numeroVisitas = numeroVisitas + this.numeroVisitas;
    }
}
