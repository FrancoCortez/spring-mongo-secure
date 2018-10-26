package com.example.demo2.dao.base;


import com.example.demo2.model.entity.base.BaseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Base Dao implement repository, the generic class for entity parameters
 *
 * @param <T>  the entity class extend for BaseEntity classes. In the collection
 * @param <ID> the entity id in the collection
 */
public class BaseRepositoryImpl<T extends BaseEntity, ID extends String> implements BaseRepository<T, ID> {

    /**
     * Instance inject for mongo repository services for operations in the db collection
     */
    private final ReactiveMongoRepository<T, ID> tidReactiveMongoRepository;

    /**
     * Constructor for injections dependencies
     *
     * @param tidReactiveMongoRepository mongo operations dependency
     */
    public BaseRepositoryImpl(final ReactiveMongoRepository<T, ID> tidReactiveMongoRepository) {
        this.tidReactiveMongoRepository = tidReactiveMongoRepository;
    }

    /**
     * Insert one document the T entity collection in the database
     *
     * @param entity one document for the insert in the database
     * @return the entity insert
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Mono<T> insert(T entity) throws Exception {
        return this.tidReactiveMongoRepository.insert(entity);
    }

    /**
     * Insert many document the T entity collection in the database
     *
     * @param entities many document for the insert in the database
     * @return the list iterable entity insert
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Flux<T> insert(Iterable<T> entities) throws Exception {
        return this.tidReactiveMongoRepository.insert(entities);
    }

    /**
     * Update one document the T entity collection in the database
     *
     * @param entity one document for the update in the database
     * @return the entity update
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Mono<T> update(T entity) throws Exception {
        return this.tidReactiveMongoRepository.save(entity);
    }

    /**
     * Update many document the T entity collection in the database
     *
     * @param entities many document for the update in the database
     * @return the list iterable entity update
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Flux<T> update(Iterable<T> entities) throws Exception {
        return this.tidReactiveMongoRepository.saveAll(entities);
    }

    /**
     * Delete one document for T entity collection in the data base
     *
     * @param entity delete one document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Mono<Void> delete(T entity) throws Exception {
        return this.tidReactiveMongoRepository.delete(entity);
    }

    /**
     * Delete one document for T entity collection in the data base
     *
     * @param id the entity delete one document in the database
     * @return Void asyn
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Mono<Void> deleteById(ID id) throws Exception {
        return this.tidReactiveMongoRepository.deleteById(id);
    }

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Mono<Void> deleteAll() throws Exception {
        return this.tidReactiveMongoRepository.deleteAll();
    }

    /**
     * Delete all document for T entity collection in the data base
     *
     * @return Void asyn
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Mono<Void> deleteAll(Iterable<T> entities) throws Exception {
        return this.tidReactiveMongoRepository.deleteAll(entities);
    }

    /**
     * Find by id the collection T entity reference
     *
     * @param id id the entity document collection
     * @return one document for the collection
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Mono<T> findById(ID id) throws Exception {
        return this.tidReactiveMongoRepository.findById(id);
    }

    /**
     * Find by all id the T entity document reference
     *
     * @param ids ids the entity collections for search documents
     * @return all result the search
     * @throws Exception possibility exceptions
     */
    @SuppressWarnings("unused")
    public Flux<T> findAllById(Iterable<ID> ids) throws Exception {
        return this.tidReactiveMongoRepository.findAllById(ids);
    }

    /**
     * Get all document the collection in the data base type T
     *
     * @return all documents the collections
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Flux<T> findAll() throws Exception {
        return this.tidReactiveMongoRepository.findAll();
    }

    /**
     * Get all document the collections with filter parameter base type T
     *
     * @param filter T filter search
     * @return result search
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Flux<T> findAll(T filter) throws Exception {
        return this.tidReactiveMongoRepository.findAll(Example.of(filter));
    }

    /**
     * Get all document the collections with sort order parameter base
     *
     * @param sort order
     * @return all documents order by sorter
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Flux<T> findAll(Sort sort) throws Exception {
        return this.tidReactiveMongoRepository.findAll(sort);
    }

    /**
     * Get All document the collections with sort order and filter logic parameter
     *
     * @param filter filter for search document
     * @param sort   order
     * @return all document with sort and filter result
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Flux<T> findAll(T filter, Sort sort) throws Exception {
        return this.tidReactiveMongoRepository.findAll(Example.of(filter), sort);
    }

    /**
     * Get boolean for see exist the register with your id properties
     *
     * @param id id the object for the validation
     * @return boolean result
     * @throws Exception possibility exception
     */
    @SuppressWarnings("unused")
    public Mono<Boolean> existsById(ID id) throws Exception {
        return this.tidReactiveMongoRepository.existsById(id);
    }
}
