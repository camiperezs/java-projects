package org.chxm.form.validador;

abstract public class Validador {
    protected String mensaje;
    abstract public void setMensaje(String mensaje);
    abstract public String getMensaje();
    abstract public Boolean esValido(String valor);
}
