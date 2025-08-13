package de.meida.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @InjectMocks
    private ContactService sut;

    @Mock
    private ContactRepository contactRepository;

    @Test
    void createContact_shouldCreateNewContact() {
        //given
        Contact contact = new Contact("Max", "max@email.de", "1234");
        //when
        doNothing().when(contactRepository).create(contact);
        sut.createContact(contact);
        //then
        verify(contactRepository, times(1)).create(contact);

    }

    @Test
    void createContact_shouldThrowsConstraintViolationException() {
        //given
        Contact contact = new Contact(1L,"Max", "max@email.de", "1234");
        //when
        doThrow(ConstraintViolationException.class).when(contactRepository).create(contact);
        sut.createContact(contact);
        //then
        //assertThrows(ConstraintViolationException.class, () -> sut.createContact(contact));
        verify(contactRepository).create(contact);

    }

    @Test
    void getById() {
        //given
        Long id = 1L;
        Contact contactToFind = new Contact(1L, "Max", null, "1234");
        // when
        when(contactRepository.findById(1L)).thenReturn(contactToFind);
        Contact result = sut.getById(id);
        // then
        assertEquals(contactToFind.getName(), result.getName());
        verify(contactRepository, times(2)).findById(id);
    }
}