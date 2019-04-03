package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.repositories.VetRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class VetSDJpaServiceTest {

    @Mock
    lateinit var vetRepository: VetRepository

    @InjectMocks
    lateinit var service:VetSDJpaService

    @Test
    fun deleteById() {
        service.deleteById(1L)

        verify(vetRepository, atLeastOnce()).deleteById(1L)
    }
}
