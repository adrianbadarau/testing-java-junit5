package guru.springframework.sfgpetclinic.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestInfo

@Tag("models")
interface ModelTest {

    @BeforeEach
    fun beforeEach(testInfo: TestInfo, repetitionInfo: RepetitionInfo){
        println("Now running ${testInfo.displayName} : ${repetitionInfo.currentRepetition}")
    }
}
