package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SemaphoreServiceImpl : SemaphoreService {

    @Autowired
    lateinit var crossRoadRepository: CrossRoadRepository
    @Autowired
    lateinit var semaphoreRepository: SemaphoreRepository

    override fun getNonRelatedSemaphores(semaphore: Semaphore, crossRoad: CrossRoad): List<Semaphore> {
        val semaphores = crossRoad.semaphores
        val nonRelatedSemaphores = mutableListOf<Semaphore>()

        semaphores.forEach({ s ->
            if (!semaphore.relatedSemaphores.contains(s) && !semaphore.equals(s)) {
                nonRelatedSemaphores.add(s)
            }
        })

        return nonRelatedSemaphores
    }

    override fun changeSemaphoreAndRelated(semaphore: Semaphore, crossRoad: CrossRoad): CrossRoad {
        val relatedSemaphores = semaphore.relatedSemaphores
        val semaphoreColor = semaphore.color
        val nonRelatedSemaphores = getNonRelatedSemaphores(semaphore, crossRoad)

        // Inverse color for non related semaphores
        nonRelatedSemaphores.forEach { s ->
            s.color = s.color.inverse()
        }

        // Inverse related semaphore
        relatedSemaphores.forEach { relatedSemaphore ->
            relatedSemaphore.color = semaphoreColor.inverse()
        }
        // Inverse the semaphore
        semaphore.color = semaphoreColor.inverse();

        // Related semaphores with current semaphore + notRelated, but changed
        val allSemaphores = relatedSemaphores.toList() + semaphore + nonRelatedSemaphores;
        semaphoreRepository.saveAll(allSemaphores)

        // Set and save
        crossRoad.semaphores = allSemaphores
        crossRoadRepository.save(crossRoad)

        return crossRoad
    }
}