package guru.springframework.sfgpetclinic.repositories


import guru.springframework.sfgpetclinic.model.Owner

interface OwnerRepository : CrudRepository<Owner, Long> {

    fun findByLastName(lastName: String): Owner

    fun findAllByLastNameLike(lastName: String): List<Owner>
}
