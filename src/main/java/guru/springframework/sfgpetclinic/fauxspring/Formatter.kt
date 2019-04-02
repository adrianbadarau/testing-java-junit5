package guru.springframework.sfgpetclinic.fauxspring

import guru.springframework.sfgpetclinic.model.PetType

import java.text.ParseException
import java.util.Locale


interface Formatter<T> {

    fun print(petType: PetType, locale: Locale): String

    @Throws(ParseException::class)
    fun parse(text: String, locale: Locale): PetType
}
