/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.enums;

/**
 *
 * @author HP1
 */
public enum GenStatus {

    ACTIVO(0, "ACTIVO"),
    ASIGNADO(1, "ASIGNADO"),
    PROCESO(2, "PROCESO"),
    TERMINADO(3, "TERMINADO"),
    CANCELADO(4, "CANCELADO");

    private final int tipoStatus;
    private final String titulo;

    GenStatus(int tipoStatus, String titulo) {
        this.tipoStatus = tipoStatus;
        this.titulo = titulo;
    }

    public int getTipoStatus() {
        return tipoStatus;
    }

    public static String getEnum(int tipoStatus) {
        if (ACTIVO.getTipoStatus() == tipoStatus) {
            return ACTIVO.titulo;
        } else if (CANCELADO.getTipoStatus() == tipoStatus) {
            return CANCELADO.titulo;
        } else if (ASIGNADO.getTipoStatus() == tipoStatus) {
            return ASIGNADO.titulo;
        } else if (PROCESO.getTipoStatus() == tipoStatus) {
            return PROCESO.titulo;
        } else if (TERMINADO.getTipoStatus() == tipoStatus) {
            return TERMINADO.titulo;
        }
        throw new IllegalArgumentException("No Enum specified for this string");
    }


    public String getTitulo() {
        return titulo;
    }


}

