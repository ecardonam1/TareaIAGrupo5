/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class clsModel {
    private String nombre;
    private boolean labora;
    private String ingreso;
    private boolean credito;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the labora
     */
    public boolean isLabora() {
        return labora;
    }

    /**
     * @param labora the labora to set
     */
    public void setLabora(boolean labora) {
        this.labora = labora;
    }

    /**
     * @return the ingreso
     */
    public String getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return the credito
     */
    public boolean isCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(boolean credito) {
        this.credito = credito;
    }
}
