package guru.springframework.sfgpetclinic.fauxspring

import guru.springframework.sfgpetclinic.model.Pet

interface ModelMap {
    fun put(pet: String, pet1: Pet)
}
