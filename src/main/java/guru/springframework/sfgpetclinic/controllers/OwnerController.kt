package guru.springframework.sfgpetclinic.controllers

import guru.springframework.sfgpetclinic.fauxspring.BindingResult
import guru.springframework.sfgpetclinic.fauxspring.Model
import guru.springframework.sfgpetclinic.fauxspring.ModelAndView
import guru.springframework.sfgpetclinic.fauxspring.WebDataBinder
import guru.springframework.sfgpetclinic.model.Owner
import guru.springframework.sfgpetclinic.services.OwnerService

import javax.validation.Valid


class OwnerController(private val ownerService: OwnerService) {

    fun setAllowedFields(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("id")
    }

    fun findOwners(model: Model): String {
        model.addAttribute("owner", Owner(null, null, null))
        return "owners/findOwners"
    }

    fun processFindForm(owner: Owner, result: BindingResult, model: Model): String {
        var owner = owner
        // allow parameterless GET request for /owners to return all records
        if (owner.lastName == null) {
            owner.lastName = "" // empty string signifies broadest possible search
        }

        // find owners by last name
        val results = ownerService.findAllByLastNameLike("%" + owner.lastName + "%")

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found")
            return "owners/findOwners"
        } else if (results.size == 1) {
            // 1 owner found
            owner = results[0]
            return "redirect:/owners/" + owner.id!!
        } else {
            // multiple owners found
            model.addAttribute("selections", results)
            return "owners/ownersList"
        }
    }

    fun showOwner(ownerId: Long?): ModelAndView {
        val mav = ModelAndView("owners/ownerDetails")
        mav.addObject(ownerService.findById(ownerId))
        return mav
    }

    fun initCreationForm(model: Model): String {
        model.addAttribute("owner", Owner(null, null, null))
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM
    }

    fun processCreationForm(@Valid owner: Owner, result: BindingResult): String {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM
        } else {
            val savedOwner = ownerService.save(owner)
            return "redirect:/owners/" + savedOwner.id!!
        }
    }

    fun initUpdateOwnerForm(ownerId: Long?, model: Model): String {
        model.addAttribute(ownerService.findById(ownerId))
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM
    }

    fun processUpdateOwnerForm(@Valid owner: Owner, result: BindingResult, ownerId: Long?): String {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM
        } else {
            owner.id = ownerId
            val savedOwner = ownerService.save(owner)
            return "redirect:/owners/" + savedOwner.id!!
        }
    }

    companion object {
        public val VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm"
    }

}
