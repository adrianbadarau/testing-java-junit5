package guru.springframework

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

class InlineMockTest {
    @Test
    internal fun testInlineMock() {
        val mapMock = mock(Map::class.java)

        assertEquals(mapMock.size, 0)
    }
}
