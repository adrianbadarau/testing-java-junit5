package guru.springframework.sfgpetclinic.services.map

import guru.springframework.sfgpetclinic.model.Speciality
import guru.springframework.sfgpetclinic.model.Vet
import guru.springframework.sfgpetclinic.services.SpecialtyService
import guru.springframework.sfgpetclinic.services.VetService

class VetMapService(private val specialtyService: SpecialtyService) : AbstractMapService<Vet, Long>(), VetService {

    override fun findAll(): Set<Vet> {
        return super.findAll()
    }

    override fun findById(id: Long?): Vet {
        return super.findById(id)
    }

    override fun save(`object`: Vet): Vet {

        if (`object`.specialities.size > 0) {
            `object`.specialities.forEach { speciality ->
                if (speciality.id == null) {
                    val savedSpecialty = specialtyService.save(speciality)
                    speciality.id = savedSpecialty.id
                }
            }
        }

        return super.save(`object`)
    }

    override fun delete(`object`: Vet) {
        super.delete(`object`)
    }

    override fun deleteById(id: Long?) {
        super.deleteById(id)
    }
}
