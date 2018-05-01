package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore

/**
 * @author Jiri Tobias
 *
 * Service for semaphore
 */
interface SemaphoreService {
    /**
     * Change current semaphore state and related semaphores on crossroad
     *
     * @param semaphore current semaphore
     * @param crossRoad current crossroad
     * @return updated crossroad
     */
    fun changeSemaphoreAndRelated(semaphore: Semaphore, crossRoad: CrossRoad): CrossRoad

    /**
     * Returns non related semaphores on cross road
     *
     * @param semaphore current semaphore
     * @param crossRoad current crossroad
     * @return list of non related semaphores
     */
    fun getNonRelatedSemaphores(semaphore: Semaphore, crossRoad: CrossRoad): List<Semaphore>
}