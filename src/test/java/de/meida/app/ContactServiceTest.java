package de.meida.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @InjectMocks
    private ContactService sut;

    @Mock
    private Repository<Contact, Long> repository;

    @Test
    void createContact_shouldCreateNewContact() {
        //given
        Contact contact = new Contact("Max", "max@email.de", "1234");
        //when
        doNothing().when(repository).create(contact);
        sut.createContact(contact);
        //then
        verify(repository, times(1)).create(contact);

    }

    @Test
    void createContact_shouldThrowsConstraintViolationException() {
        //given
        Contact contact = new Contact(1L,"Max", "max@email.de", "1234");
        //when
        doThrow(ConstraintViolationException.class).when(repository).create(contact);
        //then
        assertThrows(ConstraintViolationException.class, () -> sut.createContact(contact));
        verify(repository).create(contact);

    }

    @Test
    void getById() {
        //given
        Long id = 1L;
        Contact contactToFind = new Contact(1L, "Max", null, "1234");
        // when
        when(repository.findById(1L)).thenReturn(contactToFind);
        Contact result = sut.getById(id);
        // then
        assertEquals(contactToFind.getName(), result.getName());
        verify(repository, times(2)).findById(id);
    }
}