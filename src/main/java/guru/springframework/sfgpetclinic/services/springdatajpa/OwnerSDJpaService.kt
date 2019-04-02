package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.Owner
import guru.springframework.sfgpetclinic.repositories.OwnerRepository
import guru.springframework.sfgpetclinic.repositories.PetRepository
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository
import guru.springframework.sfgpetclinic.services.OwnerService

import java.util.HashSet

class OwnerSDJpaService(private val ownerRepository: OwnerRepository, private val petRepository: PetRepository,
                        private val petTypeRepository: PetTypeRepository) : OwnerService {

    override fun findByLastName(lastName: String): Owner {
        return ownerRepository.findByLastName(lastName)
    }

    override fun findAllByLastNameLike(lastName: String): List<Owner> {
        return ownerRepository.findAllByLastNameLike(lastName)
    }

    override fun findAll(): Set<Owner> {
        val owners = HashSet<Owner>()
        ownerRepository.findAll().forEach { owners.add(it) }
        return owners
    }

    override fun findById(aLong: Long): Owner {
        return ownerRepository.findById(aLong).orElse(null)
    }

    override fun save(`object`: Owner): Owner {
        return ownerRepository.save(`object`)
    }

    override fun delete(`object`: Owner) {
        ownerRepository.delete(`object`)
    }

    override fun deleteById(aLong: Long) {
        ownerRepository.deleteById(aLong)
    }
}
