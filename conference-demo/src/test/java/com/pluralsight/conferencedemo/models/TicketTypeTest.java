package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.TicketTypeJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TicketTypeTest {

    @Autowired
    TicketTypeJpaRepository repository;

    @Test
    public void testJpaTrue() throws Exception {
        List<TicketType> list = repository.findByIncludesWorkshopTrue();
        assertEquals(1, list.size());
    }

    @Test
    public void testJpaFalse() throws Exception {
        List<TicketType> list = repository.findByIncludesWorkshopFalse();
        assertEquals(2, list.size());
    }
}
