package guru.springframework.sfgpetclinic.services.map

import guru.springframework.sfgpetclinic.model.Owner
import guru.springframework.sfgpetclinic.model.PetType
import guru.springframework.sfgpetclinic.services.PetService
import guru.springframework.sfgpetclinic.services.PetTypeService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class OwnerMapServiceTest {
    var petTypeService = PetTypeMapService()
    var petService = PetMapService()
    val ownerMapService = OwnerMapService(petTypeService, petService)

    @DisplayName("Verify Zero Owners")
    @Test
    fun ownersAreZero() {
        val ownerCount = ownerMapService.findAll().size

        assertThat(ownerCount).isZero()
    }

    @DisplayName("Pet Type - ")
    @Nested
    internal inner class TestCreatePetTypes {

        @BeforeEach
        fun setUp() {
            val petType = PetType(1L, "Dog")
            val petType2 = PetType(2L, "Cat")
            petTypeService.save(petType)
            petTypeService.save(petType2)
        }

        @DisplayName("Test Pet Count")
        @Test
        fun testPetCount() {
            val petTypeCount = petTypeService.findAll().size

            assertThat(petTypeCount).isNotZero().isEqualTo(2)
        }

        @DisplayName("Save Owners Tests - ")
        @Nested
        internal inner class SaveOwnersTests {

            @BeforeEach
            fun setUp() {
                ownerMapService.save(Owner(1L, "Before", "Each"))
            }

            @DisplayName("Save Owner")
            @Test
            fun saveOwner() {
                val owner = Owner(2L, "Joe", "Buck")

                val savedOwner = ownerMapService.save(owner)

                assertThat(savedOwner).isNotNull()
            }

            @DisplayName("Save Owners Tests - ")
            @Nested
            internal inner class FindOwnersTests {

                @DisplayName("Find Owner")
                @Test
                fun findOwner() {

                    val foundOwner = ownerMapService.findById(1L)

                    assertThat(foundOwner).isNotNull()
                }

                @DisplayName("Find Owner Not Found")
                @Test
                fun findOwnerNotFound() {

                    val foundOwner:Owner? = ownerMapService.findById(2L)

                    assertThat(foundOwner).isNull()
                }
            }
        }
    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    fun ownersAreStillZero() {
        val ownerCount = ownerMapService.findAll().size

        assertThat(ownerCount).isZero()
    }
}
