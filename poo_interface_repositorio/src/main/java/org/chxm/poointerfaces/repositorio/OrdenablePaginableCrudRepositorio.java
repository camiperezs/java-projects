package org.chxm.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRepositorio<T> extends OrdenableRepositorio<T>,
PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {

}
