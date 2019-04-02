package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.Pet
import guru.springframework.sfgpetclinic.repositories.PetRepository
import guru.springframework.sfgpetclinic.services.PetService

import java.util.HashSet


class PetSDJpaService(private val petRepository: PetRepository) : PetService {

    override fun findAll(): Set<Pet> {
        val pets = HashSet<Pet>()
        petRepository.findAll().forEach { pets.add(it) }
        return pets
    }

    override fun findById(aLong: Long): Pet {
        return petRepository.findById(aLong).orElse(null)
    }

    override fun save(`object`: Pet): Pet {
        return petRepository.save(`object`)
    }

    override fun delete(`object`: Pet) {
        petRepository.delete(`object`)
    }

    override fun deleteById(aLong: Long) {
        petRepository.deleteById(aLong)
    }
}
