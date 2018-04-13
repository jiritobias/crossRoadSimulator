package cz.muni.ib053.crossRoadSimulator

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import cz.muni.ib053.crossRoadSimulator.enums.Color
import cz.muni.ib053.crossRoadSimulator.enums.Position
import cz.muni.ib053.crossRoadSimulator.repository.ButtonRepository
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import cz.muni.ib053.crossRoadSimulator.repository.SensorRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.stream.Collector
import java.util.stream.Collectors
import java.util.stream.Stream

@Component
class DefaulData(private val semaphoreRepository: SemaphoreRepository,
                 private val buttonRepository: ButtonRepository,
                 private val crossRoadRepository: CrossRoadRepository,
                 private val sensorRepository: SensorRepository) {

    @EventListener(ApplicationReadyEvent::class)
    fun generate() {
        if (crossRoadRepository.findAll().isEmpty()) {

            val sensor1 = Sensor()
            val sensor2 = Sensor()
            val sensor3 = Sensor()
            val sensor4 = Sensor()

            val sensors = mutableListOf(sensor1, sensor2, sensor3, sensor4)
            sensorRepository.saveAll(sensors)


            val button1 = Button()
            val button2 = Button()
            val button3 = Button()
            val button4 = Button()

            val buttons = mutableListOf(button1, button2, button3, button4)
            buttonRepository.saveAll(buttons)

            val semaphore1 = Semaphore(1, Color.GREEN, Position.UP, sensor1, button1)
            val semaphore2 = Semaphore(2, Color.RED, Position.DOWN, sensor2, button2)
            val semaphore3 = Semaphore(3, Color.RED, Position.LEFT, sensor3, button3)
            val semaphore4 = Semaphore(4, Color.GREEN, Position.RIGHT, sensor4, button4)

            val semaphores = mutableListOf(semaphore1, semaphore2, semaphore3, semaphore4)
            semaphoreRepository.saveAll(semaphores)

            val crossRoad = CrossRoad(semaphores =  semaphores)

            crossRoadRepository.save(crossRoad)
        }

    }
}