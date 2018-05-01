package cz.muni.ib053.crossRoadSimulator.repository

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CrossRoadRepository : JpaRepository<CrossRoad, Long> {

    @Query(value = "SELECT * from cross_road join cross_road_semaphores on cross_road.id = cross_road_semaphores.cross_road_id where semaphores_id = :semaphore_id",
            nativeQuery = true)
    fun loadBySemaphore(@Param("semaphore_id") semaphore: Long): CrossRoad

    @Query(value = "SELECT * from cross_road join cross_road_semaphores on cross_road.id = cross_road_semaphores.cross_road_id join semaphore on semaphores_id = semaphore.id " +
            "where button_id = :button_id",
            nativeQuery = true)
    fun loadByButton(@Param("button_id") button: Long): CrossRoad

    @Query(value = "SELECT * from cross_road join cross_road_semaphores on cross_road.id = cross_road_semaphores.cross_road_id join semaphore on semaphores_id = semaphore.id " +
            "where sensor_id = :sensor_id",
            nativeQuery = true)
    fun loadBySensor(@Param(value = "sensor_id") sensor: Long): CrossRoad
}
