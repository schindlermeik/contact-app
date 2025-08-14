package de.meida.app;

import java.util.List;

public interface Repository<T extends Base<ID>, ID> {

    void create(T value);

    T findById(ID id);

    List<T> findAll();

    T update(T updatedValue);

    void delete(ID id);

}
