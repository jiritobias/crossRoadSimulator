package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.CrossRoadTimer
import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import cz.muni.ib053.crossRoadSimulator.enums.Color
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.concurrent.timerTask

@Service
class CrossRoadServiceImpl : CrossRoadService {
    @Autowired
    lateinit var crossRoadRepository: CrossRoadRepository
    @Autowired
    lateinit var semaphoreRepository: SemaphoreRepository
    @Autowired
    lateinit var semaphoreService: SemaphoreService
    @Autowired
    lateinit var crossRoadTimer: CrossRoadTimer


    override fun refreshCrossRoadBySensor(sensor: Sensor): CrossRoad {
        val crossRoad = crossRoadRepository.loadBySensor(sensor.id)

        if (sensor.active) {
            val semaphore = semaphoreRepository.loadBySensor(sensor.id)
            if (semaphore.color == Color.RED) {
                refreshTimer()
            }
            // else do nothing, color is GREEN and sensor is active

        }
        return crossRoad
    }

    private fun refreshTimer() {
        // Schedule new timer
        crossRoadTimer.runAfterSixSecondOnce()

    }

    override fun refreshCrossRoadByButton(button: Button): CrossRoad {
        Timer().schedule(timerTask {
            refreshCrossRoadByButtonTimer(button)
        }, 1000 * 3)

        return crossRoadRepository.loadByButton(button.id)
    }

    private fun refreshCrossRoadByButtonTimer(button: Button) {
        val crossRoad = crossRoadRepository.loadByButton(button.id)
        val semaphore = semaphoreRepository.loadByButton(button.id)
        val nonRelatedSemaphores = semaphoreService.getNonRelatedSemaphores(semaphore, crossRoad)

        if (semaphore.color == Color.RED) {
            if (hasActiveSensor(nonRelatedSemaphores)) {
                forceScheduleButtonAction(button)
            } else {
                semaphoreService.changeSemaphoreAndRelated(semaphore, crossRoad)
            }
        }
        // else, nothing to do.. semaphore has already GREEN COLOR
    }

    private fun forceScheduleButtonAction(button: Button) {
        // Cancel all actions
        crossRoadTimer.cancel()
        Timer().schedule(timerTask {
            val crossRoad = crossRoadRepository.loadByButton(button.id)
            val semaphore = semaphoreRepository.loadByButton(button.id)
            semaphoreService.changeSemaphoreAndRelated(semaphore, crossRoad)
            crossRoadTimer.reinit()
        }, 1000 * 5)
    }

    private fun hasActiveSensor(semaphores: List<Semaphore>): Boolean {
        for (semaphore in semaphores) {
            semaphore.sensor?.let {
                if (it.active) {
                    return true
                }
            }

        }
        return false
    }

    override fun refreshCrossRoadsByTimeout() {
        crossRoadRepository.findAll()
                .forEach({ crossRoad -> refreshCrossRoad(crossRoad) })

    }

    private fun refreshCrossRoad(crossRoad: CrossRoad) {
        val semaphores = crossRoad.semaphores

        val semaphoreWithActiveSensor = getSemaphoreWithActiveSensor(semaphores)
        if (semaphoreWithActiveSensor != null) {
            if (semaphoreWithActiveSensor.color == Color.RED) {
                refreshCrossRoadBySemaphoreWithActiveSensor(semaphoreWithActiveSensor)
            }
            // else do nothing, COLOR is GREEN and active sensore, waiting to inactive sensor

        } else {
            val reverseSemaphores = reverseSemaphores(semaphores)
            crossRoad.semaphores = reverseSemaphores
            crossRoadRepository.save(crossRoad)
        }
    }

    private fun reverseSemaphores(semaphores: List<Semaphore>): List<Semaphore> {
        semaphores.forEach({ semaphore ->
            semaphore.color = semaphore.color.inverse()
            semaphoreRepository.save(semaphore)
        })
        return semaphores
    }

    private fun refreshCrossRoadBySemaphoreWithActiveSensor(semaphoreWithActiveSensor: Semaphore) {
        val crossRoad = crossRoadRepository.loadBySemaphore(semaphoreWithActiveSensor.id)
        semaphoreService.changeSemaphoreAndRelated(semaphoreWithActiveSensor, crossRoad)
    }

    private fun getSemaphoreWithActiveSensor(semaphores: List<Semaphore>): Semaphore? {
        for (semaphore in semaphores) {
            val sensor = semaphore.sensor
            if (sensor != null && sensor.active) {
                return semaphore
            }
        }
        return null
    }

}