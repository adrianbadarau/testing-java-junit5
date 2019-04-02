package guru.springframework.sfgpetclinic.repositories

import guru.springframework.sfgpetclinic.model.Pet

interface PetRepository : CrudRepository<Pet, Long>
