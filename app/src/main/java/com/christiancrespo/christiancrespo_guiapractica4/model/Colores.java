package com.christiancrespo.christiancrespo_guiapractica4.model;

public class Colores {
    private String nombreColor;
    private String valorHexadec;

    public Colores() {
    }

    public Colores(String nombreColor, String valorHexadec) {
        this.nombreColor = nombreColor;
        this.valorHexadec = valorHexadec;
    }

    public String getNombreColor() {
        return nombreColor;
    }

    public void setNombreColor(String nombreColor) {
        this.nombreColor = nombreColor;
    }

    public String getValorHexadec() {
        return valorHexadec;
    }

    public void setValorHexadec(String valorHexadec) {
        this.valorHexadec = valorHexadec;
    }
}
