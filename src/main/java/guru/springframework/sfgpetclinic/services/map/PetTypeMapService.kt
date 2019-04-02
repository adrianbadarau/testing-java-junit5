package guru.springframework.sfgpetclinic.services.map

import guru.springframework.sfgpetclinic.model.PetType
import guru.springframework.sfgpetclinic.services.PetTypeService

class PetTypeMapService : AbstractMapService<PetType, Long>(), PetTypeService {

    override fun findAll(): Set<PetType> {
        return super.findAll()
    }

    override fun findById(id: Long?): PetType {
        return super.findById(id)
    }

    override fun save(`object`: PetType?): PetType {
        return super.save(`object`)
    }

    override fun delete(`object`: PetType) {
        super.delete(`object`)
    }

    override fun deleteById(id: Long?) {
        super.deleteById(id)
    }
}
