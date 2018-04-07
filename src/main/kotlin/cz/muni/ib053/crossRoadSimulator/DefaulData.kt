package cz.muni.ib053.crossRoadSimulator

import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.enums.Color
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class DefaulData(private val semaphoreRepository: SemaphoreRepository) {

    @EventListener(ApplicationReadyEvent::class)
    fun generate() {
        semaphoreRepository.save(Semaphore(1, Color.GREEN))
        semaphoreRepository.save(Semaphore(2, Color.RED))
        semaphoreRepository.save(Semaphore(3, Color.RED))
        semaphoreRepository.save(Semaphore(4, Color.GREEN))
    }
}