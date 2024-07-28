package willianssantos.elibrary.service;

import willianssantos.elibrary.exception.NotFoundException;

import java.util.List;

public interface CrudService <T, U> {
    List<T> findAll();
    T findById(U id) throws NotFoundException;
    T create(T entity);
    T update(U id, T entity);
    void delete(U id);
}
