package com.epam.jamp.service.person;

import com.epam.jamp.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {

    void write(Person person) throws Exception;

    List<Person> readAll() throws Exception;

    List<Person> read(String name) throws Exception;

    void rewrite(Person person) throws Exception;
}
