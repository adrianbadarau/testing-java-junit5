package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.repositories.OwnerRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled

@Disabled("Disabled until we learn mocking")
internal class OwnerSDJpaServiceTest {

    val service: OwnerSDJpaService = OwnerSDJpaService(null, null, null)
    @BeforeEach
    fun setUp() {
    }

    @Test
    @Disabled
    fun findByLastName() {
        val owner = service.findAllByLastNameLike("Buck")
    }

    @Test
    fun findAllByLastNameLike() {
    }

    @Test
    fun findAll() {
    }

    @Test
    fun findById() {
    }

    @Test
    fun save() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun deleteById() {
    }
}
