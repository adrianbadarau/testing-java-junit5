package guru.springframework.sfgpetclinic.services.map

import guru.springframework.sfgpetclinic.model.Pet
import guru.springframework.sfgpetclinic.services.PetService


class PetMapService : AbstractMapService<Pet, Long>(), PetService {
    override fun findAll(): Set<Pet> {
        return super.findAll()
    }

    override fun findById(id: Long?): Pet {
        return super.findById(id)
    }

    override fun save(`object`: Pet?): Pet {
        return super.save(`object`)
    }

    override fun delete(`object`: Pet) {
        super.delete(`object`)
    }

    override fun deleteById(id: Long?) {
        super.deleteById(id)
    }
}
