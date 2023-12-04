package org.chxm.form;
import org.chxm.form.elementos.*;
import org.chxm.form.elementos.select.Opcion;
import org.chxm.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {
        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave" , "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad= new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());
        username.setValor("");
        password.setValor("");
        email.setValor("");
        edad.setValor("");

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);
        experiencia.setValor("... más de 10 años de experiencia ...");

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addOpcion(new Opcion("1", "java"))
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));
        lenguaje.addValidador(new NoNuloValidador());

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHTML() {
                return "<input disabled name='>" + this.nombre+"' value=\""+this.valor+"\">";
            }
        };
        saludar.setValor("Hola que tal, este campo está deshabilitado!");


        List<ElementoForm> elementos = Arrays.asList(username,
                password,
                edad,
                experiencia,
                lenguaje,
                saludar);
        elementos.forEach(e ->{
            System.out.println(e.dibujarHTML());
            System.out.println("<br>");
        });
        elementos.forEach(e ->{
            if(!e.esValido()) {
                e.getErrores().forEach(System.out::println);
            }
        });
    }
}
