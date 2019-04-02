package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.Speciality
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository
import guru.springframework.sfgpetclinic.services.SpecialtyService

import java.util.HashSet
import java.util.function.Consumer


class SpecialitySDJpaService(private val specialtyRepository: SpecialtyRepository) : SpecialtyService {

    override fun findAll(): Set<Speciality> {
        val specialities = HashSet<Speciality>()
        specialtyRepository.findAll().forEach(Consumer<Speciality> { specialities.add(it) })
        return specialities
    }

    override fun findById(aLong: Long): Speciality {
        return specialtyRepository.findById(aLong).orElse(null)
    }

    override fun save(`object`: Speciality): Speciality {
        return specialtyRepository.save(`object`)
    }

    override fun delete(`object`: Speciality) {
        specialtyRepository.delete(`object`)
    }

    override fun deleteById(aLong: Long) {
        specialtyRepository.deleteById(aLong)
    }
}
