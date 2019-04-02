package guru.springframework.sfgpetclinic.controllers

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag

@Tag("controllers")
interface ControllerTest {

    @JvmDefault
    @BeforeEach
    fun beforeAll(){
    }
}
