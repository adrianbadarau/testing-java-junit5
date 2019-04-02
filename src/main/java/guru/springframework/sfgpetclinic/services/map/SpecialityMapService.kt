package guru.springframework.sfgpetclinic.services.map

import guru.springframework.sfgpetclinic.model.Speciality
import guru.springframework.sfgpetclinic.services.SpecialtyService

class SpecialityMapService : AbstractMapService<Speciality, Long>(), SpecialtyService {

    override fun findAll(): Set<Speciality> {
        return super.findAll()
    }

    override fun findById(id: Long?): Speciality {
        return super.findById(id)
    }

    override fun save(`object`: Speciality?): Speciality {
        return super.save(`object`)
    }

    override fun delete(`object`: Speciality) {
        super.delete(`object`)
    }

    override fun deleteById(id: Long?) {
        super.deleteById(id)
    }
}
