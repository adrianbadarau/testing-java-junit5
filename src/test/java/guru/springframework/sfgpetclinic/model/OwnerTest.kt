package guru.springframework.sfgpetclinic.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class OwnerTest : ModelTest {

    @Test
    fun dependentAssertions() {
        val owner = Owner(1L, "Joe", "Buck")
        owner.city = "Key West"
        owner.telephone = "1231231234"

        assertAll("Properties Test",
                {
                    assertAll("Person Props",
                            { assertEquals("Joe", owner.firstName) },
                            { assertEquals("Buck", owner.lastName) }
                    )
                },
                {
                    assertAll("Owner Props",
                            { assertEquals("Key West", owner.city) },
                            { assertEquals("1231231234", owner.telephone) }
                    )
                }
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["Sprig", "Framework", "Guru"])
    fun testValueSource(value: String) {
        println(value)
    }
}
