package org.chxm.poointerfaces.repositorio.list;

import org.chxm.poointerfaces.modelo.Cliente;
import org.chxm.poointerfaces.modelo.Producto;
import org.chxm.poointerfaces.repositorio.AbstractListRepositorio;
import org.chxm.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) {
        Producto pr = porId(producto.getId());
        pr.setDescripcion(producto.getDescripcion());
        pr.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
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
    public static int ordenar(String campo, Producto a, Producto b){
        int resultado = 0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "descripcion" ->
                    resultado= a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" ->
                    resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
