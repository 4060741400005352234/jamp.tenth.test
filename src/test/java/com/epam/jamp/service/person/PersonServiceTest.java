package com.epam.jamp.service.person;

import com.epam.jamp.db.PersonDao;
import com.epam.jamp.model.Person;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    private Person petr;
    private Person pavel;

    @Mock
    private PersonDao storage;

    @InjectMocks
    PersonService service = new DBPersonService();

    @Before
    public void initTest() {
        petr = new Person("Petr", "Pavlov", 25, 50);
        pavel = new Person("Pavel", "Ivanov", 25, 50);
    }

    @Test
    public void readShouldReturnListOfPersonsWithSpecifiedName() throws Exception {
        String personName = "Petr";
        List<Person> persons = Arrays.asList(petr);

        when(storage.find(personName)).thenReturn(persons);

        List<Person> result = service.read(personName);

        assertThat(result.get(0).getFirstName(), is(equalTo(petr.getFirstName())));
        assertThat(result.get(0).getSecondName(), is(equalTo(petr.getSecondName())));
    }

    @Test(expected = RuntimeException.class)
    public void writeShouldThrowRExceptionForNullPerson() throws Exception {
        service.write(null);
    }

    @Test(expected = Exception.class)
    public void writeShouldThrowExceptionWhenDbProblemOccurs() throws Exception {
        doThrow(SQLException.class).when(storage).save(pavel);

        service.write(pavel);
    }

    @Test
    public void writeShouldNotTrowRExceptionForPerson() throws Exception {
        doNothing().when(storage).save(petr);

        service.write(petr);
    }

    @Test
    public void readAllShouldReturnListOfPersons() throws Exception {
        List<Person> persons = Arrays.asList(petr, pavel);

        doReturn(persons).when(storage).getAll();

        List<Person> result = service.readAll();

        assertNotNull(result);
    }

    @Test(expected = RuntimeException.class)
    public void readShouldTrowRExceptionForNullString() throws Exception {
        service.read(null);
    }

    @Test(expected = RuntimeException.class)
    public void readShouldThrowRExceptionForEmptyString() throws Exception {
        service.read("");
    }

    @Test(expected = RuntimeException.class)
    public void rewriteShouldThrowRExceptionForNullPerson() throws Exception {
        service.rewrite(null);
    }

    @Test
    public void readShouldReturnEmptyListIfNothingFound() throws Exception {
        String personName = "Petr";
        when(storage.find(personName)).thenReturn(new ArrayList<Person>());

        List<Person> result = service.read(personName);
        assertThat(result, is(empty()));
    }

    @Test
    public void readAllShouldReturnEmptyListIfNothingFound() throws Exception {
        when(storage.getAll()).thenReturn(new ArrayList<Person>());

        List<Person> result = service.readAll();
        assertThat(result, is(empty()));
    }
}
