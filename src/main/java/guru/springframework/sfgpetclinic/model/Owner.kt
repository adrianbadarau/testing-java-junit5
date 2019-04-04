package guru.springframework.sfgpetclinic.model



open class Owner(id: Long?, firstName: String?, lastName: String?) : Person(id, firstName, lastName) {

    var address: String? = null
    var city: String? = null
    var telephone: String? = null
    var pets = mutableSetOf<Pet>()

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    @JvmOverloads
    fun getPet(name: String, ignoreNew: Boolean = false): Pet? {
        var name = name
        name = name.toLowerCase()
        for (pet in pets) {
            if (!ignoreNew || !pet.isNew) {
                var compName = pet.name
                compName = compName!!.toLowerCase()
                if (compName == name) {
                    return pet
                }
            }
        }
        return null
    }
}
