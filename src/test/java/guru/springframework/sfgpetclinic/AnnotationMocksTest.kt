package guru.springframework.sfgpetclinic

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AnnotationMocksTest {

    @Mock
    lateinit var mapMock: MutableMap<String, Any>

    @BeforeEach
    internal fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    internal fun testMock() {
        mapMock.put("key", "foo")
    }
}
