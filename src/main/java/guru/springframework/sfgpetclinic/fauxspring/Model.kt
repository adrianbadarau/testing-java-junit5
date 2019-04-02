package guru.springframework.sfgpetclinic.fauxspring

interface Model {

    fun addAttribute(key: String, o: Any)

    fun addAttribute(o: Any)
}
