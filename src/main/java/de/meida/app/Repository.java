package de.meida.app;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Base<ID>, ID> {

    void create(T value);


    Optional<T> findById(ID id);

    List<T> findAll();

    T update(T updatedValue);

    void delete(ID id);

}
