package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Semaphore

interface SemaphoreService {

    fun changeSemaphoreAndRelated(semaphore: Semaphore)
}