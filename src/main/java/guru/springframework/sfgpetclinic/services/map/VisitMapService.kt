package guru.springframework.sfgpetclinic.services.map

import guru.springframework.sfgpetclinic.model.Visit
import guru.springframework.sfgpetclinic.services.VisitService

class VisitMapService : AbstractMapService<Visit, Long>(), VisitService {

    override fun findAll(): Set<Visit> {
        return super.findAll()
    }

    override fun findById(id: Long?): Visit {
        return super.findById(id)
    }

    override fun save(visit: Visit): Visit {

        if (visit.pet == null || visit.pet!!.owner == null || visit.pet!!.id == null
                || visit.pet!!.owner!!.id == null) {
            throw RuntimeException("Invalid Visit")
        }

        return super.save(visit)
    }

    override fun delete(`object`: Visit) {
        super.delete(`object`)
    }

    override fun deleteById(id: Long?) {
        super.deleteById(id)
    }
}
