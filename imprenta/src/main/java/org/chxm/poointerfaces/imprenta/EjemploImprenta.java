package org.chxm.poointerfaces.imprenta;

import org.chxm.poointerfaces.imprenta.modelo.*;
import static org.chxm.poointerfaces.imprenta.modelo.Genero.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum(new Persona("Camila", "Perez"), "Programacion", "Resumen Laboral...");
        cv.addExperiencias("Java")
                .addExperiencias("Spring")
                .addExperiencias("CSS")
                .addExperiencias("HTML")
                .addExperiencias("JavaScript");
        Libro libro = new Libro(new Persona("Erich", "Gamma"),
                "Patrones de Diseños: Elem. reusables POO",
                PROGRAMACION );
        libro.addPaginas(new Pagina("Patron Singleton"))
                .addPaginas(new Pagina("Patron Observador"))
                .addPaginas(new Pagina("Patron Factory"))
                .addPaginas(new Pagina("Patron Composite"))
                .addPaginas(new Pagina("Patron Facade"));

        Informe informe = new Informe(new Persona("Martin", "Fowler"),
                new Persona("James", "Gosling"),
                "Estudio sobre microservicios");
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
    }
    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
