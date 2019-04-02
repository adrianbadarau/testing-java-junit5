package guru.springframework.sfgpetclinic.model


class PetType : BaseEntity {

    var name: String? = null

    override fun toString(): String {
        return name ?: ""
    }

    constructor() {}

    constructor(name: String) {
        this.name = name
    }

    constructor(id: Long?, name: String) : super(id) {
        this.name = name
    }
}
