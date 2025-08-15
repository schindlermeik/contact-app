package de.meida.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryImpl<T extends Base<ID>, ID> implements Repository<T, ID> {

    private  List<T> entities;
    public  ID nextId ;

    public RepositoryImpl() {
        //entities = new ArrayList<>();
    }

    @Override
    public void create(T entity) {
        if(entity.getId() != null) {
            throw new ConstraintViolationException("Id existiert in der Datenbank " + entity.getId());
        }
       // createAndAdd(entity);
        saveToFile(); //
    }

    @Override
    public Optional<T> findById(ID id) {
        for (T entity : entities) {
            if (entity.getId().equals(id)) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        return List.of();
    }

    @Override
    public T update(T updatedentity) {
        return null;
    }

    @Override
    public void delete(ID id) {

    }

   /* private void createAndAdd(T entity) {
        entity.setId(nextId++);
        entities.add(entity);
    }*/


    private void saveToFile() {

        try (FileWriter writer = new FileWriter("entities.csv")) {
            writer.write("ID\n");
            for (T entity : entities) {
                writer.write(String.format("%s%n", entity.getId()));
            }

        } catch (IOException e) {
            throw new ContactNotSaveException("entity, konnte nicht gespeichert werden", e);
        }
    }
}
