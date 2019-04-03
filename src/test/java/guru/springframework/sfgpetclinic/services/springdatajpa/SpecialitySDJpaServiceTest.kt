package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.Speciality
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class SpecialitySDJpaServiceTest {

    @Mock
    lateinit var specialtyRepository: SpecialtyRepository

    @InjectMocks
    lateinit var service:SpecialitySDJpaService

    @Test
    fun deleteById() {
        service.deleteById(1L)
    }

    @Test
    fun delete(){
        service.delete(Speciality())
    }
}
