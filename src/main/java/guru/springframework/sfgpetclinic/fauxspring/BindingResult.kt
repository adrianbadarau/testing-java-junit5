package guru.springframework.sfgpetclinic.fauxspring


interface BindingResult {
    fun rejectValue(lastName: String, notFound: String, not_found: String)

    fun hasErrors(): Boolean
}
