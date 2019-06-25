package com.stevenprogramming.liquibase.services.impl;

import com.stevenprogramming.liquibase.model.BasicEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
public abstract class CrudServiceImpl<ModelObjectType extends BasicEntity, KeyType extends Serializable>{


    private CrudRepository<ModelObjectType, KeyType> crudRepository;
    private Class domainClass;
    protected final transient Logger logger = LoggerFactory.getLogger(getDomainClass());

    public ModelObjectType create(ModelObjectType entity) {
        entity.setEntityCreationTimestamp( Instant.now( ) ) ;
        return saveEntity( entity, 1 );
    }

    public void update(ModelObjectType entity){
        saveEntity( entity, entity.getEntityVersion() + 1 );
    }

    private ModelObjectType saveEntity(ModelObjectType entity, long version){
        entity.setLastUpdatedTimestamp( Instant.now( ) ) ;
        entity.setEntityVersion( version ) ;
        return crudRepository.save( entity ) ;
    }

    public void remove(ModelObjectType entity){
        crudRepository.delete(entity);
    }

    public void setCrudRepository(CrudRepository<ModelObjectType, KeyType> crudRepository){
        this.crudRepository = crudRepository;
    }

    public Optional<ModelObjectType> findById(KeyType entityId){

        Class type = getDomainClass();
        try{
            return crudRepository.findById( entityId );
        } catch( ObjectRetrievalFailureException e){
            if(logger.isWarnEnabled()){
                logger.warn(String.format("object instance of %s identified by %s not found in the database", type.getName(), entityId));
            }
            return Optional.empty();
        }
    }

    public List<ModelObjectType> getAll(CrudRepository crudRepository){
        return (List<ModelObjectType>) crudRepository.findAll();
    }

    protected Class getDomainClass(){
        if(domainClass == null){
            ParameterizedType thisType = ( ParameterizedType ) getClass().getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

}
