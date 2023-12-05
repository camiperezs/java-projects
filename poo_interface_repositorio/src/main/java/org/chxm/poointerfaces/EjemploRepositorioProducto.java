package org.chxm.poointerfaces;
import org.chxm.poointerfaces.modelo.Producto;
import org.chxm.poointerfaces.repositorio.Direccion;
import org.chxm.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.chxm.poointerfaces.repositorio.list.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("Mesa", 15.2));
        repo.crear(new Producto("Silla", 8.5));
        repo.crear(new Producto("Cama", 24.3));
        repo.crear(new Producto("Ropero", 12.6));

        List<Producto> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("-------------- paginable --------------");
        List<Producto> paginable = repo.listar(1,3);
        paginable.forEach(System.out::println);
        System.out.println("-------------- ordenar --------------");
        List<Producto> productoOrdenAsc = repo
                .listar("descripcion", Direccion.DESC);
        for(Producto pr: productoOrdenAsc){
            System.out.println(pr);
        }
        System.out.println("-------------- editar --------------");
        Producto productoActualizar = new Producto("Mesa desplegable", 24.5);
        productoActualizar.setId(1);
        repo.editar(productoActualizar);
        Producto mesa = repo.porId(1);
        System.out.println(mesa);
        System.out.println("--------------------");
        repo.listar("descripcion", Direccion.ASC).forEach(System.out::println);
        System.out.println("-------------- borrar --------------");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
        System.out.println("-------------- total --------------");
        System.out.println("Total registros: " + repo.total());
    }
}
