package vn.com.vietbank.dao.jpa;

import org.springframework.transaction.annotation.Transactional;
import vn.com.vietbank.exception.ObjectNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class JpaGenericDao<T, ID extends Serializable> implements GenericDao<T, ID> {

    private Class<T> persistenceClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public JpaGenericDao(Class persistenceClass) {
        this.persistenceClass = persistenceClass;
    }

    public JpaGenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        persistenceClass = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public void create(T object) {
        entityManager.persist(object);
    }

    @Override
    @Transactional
    public T read(ID id) throws ObjectNotFoundException {
        T entity = entityManager.find(persistenceClass, id);
        if (entity == null) {
            throw new ObjectNotFoundException("Object could not be found: " + id);
        }

        return entity;
    }

    @Override
    @Transactional
    public T update(T object) {
        return entityManager.merge(object);
    }
}
