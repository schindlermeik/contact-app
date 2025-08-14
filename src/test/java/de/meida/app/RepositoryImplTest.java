package de.meida.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryImplTest {

    private RepositoryImpl repository;
    public static final String FileName = "entities.csv";

    @BeforeEach
    void setUp(){
        RepositoryImpl.nextId = 1L;
        repository = new RepositoryImpl();
    }
    @AfterEach
    void tearDown(){
        try {
            Files.deleteIfExists(Path.of(FileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void create_shouldCreateContactWithNewId() {
       // given
       Contact contact = new Contact("Max", " max@service.de", "1234");

       // when
       repository.create(contact);

       // then
        assertEquals(1L, contact.getId());

    }

    @Test
    void create_shouldSaveToFile() {
        // given
        Contact contact = new Contact("Max", " max@service.de", "1234");

        // when
        repository.create(contact);

        //
        File file = new File(FileName);
        assertTrue(file.exists());
    }

    @Test
    void create_shouldThrowExceptionIFIdExists() {
        // given
        Contact contact = new Contact(1L, "Max", " max@service.de", "1234");
        // when, then
        assertThrows(ConstraintViolationException.class,
                () -> repository.create(contact));
    }

    @Test
    void findById() {
    }
}