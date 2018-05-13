package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Sensor

/**
 * @author Jiri Tobias
 *
 * Service for CrossRoad.
 */
interface CrossRoadService {
    /**
     * Refresh all crossroads by timer event.
     * Time is used for periodic changing of cross roads.
     */
    fun refreshCrossRoadsByTimeout()

    /**
     * Refresh cross road by sensor action.
     *
     * @param sensor source sensor
     * @return updated crossroad
     */
    fun refreshCrossRoadBySensor(sensor: Sensor): CrossRoad;

    /**
     * Refresh cross road by button action
     *
     * @param button source button
     * @return updated crossroad
     */
    fun refreshCrossRoadByButton(button: Button): CrossRoad;
}