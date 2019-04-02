package guru.springframework.sfgpetclinic.controllers

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class IndexControllerTest {
    val indexController = IndexController()
    @BeforeEach
    fun setUp() {

    }

    @Test
    @DisplayName("Test proper view name is returned for the index page")
    fun index() {
        assertEquals("index", indexController.index())
        assertNotEquals("indexd", indexController.index(), "Wrong view returned")
    }

    @Test
    @DisplayName("Test exception")
    fun oopsHandler() {
        assertThrows(ValueNotFoundException::class.java) { indexController.oopsHandler() }
    }
}
