package cz.muni.ib053.crossRoadSimulator

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.enums.Color
import cz.muni.ib053.crossRoadSimulator.repository.ButtonRepository
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class DefaulData(private val semaphoreRepository: SemaphoreRepository,
                 private var buttonRepository: ButtonRepository) {

    @EventListener(ApplicationReadyEvent::class)
    fun generate() {
        val semaphore1 = Semaphore(1, Color.GREEN)
        val semaphore2 = Semaphore(2, Color.RED)
        val semaphore3 = Semaphore(3, Color.RED)
        val semaphore4 = Semaphore(4, Color.GREEN)

        semaphoreRepository.save(semaphore1)
        semaphoreRepository.save(semaphore2)
        semaphoreRepository.save(semaphore3)
        semaphoreRepository.save(semaphore4)

        val button = Button(0, semaphore1)
        val button1 = Button(1, semaphore2)
        val button2 = Button(2, semaphore3)
        val button3 = Button(3, semaphore4)

        buttonRepository.saveAll(arrayListOf(button, button1, button2, button3))
    }
}