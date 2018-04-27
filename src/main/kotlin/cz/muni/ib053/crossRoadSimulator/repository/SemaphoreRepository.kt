package cz.muni.ib053.crossRoadSimulator.repository

import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * @author Jiri Tobias
 *
 *  Semaphore repository.
 */
@Repository
interface SemaphoreRepository : JpaRepository<Semaphore, Long>