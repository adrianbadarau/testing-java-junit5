package guru.springframework.sfgpetclinic.controllers

import com.nhaarman.mockitokotlin2.*
import guru.springframework.sfgpetclinic.fauxspring.BindingResult
import guru.springframework.sfgpetclinic.model.Owner
import guru.springframework.sfgpetclinic.model.Pet
import guru.springframework.sfgpetclinic.repositories.OwnerRepository
import guru.springframework.sfgpetclinic.repositories.PetRepository
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository
import guru.springframework.sfgpetclinic.services.springdatajpa.OwnerSDJpaService
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class OwnerControllerTest {
    companion object {
        const val TEST_ADDRES = "TEST_ADDRESS"
        const val TEST_CITY = "TEST_CITY"
        const val TEST_TELEPHONE = "TEST_TELEPHONE"
        val TEST_PETS = mutableSetOf(Pet(1L))
    }

    @Mock
    lateinit var ownerService: OwnerSDJpaService
    @InjectMocks
    lateinit var ownerController: OwnerController

    @Test
    fun processCreationFormWillReturnResult() {
        //given
        val mockBindingResult = mock<BindingResult>()
        given(mockBindingResult.hasErrors()).willReturn(false)
        val mockOwner: Owner = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
        mockOwner.city = TEST_CITY
        mockOwner.telephone = TEST_TELEPHONE
        mockOwner.address = TEST_ADDRES
        mockOwner.pets = TEST_PETS
        mockOwner.id = 5L
        given(ownerService.save(any<Owner>())).willReturn(mockOwner)
        //when
        val redirect = ownerController.processCreationForm(mockOwner, mockBindingResult)
        //then
        then(ownerService).should().save(any<Owner>())
        assertThat(redirect).isEqualTo("redirect:/owners/5")
    }

    @Test
    fun processCreationFormWillError() {
        //given
        val mockBindingResult = mock<BindingResult>()
        given(mockBindingResult.hasErrors()).willReturn(true)
        val mockOwner: Owner = mock(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
        //when
        val redirect = ownerController.processCreationForm(mockOwner, mockBindingResult)
        //then
        then(ownerService).should(never()).save(any<Owner>())
        assertThat(redirect).isEqualTo(OwnerController.VIEWS_OWNER_CREATE_OR_UPDATE_FORM)
    }

}
