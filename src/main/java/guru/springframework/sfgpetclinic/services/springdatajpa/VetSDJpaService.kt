package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.Vet
import guru.springframework.sfgpetclinic.repositories.VetRepository
import guru.springframework.sfgpetclinic.services.VetService

import java.util.HashSet
import java.util.function.Consumer

class VetSDJpaService(private val vetRepository: VetRepository?) : VetService {

    override fun findAll(): Set<Vet> {
        val vets = HashSet<Vet>()
        vetRepository!!.findAll().forEach(Consumer<Vet> { vets.add(it) })
        return vets
    }

    override fun findById(id: Long?): Vet {
        return vetRepository!!.findById(id!!).orElse(null)
    }

    override fun save(`object`: Vet): Vet {
        return vetRepository!!.save(`object`)
    }

    override fun delete(`object`: Vet) {
        vetRepository!!.delete(`object`)
    }

    override fun deleteById(id: Long) {
        vetRepository!!.deleteById(id)
    }
}
