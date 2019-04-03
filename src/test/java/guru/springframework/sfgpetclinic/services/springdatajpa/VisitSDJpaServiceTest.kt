package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.Visit
import guru.springframework.sfgpetclinic.repositories.VisitRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class VisitSDJpaServiceTest {

    @Mock
    lateinit var visitRepository: VisitRepository
    @InjectMocks
    lateinit var service: VisitSDJpaService


    @Test
    fun findAll() {
        `when`(visitRepository.findAll()).thenReturn(listOf(
                Visit(1L), Visit(2L), Visit(3L)
        ))
        val findAll = service.findAll()
        assertThat(findAll).isNotEmpty
        assertThat(findAll.size).isEqualTo(3)
        verify(visitRepository).findAll()
    }

    @Test
    fun findAllBDD(){
        given(visitRepository.findAll()).willReturn(listOf(
                Visit(1L), Visit(2L), Visit(3L)
        ))

        //when
        val findAll = service.findAll()

        //then
        then(visitRepository).should().findAll()
        assertThat(findAll).isNotEmpty
        assertThat(findAll.size).isEqualTo(3)
    }

    @Test
    fun findById() {
        `when`(visitRepository.findById(1L)).thenReturn(Optional.of(Visit(1L)))
        val visit = service.findById(1L)
        assertThat(visit).isNotNull
        assertThat(visit.id).isEqualTo(1L)
        verify(visitRepository).findById(1L)
    }

    @Test
    fun findByIdBDD() {
        given(visitRepository.findById(1L)).willReturn(Optional.of(Visit(1L)))

        //when
        val visit = service.findById(1L)

        then(visitRepository).should().findById(1L)
        assertThat(visit).isNotNull
        assertThat(visit.id).isEqualTo(1L)
    }

    @Test
    fun save() {
        `when`(visitRepository.save(ArgumentMatchers.any(Visit::class.java))).thenReturn(Visit(1L))
        val visit = service.save(Visit())
        assertThat(visit.id).isEqualTo(1L)
        verify(visitRepository).save(ArgumentMatchers.any(Visit::class.java))
    }

    @Test
    fun saveBDD() {
        given(visitRepository.save(ArgumentMatchers.any(Visit::class.java))).willReturn(Visit(1L))
        //when
        val visit = service.save(Visit())

        then(visitRepository).should().save(ArgumentMatchers.any(Visit::class.java))
        assertThat(visit.id).isEqualTo(1L)
    }

    @Test
    fun delete() {
        val toBeDeleted = Visit(1L)
        service.delete(toBeDeleted)
        verify(visitRepository).delete(ArgumentMatchers.any(Visit::class.java) ?: toBeDeleted)
    }

    @Test
    fun deleteBDD() {
        //given
        val toBeDeleted = Visit(1L)
        //when
        service.delete(toBeDeleted)
        then(visitRepository).should().delete(ArgumentMatchers.any(Visit::class.java) ?: toBeDeleted)
    }

    @Test
    fun deleteById() {
        service.deleteById(1L)
        verify(visitRepository).deleteById(1L)
    }

    @Test
    fun deleteByIdBDD() {
        //when
        service.deleteById(1L)

        then(visitRepository).should().deleteById(1L)
    }
}
