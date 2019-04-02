package guru.springframework.sfgpetclinic.services

interface CrudService<T, ID> {

    fun findAll(): Set<T>

    fun findById(id: ID): T

    fun save(`object`: T): T

    fun delete(`object`: T)

    fun deleteById(id: ID)
}
