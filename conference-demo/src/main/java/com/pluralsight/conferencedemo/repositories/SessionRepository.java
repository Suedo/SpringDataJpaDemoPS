package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// Using a JpaRepository as a Proxy inside the existing repository
// neat way to update existing codebase to use the newer JpaRepository
@Repository
public class SessionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    SessionJpaRepository repository;

    public Session create(Session session) {
        return repository.saveAndFlush(session);
    }

    public Session update(Session session) {
        return repository.save(session);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Session find(Long id) {
        return repository.getOne(id);
    }

    public List<Session> list() {
        return repository.findAll();
    }

    public List<Session> getSessionsThatHaveName(String name) {
        List<Session> ses = entityManager
                .createQuery("select s from Session s where s.sessionName like :name")
                .setParameter("name", "%" + name + "%").getResultList();
        return ses;
    }
}
