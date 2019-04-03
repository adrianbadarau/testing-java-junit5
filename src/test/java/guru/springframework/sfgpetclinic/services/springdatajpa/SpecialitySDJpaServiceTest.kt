package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.Speciality
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class SpecialitySDJpaServiceTest {

    @Mock
    lateinit var specialtyRepository: SpecialtyRepository

    @InjectMocks
    lateinit var service: SpecialitySDJpaService

    @Test
    fun deleteById() {
        service.deleteById(1L)
        service.deleteById(1L)
        verify(specialtyRepository, atMost(2)).deleteById(1L)
        verify(specialtyRepository, never()).delete(Speciality())
    }

    @Test
    fun delete() {
        service.delete(Speciality())
    }

    @Test
    fun findByIdTest() {
        val speciality = Speciality()
        `when`(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality))
        val found = service.findById(1L)
        assertThat(found).isNotNull
        verify(specialtyRepository).findById(1L)
    }
}
