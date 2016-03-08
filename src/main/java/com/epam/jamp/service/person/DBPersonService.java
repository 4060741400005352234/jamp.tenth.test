package com.epam.jamp.service.person;

import com.epam.jamp.db.PersonDao;
import com.epam.jamp.model.Person;
import org.apache.log4j.Logger;

import java.util.List;

public class DBPersonService implements PersonService {

    private static Logger log = Logger.getLogger(DBPersonService.class);

    private PersonDao storage = new PersonDao();

    public void write(Person person) throws Exception {
        if (person == null) {
            throw new RuntimeException("Incorrect parameter.");
        }
        try {
            storage.save(person);
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

    public List<Person> readAll() throws Exception {
        List<Person> persons = null;
        try {
            persons = storage.getAll();
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
        return persons;
    }

    public List<Person> read(String name) throws Exception {
        if (name == null || name.length() == 0) {
            throw new RuntimeException("Incorrect parameter.");
        }
        List<Person> persons = null;
        try {
            persons = storage.find(name);
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
        return persons;
    }

    public void rewrite(Person person) throws Exception {
        if (person == null) {
            throw new RuntimeException("Incorrect parameter.");
        }
        try {
            storage.update(person);
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }
}
