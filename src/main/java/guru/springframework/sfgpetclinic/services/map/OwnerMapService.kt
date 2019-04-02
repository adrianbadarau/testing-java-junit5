package guru.springframework.sfgpetclinic.services.map

import guru.springframework.sfgpetclinic.model.Owner
import guru.springframework.sfgpetclinic.model.Pet
import guru.springframework.sfgpetclinic.services.OwnerService
import guru.springframework.sfgpetclinic.services.PetService
import guru.springframework.sfgpetclinic.services.PetTypeService

class OwnerMapService(private val petTypeService: PetTypeService, private val petService: PetService) : AbstractMapService<Owner, Long>(), OwnerService {

    override fun findAll(): Set<Owner> {
        return super.findAll()
    }

    override fun findById(id: Long?): Owner {
        return super.findById(id)
    }

    override fun save(`object`: Owner?): Owner {

        if (`object` != null) {
            if (`object`.pets != null) {
                `object`.pets.forEach { pet ->
                    if (pet.petType != null) {
                        if (pet.petType!!.id == null) {
                            pet.petType = petTypeService.save(pet.petType)
                        }
                    } else {
                        throw RuntimeException("Pet Type is required")
                    }

                    if (pet.id == null) {
                        val savedPet = petService.save(pet)
                        pet.id = savedPet.id
                    }
                }
            }

            return super.save(`object`)

        } else {
            return null
        }
    }

    override fun delete(`object`: Owner) {
        super.delete(`object`)
    }

    override fun deleteById(id: Long?) {
        super.deleteById(id)
    }

    override fun findByLastName(lastName: String): Owner {
        return this.findAll()
                .stream()
                .filter { owner -> owner.lastName!!.equals(lastName, ignoreCase = true) }
                .findFirst()
                .orElse(null)
    }

    override fun findAllByLastNameLike(lastName: String): List<Owner>? {

        //todo - impl
        return null
    }
}
