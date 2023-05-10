package org.example.abstractRepository;

import org.eclipse.persistence.internal.jpa.EntityManagerFactoryProvider;
import org.example.PersistenceUnitManager;


import javax.persistence.*;
import java.util.List;

public abstract class AbstractRepository<T, ID> {
    protected Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        EntityManager entityManager = PersistenceUnitManager.EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
    }

    public T findById(ID id) {
        EntityManager entityManager = PersistenceUnitManager.EntityManagerFactoryProvider.getEntityManager();
        T entity = entityManager.find(entityClass, id);
        entityManager.close();
        return entity;
    }

    public List<T> findByName(String name) {
        EntityManager entityManager = PersistenceUnitManager.EntityManagerFactoryProvider.getEntityManager();
        Query query = entityManager.createNamedQuery(entityClass.getSimpleName() + ".findByName", entityClass);
        query.setParameter("name", "%" + name + "%");
        List<T> entities = query.getResultList();
        entityManager.close();
        return entities;
    }

    public void update(T entity) {
        EntityManager entityManager = PersistenceUnitManager.EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
        entityManager.close();
    }

    public void delete(ID id) {
        EntityManager entityManager = PersistenceUnitManager.EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T entity = entityManager.find(entityClass, id);
        entityManager.remove(entity);
        transaction.commit();
        entityManager.close();
    }
}
