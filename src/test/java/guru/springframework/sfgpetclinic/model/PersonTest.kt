package guru.springframework.sfgpetclinic.model

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class PersonTest : ModelTest {
    @Test
    internal fun groupedAssertions() {
        //given
        val person = Person(1L, "Joe", "Buck")
        //then
        assertAll("TestPropsSet",
                { assertEquals(person.firstName, "Joe") },
                { assertEquals(person.lastName, "Buck") }
        )

    }

    @RepeatedTest(5, name = "{displayName} {currentRepetition} of {totalRepetitions}")
    @DisplayName("Person repeated test")
    fun testRepeatPerson(repetitionInfo: RepetitionInfo){
        val person = Person(1L, "Joe ${repetitionInfo.currentRepetition}", "Buck")
        assertEquals("Joe ${repetitionInfo.currentRepetition}", person.firstName)
    }
}
