package guru.springframework.sfgpetclinic.controllers

class IndexController {

    fun index(): String {

        return "index"
    }

    fun oopsHandler(): String {
        throw ValueNotFoundException()
    }
}
