package com.example.demo2.dao.base;

import com.example.demo2.model.entity.base.BaseEntity;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Base Dao interface repository, the generic class for entity parameters
 *
 * @param <T>  the entity class extend for BaseEntity classes. In the collection
 * @param <ID> the entity id in the collection
 */
public interface BaseRepository<T extends BaseEntity, ID extends String> {

    /**
     * Insert one document the T entity collection in the database
     *
     * @param entity one document for the insert in the database
     * @return the entity insert
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Mono<T> insert(T entity) throws Exception;

    /**
     * Insert many document the T entity collection in the database
     *
     * @param entities many document for the insert in the database
     * @return the list iterable entity insert
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Flux<T> insert(Iterable<T> entities) throws Exception;

    /**
     * Update one document the T entity collection in the database
     *
     * @param entity one document for the update in the database
     * @return the entity update
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Mono<T> update(T entity) throws Exception;

    /**
     * Update many document the T entity collection in the database
     *
     * @param entities many document for the update in the database
     * @return the list iterable entity update
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Flux<T> update(Iterable<T> entities) throws Exception;

    /**
     * Delete one document for T entity collection in the data base
     *
     * @param entity delete one document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Mono<Void> delete(T entity) throws Exception;

    /**
     * Delete one document for T entity collection in the data base
     *
     * @param id the entity delete one document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Mono<Void> deleteById(ID id) throws Exception;

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Mono<Void> deleteAll() throws Exception;

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Mono<Void> deleteAll(Iterable<T> entities) throws Exception;

    /**
     * Find by id the collection T entity reference
     *
     * @param id id the entity document collection
     * @return one document for the collection
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Mono<T> findById(ID id) throws Exception;

    /**
     * Find by all id the T entity document reference
     *
     * @param ids ids the entity collections for search documents
     * @return all result the search
     * @throws Exception possibility exceptions
     */
    @SuppressWarnings("unused")
    Flux<T> findAllById(Iterable<ID> ids) throws Exception;

    /**
     * Get all document the collection in the data base type T
     *
     * @return all documents the collections
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Flux<T> findAll() throws Exception;

    /**
     * Get all document the collections with filter parameter base type T
     *
     * @param filter T filter search
     * @return result search
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Flux<T> findAll(T filter) throws Exception;

    /**
     * Get all document the collections with sort order parameter base
     *
     * @param sort order
     * @return all documents order by sorter
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Flux<T> findAll(Sort sort) throws Exception;

    /**
     * Get All document the collections with sort order and filter logic parameter
     *
     * @param filter filter for search document
     * @param sort   order
     * @return all document with sort and filter result
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Flux<T> findAll(T filter, Sort sort) throws Exception;

    /**
     * Get boolean for see exist the register with your id properties
     *
     * @param id id the object for the validation
     * @return boolean result
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    Mono<Boolean> existsById(ID id) throws Exception;
}
