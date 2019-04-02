package guru.springframework.sfgpetclinic.repositories

import java.util.Optional

interface CrudRepository<T, ID> : Repository<T, ID> {

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity must not be null.
     * @return the saved entity will never be null.
     */
    fun <S : T> save(entity: S): S

    /**
     * Saves all given entities.
     *
     * @param entities must not be null.
     * @return the saved entities will never be null.
     * @throws IllegalArgumentException in case the given entity is null.
     */
    fun <S : T> saveAll(entities: Iterable<S>): Iterable<S>

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be null.
     * @return the entity with the given id or Optional#empty() if none found
     * @throws IllegalArgumentException if `id` is null.
     */
    fun findById(id: ID): Optional<T>

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id must not be null.
     * @return true if an entity with the given id exists, false otherwise.
     * @throws IllegalArgumentException if `id` is null.
     */
    fun existsById(id: ID): Boolean

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    fun findAll(): Iterable<T>

    /**
     * Returns all instances of the type with the given IDs.
     *
     * @param ids
     * @return
     */
    fun findAllById(ids: Iterable<ID>): Iterable<T>

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    fun count(): Long

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be null.
     * @throws IllegalArgumentException in case the given `id` is null
     */
    fun deleteById(id: ID)

    /**
     * Deletes a given entity.
     *
     * @param entity
     * @throws IllegalArgumentException in case the given entity is null.
     */
    fun delete(entity: T)

    /**
     * Deletes the given entities.
     *
     * @param entities
     * @throws IllegalArgumentException in case the given [Iterable] is null.
     */
    fun deleteAll(entities: Iterable<T>)

    /**
     * Deletes all entities managed by the repository.
     */
    fun deleteAll()
}
