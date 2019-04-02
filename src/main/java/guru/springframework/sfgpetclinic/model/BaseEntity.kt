package guru.springframework.sfgpetclinic.model

import java.io.Serializable


open class BaseEntity : Serializable {

    var id: Long? = null

    val isNew: Boolean
        get() = this.id == null

    constructor() {}

    constructor(id: Long?) {
        this.id = id
    }
}
