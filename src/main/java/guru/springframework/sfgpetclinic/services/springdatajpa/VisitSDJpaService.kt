package guru.springframework.sfgpetclinic.services.springdatajpa

import guru.springframework.sfgpetclinic.model.Visit
import guru.springframework.sfgpetclinic.repositories.VisitRepository
import guru.springframework.sfgpetclinic.services.VisitService

import java.util.HashSet
import java.util.function.Consumer

class VisitSDJpaService(private val visitRepository: VisitRepository) : VisitService {

    override fun findAll(): Set<Visit> {
        val visits = HashSet<Visit>()
        visitRepository.findAll().forEach(Consumer<Visit> { visits.add(it) })
        return visits
    }

    override fun findById(id: Long?): Visit {
        return visitRepository.findById(id!!).orElse(null)
    }

    override fun save(`object`: Visit): Visit {
        return visitRepository.save(`object`)
    }

    override fun delete(`object`: Visit) {
        visitRepository.delete(`object`)
    }

    override fun deleteById(id: Long) {
        visitRepository.deleteById(id)
    }
}
