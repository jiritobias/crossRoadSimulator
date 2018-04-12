package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.data.domain.Example
import org.springframework.stereotype.Component
import java.util.function.Predicate

@Component
class SensorServiceImpl(private val semaphoreRepository: SemaphoreRepository,
                        private val crossRoadRepository: CrossRoadRepository) : SensorService {

    override fun onSensorAction(sensor: Sensor): CrossRoad {
        var semaphore = semaphoreRepository.getBySensor(sensor)


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}