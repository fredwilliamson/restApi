package com.fme.dao;

import com.fme.exception.RestApiRunTimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class AbstractDao<T> {

    public static final String MSG_ERROR_OBJ_NOT_NULL = "object ne peut pas être null";
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @PersistenceContext
    protected EntityManager entityManager;


    public List<T> findAll(){
        final CriteriaQuery<T> query =buildCriteriaQuery();
        return entityManager.createQuery(query).getResultList();
    }

    public T findUniqueById(Long id) {
        Assert.notNull(id,"identifiant ne peut pas être null");
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query =(CriteriaQuery<T>)cb.createQuery(getParameterClass());
        final Root root = query.from(getParameterClass());
        query.where(cb.equal(root.get("id"),id));
        return  entityManager.createQuery(query).getSingleResult();
    }

    public void insert(T object) {
        Assert.notNull(object, MSG_ERROR_OBJ_NOT_NULL);
        this.entityManager.persist(object);
        this.entityManager.flush();
    }

    public T update(T object){
        Assert.notNull(object,MSG_ERROR_OBJ_NOT_NULL);
        return this.entityManager.merge(object);
    }

    public void delete(T object){
        Assert.notNull(object,MSG_ERROR_OBJ_NOT_NULL);
        this.entityManager.remove(object);
        this.entityManager.flush();
    }

    private CriteriaQuery<T> buildCriteriaQuery(){
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        return (CriteriaQuery<T>) cb.createQuery(getParameterClass());
    }

    private Class<?> getParameterClass(){
        try {
            return Class.forName(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName());
        } catch (ClassNotFoundException e) {
            throw new RestApiRunTimeException("erreur dans la construction de la classe parametre",e);
        }
    }

}
