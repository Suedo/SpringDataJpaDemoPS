package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.SessionJpaRepository;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;

    @Autowired
    SessionJpaRepository jpaRepository;

    @Test
    public void test() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaIs() throws Exception {
        List<Session> list = jpaRepository.findBySessionLengthIs(30);
        assertEquals(28, list.size());
    }

    @Test
    public void testJpaNot() throws Exception {
        List<Session> list = jpaRepository.findBySessionLengthNot(30);
        assertEquals(43, list.size());
    }

    @Test
    public void testJpaLike() throws Exception {
        // names that start with "Spring"
        List<Session> list = jpaRepository.findBySessionNameLike("Spring%");
        assertEquals(3, list.size());
    }

    @Test
    public void testJpaNotLike() throws Exception {
        // names that do not start with "Spring"
        List<Session> list = jpaRepository.findBySessionNameNotLike("S%");
        assertEquals(63, list.size());
    }
}
