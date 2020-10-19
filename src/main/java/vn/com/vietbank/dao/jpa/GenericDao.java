package vn.com.vietbank.dao.jpa;

import vn.com.vietbank.exception.ObjectNotFoundException;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
    void create(T object);

    T read(ID id) throws ObjectNotFoundException;

    T update(T object);
}
