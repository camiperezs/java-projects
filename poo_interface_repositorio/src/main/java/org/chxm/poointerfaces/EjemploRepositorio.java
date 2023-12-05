package org.chxm.poointerfaces;

import org.chxm.poointerfaces.modelo.Cliente;
import org.chxm.poointerfaces.repositorio.*;
import org.chxm.poointerfaces.repositorio.list.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Perez"));
        repo.crear(new Cliente("Bea", "Gonzalez"));
        repo.crear(new Cliente("Luci", "Martinez"));
        repo.crear(new Cliente("Camila", "Perez"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("-------------- paginable --------------");
        List<Cliente> paginable = repo.listar(1,3);
        paginable.forEach(System.out::println);
        System.out.println("-------------- ordenar --------------");
        List<Cliente> clienteOrdenAsc = repo
                .listar("apellido", Direccion.DESC);
        for(Cliente cl: clienteOrdenAsc){
            System.out.println(cl);
        }
        System.out.println("-------------- editar --------------");
        Cliente clienteActualizar = new Cliente("Bea", "Mena");
        clienteActualizar.setId(2);
        repo.editar(clienteActualizar);
        Cliente bea = repo.porId(2);
        repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
        System.out.println("-------------- borrar --------------");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
        System.out.println("-------------- total --------------");
        System.out.println("Total registros: " + repo.total());
    }
}
