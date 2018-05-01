package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import cz.muni.ib053.crossRoadSimulator.repository.SensorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SensorServiceImpl : SensorService {
    @Autowired
    lateinit var sensorRepository: SensorRepository
    @Autowired
    lateinit var crossRoadService: CrossRoadService

    override fun onSensorAction(sensor: Sensor): CrossRoad {
        synchronized(this) {
            inverseSensoreActiveValueAndSave(sensor)
            return crossRoadService.refreshCrossRoadBySensor(sensor)
        }
    }


    private fun inverseSensoreActiveValueAndSave(sensor: Sensor) {
        sensor.active = sensor.active.not()
        sensorRepository.save(sensor)
    }

}