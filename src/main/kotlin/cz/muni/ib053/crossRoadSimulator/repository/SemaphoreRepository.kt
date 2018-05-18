package cz.muni.ib053.crossRoadSimulator.repository

import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
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
interface SemaphoreRepository : JpaRepository<Semaphore, Long>{
    /**
     * Load semaphore by sensor.
     */
    @Query(value = "SELECT * from semaphore where sensor_id = :sensor_id",
            nativeQuery = true)
    fun loadBySensor(@Param(value = "sensor_id") sensor: Long): Semaphore

    /**
     * Load semaphore by button.
     */
    @Query(value = "SELECT * from semaphore where button_id = :button_id",
            nativeQuery = true)
    fun loadByButton(@Param(value = "button_id") button: Long): Semaphore
}