package guru.springframework.sfgpetclinic.controllers

import guru.springframework.sfgpetclinic.fauxspring.Model
import guru.springframework.sfgpetclinic.services.VetService

class VetController(private val vetService: VetService) {

    fun listVets(model: Model): String {

        model.addAttribute("vets", vetService.findAll())

        return "vets/index"
    }
}
