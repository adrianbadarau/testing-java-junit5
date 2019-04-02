package guru.springframework.sfgpetclinic.model

import java.util.HashSet


class Vet(id: Long?, firstName: String, lastName: String, specialities: Set<Speciality>) : Person(id, firstName, lastName) {

    var specialities: Set<Speciality> = HashSet()

    init {
        this.specialities = specialities
    }
}
