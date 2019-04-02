package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.PetType
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository
import guru.springframework.sfgpetclinic.services.PetTypeService

import java.util.HashSet
import java.util.function.Consumer


class PetTypeSDJpaService(private val petTypeRepository: PetTypeRepository) : PetTypeService {

    override fun findAll(): Set<PetType> {
        val petTypes = HashSet<PetType>()
        petTypeRepository.findAll().forEach(Consumer<PetType> { petTypes.add(it) })
        return petTypes
    }

    override fun findById(id: Long?): PetType {
        return petTypeRepository.findById(id!!).orElse(null)
    }

    override fun save(`object`: PetType): PetType {
        return petTypeRepository.save(`object`)
    }

    override fun delete(`object`: PetType) {
        petTypeRepository.delete(`object`)
    }

    override fun deleteById(aLong: Long) {
        petTypeRepository.deleteById(aLong)
    }
}
