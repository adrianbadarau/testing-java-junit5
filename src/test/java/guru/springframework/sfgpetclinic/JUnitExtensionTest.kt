package guru.springframework.sfgpetclinic

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class JUnitExtensionTest {
    @Mock
    lateinit var mapMock: MutableMap<String, Any>


    @Test
    internal fun testMock() {
        mapMock.put("key", "foo")
    }
}
