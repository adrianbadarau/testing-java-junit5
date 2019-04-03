package guru.springframework.sfgpetclinic.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EnumSource
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

    @DisplayName("param test")
    @ParameterizedTest(name = "{displayName} - [{index}] : {arguments}")
    @ValueSource(strings = ["Sprig", "Framework", "Guru"])
    fun testValueSource(value: String) {
        println(value)
    }

    @DisplayName("Enum test")
    @ParameterizedTest(name = "{displayName} - [{index}] : {arguments}")
    @EnumSource(OwnerType::class)
    fun testEnumSource(ownerType: OwnerType) {
        println(ownerType)
    }

    @DisplayName("CSV test")
    @ParameterizedTest(name = "{displayName} - [{index}] : {arguments}")
    @CsvSource(value = [
        "FL,1,1",
        "OH,2,2",
        "MI,3,1"
    ])
    fun testCsvInput(state: String, value1: Int, value2: String) {
        println(" $state with values: $value1 and $value2")
    }
    @DisplayName("CSV file test")
    @ParameterizedTest(name = "{displayName} - [{index}] : {arguments}")
    @CsvFileSource(resources = ["/input.csv"], numLinesToSkip = 1)
    fun testCsvFileInput(state: String, value1: Int, value2: String) {
        println(" $state with values: $value1 and $value2")
    }
}
