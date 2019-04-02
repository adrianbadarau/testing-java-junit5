package guru.springframework.sfgpetclinic.controllers

import guru.springframework.sfgpetclinic.fauxspring.Model
import guru.springframework.sfgpetclinic.fauxspring.ModelAndView
import guru.springframework.sfgpetclinic.model.Speciality
import guru.springframework.sfgpetclinic.model.Vet
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService
import guru.springframework.sfgpetclinic.services.map.VetMapService
import guru.springframework.sfgpetclinic.services.springdatajpa.VetSDJpaService
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag

@Tag("controllers")
internal class VetControllerTest {


    internal class TestModel : Model {
        val attributes = hashMapOf<String, Any>()
        override fun addAttribute(key: String, o: Any) {
            attributes.put(key, o)
        }

        override fun addAttribute(o: Any) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    @Test
    fun listVets() {
        val model = TestModel()
        assertThat(controller.listVets(model)).isEqualTo("vets/index")
        assertThat(model.attributes).containsKey("vets")
        assertThat((model.attributes.get("vets") as Set<Vet>).size).isEqualTo(2)
    }

    companion object {
        @BeforeAll
        @JvmStatic
        fun setUp() {
            service.save(
                    Vet(1L, "TEST", "TEST", setOf(Speciality("Dogs"), Speciality("Cats")))
            )
            service.save(
                    Vet(2L, "TEST2", "TEST2", setOf(Speciality("Snakes"), Speciality("Spiders")))
            )
        }

        val service = VetMapService(SpecialityMapService())
        val controller = VetController(service)
    }
}
