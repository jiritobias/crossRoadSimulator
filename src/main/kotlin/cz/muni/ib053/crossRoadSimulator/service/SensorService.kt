package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Sensor

/**
 * @author Jiri Tobias
 *
 * Service for sensor.
 */
interface SensorService {

    /**
     * Action after sensor change
     *
     * @param source sensor
     * @return CrossRoad in actual state.
     */
    fun onSensorAction(sensor: Sensor): CrossRoad
}