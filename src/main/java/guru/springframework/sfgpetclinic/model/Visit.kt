package guru.springframework.sfgpetclinic.model

import java.time.LocalDate

class Visit : BaseEntity {

    var date: LocalDate? = null
    var description: String? = null
    var pet: Pet? = null

    constructor() : super(null) {}

    constructor(id: Long?) : super(id) {}

    constructor(id: Long?, date: LocalDate) : super(id) {
        this.date = date
    }
}
