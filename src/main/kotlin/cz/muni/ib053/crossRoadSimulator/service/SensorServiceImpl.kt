package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import cz.muni.ib053.crossRoadSimulator.repository.SensorRepository
import org.springframework.stereotype.Component

@Component
class SensorServiceImpl(private val sensorRepository: SensorRepository,
                        private val crossRoadRepository: CrossRoadRepository) : SensorService {

    override fun onSensorAction(sensor: Sensor): CrossRoad {
        synchronized(this) {
            inverseSensoreActiveValueAndSave(sensor)
            return crossRoadRepository.findAll().first(); TODO()
        }
    }


    private fun inverseSensoreActiveValueAndSave(sensor: Sensor) {
        sensor.active = sensor.active.not()
        sensorRepository.save(sensor)
    }

}