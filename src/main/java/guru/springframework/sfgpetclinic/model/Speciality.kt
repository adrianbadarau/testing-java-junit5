package guru.springframework.sfgpetclinic.model

open class Speciality : BaseEntity {
    var description: String? = null

    constructor() {}

    constructor(description: String) {
        this.description = description
    }

    constructor(id: Long?, description: String) : super(id) {
        this.description = description
    }
}
