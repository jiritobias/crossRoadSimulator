package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import org.springframework.data.jpa.repository.Query

interface SensorService {

    /**
     * @return CrossRoad in actual state.
     */
    fun onSensorAction(sensor: Sensor): CrossRoad
}