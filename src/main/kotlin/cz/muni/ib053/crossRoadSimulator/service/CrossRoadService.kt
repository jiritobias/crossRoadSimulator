package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Sensor

interface CrossRoadService {
    fun refreshCrossRoadByTimeout(crossRoad: CrossRoad): CrossRoad

    fun refreshCrossRoadBySensor(sensor: Sensor): CrossRoad;

    fun refreshCrossRoadByButton(button: Button): Button;
}