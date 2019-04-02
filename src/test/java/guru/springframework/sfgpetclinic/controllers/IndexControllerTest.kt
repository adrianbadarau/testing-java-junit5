package guru.springframework.sfgpetclinic.controllers

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.api.condition.*
import java.time.Duration

internal class IndexControllerTest : ControllerTest {
    val indexController = IndexController()
    val userName = "abadarau"


    @Test
    @DisplayName("Test proper view name is returned for the index page")
    fun index() {
        assertEquals("index", indexController.index())
        assertNotEquals("indexd", indexController.index(), "Wrong view returned")
        assertThat(indexController.index()).isEqualTo("index")
    }

    @DisplayName("Test exception")
    @RepeatedTest(10)
    fun oopsHandler() {
        assertThrows(ValueNotFoundException::class.java) { indexController.oopsHandler() }
    }

    @Test
    internal fun testTimeout() {
        assertTimeout(Duration.ofMillis(100)) {
            //            Thread.sleep(1000)
            print("I got here")
        }
    }

    @Test
    internal fun testTimeoutPreemptive() {
        assertTimeoutPreemptively(Duration.ofMillis(100)) {
            //            Thread.sleep(1000)
            print("I got here")
        }
    }

    @Test
    internal fun testAssumptionTrue() {
        assumeTrue("GURU".equals("guru", true))
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    fun testRunOnlyOnWindows() {

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    fun testRunOnlyOnLinux() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    fun testRunOnJdk8() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    fun testRunOnJdk11() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".+")
    fun testRunOnlyIfJavaHomeIsSet() {
    }

    @RepeatedTest(5)
    fun testRepeatedTestWithDI(testInfo: TestInfo, repetitionInfo: RepetitionInfo) {
        println("${testInfo.displayName} :  ${repetitionInfo.currentRepetition}")
    }
}
