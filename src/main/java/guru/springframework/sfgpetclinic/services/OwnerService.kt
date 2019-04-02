package guru.springframework.sfgpetclinic.services

import guru.springframework.sfgpetclinic.model.Owner

interface OwnerService : CrudService<Owner, Long> {

    fun findByLastName(lastName: String): Owner

    fun findAllByLastNameLike(lastName: String): List<Owner>
}
