package com.stevenprogramming.eclipselink.services;

import com.stevenprogramming.eclipselink.model.BasicEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 *  @author Steven Mendez
 *  @version 1.0
 *  @since 06/24/2019
 *
 */
public interface CrudService<ModelObjectType extends BasicEntity, KeyType extends Serializable>{

    /**
     * Makes <code>entity</code> persistent.
     *
     * @param entity the entity to be persisted.
     *
     * @return the generated new persistent entity.
     */
    ModelObjectType create(ModelObjectType entity);

    /**
     * Updates the entity data into the data store.
     *
     * @param entity the entity to be updated.
     */
    void update(ModelObjectType entity);

    /**
     * Removes the entity from the data stores (making the instance passed as
     * parameter transient).
     *
     * @param entity the entity to be removed/made transient.
     */
    void remove(ModelObjectType entity);

    /**
     * Searches the data store for the entity identified by
     * <code>entityId</code>.
     *
     * @param entityId the primary identifier of the entity being searched.
     *
     * @return the entity identified by <code>entityId</code> or
     *         <code>null</code> if no entity was found.
     */
    Optional<ModelObjectType> findById(KeyType entityId);

    /**
     * Returns all the entities of the given Service Class.
     *
     * @return the collection of entities.
     */
    List<ModelObjectType> getAll( CrudRepository crudRepository );

}
