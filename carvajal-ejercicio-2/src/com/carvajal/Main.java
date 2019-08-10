package com.carvajal;

import com.carvajal.excepciones.ErrorValidacion;

import java.util.ArrayList;

public class Main {
    static ArrayList<Turista> turistas = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;
        while(continuar) {
            System.out.print("*****CANATURH*****\n" +
                    "\t1. Crear una visita\n" +
                    "\t2. Mostrar registro de visitas\n" +
                    "\t3. Salir\n");
            int opcion = lectorDeDatos.solicitarEntero("Ingrese una opcion: ");

            switch(opcion){
                case 1:
                    int contaVisitas = 1;
                    int regresar = 0;
                    System.out.println("*********CREACION DE VISITA**********\n");
                    String nombre = lectorDeDatos.solicitarString("Ingrese el nombre del turista: ");
                    String telefono = lectorDeDatos.solicitarString("Ingrese el numero de telefono: ");

                    Turista nuevoTurista = new Turista();
                    try{
                        nuevoTurista.setNombre(nombre);
                        nuevoTurista.setTelefono(telefono);
                    } catch (ErrorValidacion e){
                        System.out.println(e.getMessage());
                    }
                    nuevoTurista.setNumeroVisitas(contaVisitas);

                    int indice = -1;
                    int conta =0;

                    if(!turistas.isEmpty()) {
                        for(Turista t: turistas) {
                            if(t.getTelefono().equals(telefono)) {
                                System.out.println("El numero de telefono ya ha sido ingresado");
                                indice = conta;
                            }
                            conta++;
                        }
                    }
                    if(indice != -1){
                        turistas.get(indice).setNumeroVisitas(contaVisitas);
                    } else {
                        if(nuevoTurista.getTelefono() != null && nuevoTurista.getNombre() != null){
                            turistas.add(nuevoTurista);
                            System.out.println("El turista ha sido registrado!");
                        } else {
                            System.out.println("Ingrese los parametros de forma correcta");
                        }
                    }
                    break;
                case 2:
                    if(turistas.isEmpty()){
                        System.out.println("No existen turistas ingresados");
                    } else {
                        int contador = 1;
                        for (Turista t: turistas) {
                            System.out.println("\nTurista: " + contador);
                            System.out.println("Nombre: " + t.getNombre());
                            System.out.println("Telefono: " + t.getTelefono());
                            System.out.println("Cantidad de visitas: " + t.getNumeroVisitas());
                            contador++;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Hasta pronto");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
    }
}

