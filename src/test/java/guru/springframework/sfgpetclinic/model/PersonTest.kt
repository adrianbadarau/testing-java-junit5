package guru.springframework.sfgpetclinic.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@Tag("model")
internal class PersonTest {
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
}
