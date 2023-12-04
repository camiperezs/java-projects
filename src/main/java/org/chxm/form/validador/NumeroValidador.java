package org.chxm.form.validador;

public class NumeroValidador extends Validador{
    protected String mensaje = "El campo %s debe ser un número";
    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public Boolean esValido(String valor) {
        try{
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
