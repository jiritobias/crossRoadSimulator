package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad

/**
 * @author Jiri Tobias
 *
 * Service for button.
 */
interface ButtonService {

    /**
     * Action after button click
     *
     * @param source button
     */
    fun onButtonAction(button: Button): CrossRoad
}