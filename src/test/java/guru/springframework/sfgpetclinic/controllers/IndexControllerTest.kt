package guru.springframework.sfgpetclinic.controllers

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IndexControllerTest {
    val indexController = IndexController()
    @BeforeEach
    fun setUp() {

    }

    @Test
    fun index() {
        assertEquals("index", indexController.index())
        assertNotEquals("indexd", indexController.index(), "Wrong view returned")
    }

    @Test
    fun oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()))
    }
}
