package guru.springframework.sfgpetclinic.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@Tag("model")
internal class OwnerTest {

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
}
