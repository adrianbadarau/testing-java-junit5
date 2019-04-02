package guru.springframework.sfgpetclinic.controllers

import guru.springframework.sfgpetclinic.fauxspring.BindingResult
import guru.springframework.sfgpetclinic.fauxspring.WebDataBinder
import guru.springframework.sfgpetclinic.model.Pet
import guru.springframework.sfgpetclinic.model.Visit
import guru.springframework.sfgpetclinic.services.PetService
import guru.springframework.sfgpetclinic.services.VisitService

import javax.validation.Valid


class VisitController(private val visitService: VisitService, private val petService: PetService) {

    fun setAllowedFields(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("id")
    }

    fun loadPetWithVisit(petId: Long?, model: MutableMap<String, Any>): Visit {
        val pet = petService.findById(petId)
        model["pet"] = pet
        val visit = Visit()
        pet.visits.add(visit)
        visit.pet = pet
        return visit
    }

    fun initNewVisitForm(petId: Long?, model: Map<String, Any>): String {
        return "pets/createOrUpdateVisitForm"
    }

    fun processNewVisitForm(@Valid visit: Visit, result: BindingResult): String {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm"
        } else {
            visitService.save(visit)

            return "redirect:/owners/{ownerId}"
        }
    }
}
