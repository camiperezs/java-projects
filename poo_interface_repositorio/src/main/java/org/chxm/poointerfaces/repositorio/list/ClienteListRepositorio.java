package org.chxm.poointerfaces.repositorio.list;

import org.chxm.poointerfaces.modelo.Cliente;
import org.chxm.poointerfaces.repositorio.AbstractListRepositorio;
import org.chxm.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractListRepositorio<Cliente> {
    @Override
    public void editar(Cliente cl) {
        Cliente c = this.porId(cl.getId());
        c.setNombre(cl.getNombre());
        c.setApellido(cl.getApellido());
    }
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
                int resultado = 0;
                if(dir == Direccion.ASC){
                    resultado = ordenar(campo, a,b);
                } else if(dir == Direccion.DESC){
                    resultado = ordenar(campo, b,a);
                }
                return resultado;
        });
        return listaOrdenada;
    }
    public static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado= a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

}
