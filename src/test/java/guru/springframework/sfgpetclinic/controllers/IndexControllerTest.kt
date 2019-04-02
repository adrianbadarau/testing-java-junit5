package guru.springframework.sfgpetclinic.controllers

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import java.time.Duration

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

    @Test
    internal fun testTimeout() {
        assertTimeout(Duration.ofMillis(100)){
//            Thread.sleep(1000)
            print("I got here")
        }
    }
    @Test
    internal fun testTimeoutPreemptive() {
        assertTimeoutPreemptively(Duration.ofMillis(100)){
//            Thread.sleep(1000)
            print("I got here")
        }
    }
}
