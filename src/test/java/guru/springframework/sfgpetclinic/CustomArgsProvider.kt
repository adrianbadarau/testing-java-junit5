package guru.springframework.sfgpetclinic

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class CustomArgsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
                Arguments.of("FL",1,2),
                Arguments.of("OH",3,4),
                Arguments.of("MI",4,5)
        )
    }
}
