package guru.springframework.sfgpetclinic.model

import java.time.LocalDate
import java.util.HashSet


class Pet : BaseEntity {

    var name: String? = null
    var petType: PetType? = null
    var owner: Owner? = null
    var birthDate: LocalDate? = null
    var visits: Set<Visit> = HashSet()

    constructor() {}

    constructor(id: Long?) : super(id) {}
}
