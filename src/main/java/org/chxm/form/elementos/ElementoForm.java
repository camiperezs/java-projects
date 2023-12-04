package org.chxm.form.elementos;
import org.chxm.form.validador.LargoValidador;
import org.chxm.form.validador.Validador;
import org.chxm.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {
    protected String valor;
    protected String nombre;
    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }
    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }
    public ElementoForm addValidador(Validador val){
        this.validadores.add(val);
        return this;
    }

    public List<String> getErrores() {
        return errores;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public boolean esValido(){
        for(Validador val : validadores){
            if(!val.esValido(this.valor)){
                if(val instanceof MensajeFormateable){
                    this.errores.add(((MensajeFormateable) val).getMensajeFormateado(nombre));
                } else {
                    this.errores.add(String.format(val.getMensaje(), nombre));
                }
            }
        }
        return this.errores.isEmpty();
    }
    abstract public String dibujarHTML();




}
