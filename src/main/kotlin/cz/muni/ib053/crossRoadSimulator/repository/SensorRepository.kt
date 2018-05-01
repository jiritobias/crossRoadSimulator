package cz.muni.ib053.crossRoadSimulator.repository

import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

/**
 * @author Jiri Tobias
 *
 * Repository for Sensor entity.
 */
@Repository
interface SensorRepository : JpaRepository<Sensor, Long>