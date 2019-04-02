package guru.springframework.sfgpetclinic.repositories

import guru.springframework.sfgpetclinic.model.PetType

interface PetTypeRepository : CrudRepository<PetType, Long>
