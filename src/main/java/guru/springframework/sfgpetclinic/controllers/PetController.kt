package guru.springframework.sfgpetclinic.controllers

import guru.springframework.sfgpetclinic.fauxspring.BindingResult
import guru.springframework.sfgpetclinic.fauxspring.Model
import guru.springframework.sfgpetclinic.fauxspring.ModelMap
import guru.springframework.sfgpetclinic.fauxspring.WebDataBinder
import guru.springframework.sfgpetclinic.model.Owner
import guru.springframework.sfgpetclinic.model.Pet
import guru.springframework.sfgpetclinic.model.PetType
import guru.springframework.sfgpetclinic.services.OwnerService
import guru.springframework.sfgpetclinic.services.PetService
import guru.springframework.sfgpetclinic.services.PetTypeService
import org.apache.commons.lang3.StringUtils

import javax.validation.Valid

class PetController(private val petService: PetService, private val ownerService: OwnerService, private val petTypeService: PetTypeService) {

    fun populatePetTypes(): Collection<PetType> {
        return petTypeService.findAll()
    }

    fun findOwner(ownerId: Long?): Owner {
        return ownerService.findById(ownerId)
    }

    fun initOwnerBinder(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("id")
    }

    fun initCreationForm(owner: Owner, model: Model): String {
        val pet = Pet()
        owner.pets.add(pet)
        pet.owner = owner
        model.addAttribute("pet", pet)
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM
    }

    fun processCreationForm(owner: Owner, @Valid pet: Pet, result: BindingResult, model: ModelMap): String {
        if (StringUtils.length(pet.name) > 0 && pet.isNew && owner.getPet(pet.name!!, true) != null) {
            result.rejectValue("name", "duplicate", "already exists")
        }
        owner.pets.add(pet)
        if (result.hasErrors()) {
            model.put("pet", pet)
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM
        } else {
            petService.save(pet)

            return "redirect:/owners/" + owner.id!!
        }
    }

    fun initUpdateForm(petId: Long?, model: Model): String {
        model.addAttribute("pet", petService.findById(petId))
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM
    }

    fun processUpdateForm(@Valid pet: Pet, result: BindingResult, owner: Owner, model: Model): String {
        if (result.hasErrors()) {
            pet.owner = owner
            model.addAttribute("pet", pet)
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM
        } else {
            owner.pets.add(pet)
            petService.save(pet)
            return "redirect:/owners/" + owner.id!!
        }
    }

    companion object {

        private val VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm"
    }
}
