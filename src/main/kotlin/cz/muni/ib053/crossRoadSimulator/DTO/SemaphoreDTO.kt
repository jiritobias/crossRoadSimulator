package cz.muni.ib053.crossRoadSimulator.DTO

import cz.muni.ib053.crossRoadSimulator.enums.Color
import cz.muni.ib053.crossRoadSimulator.enums.Position

/**
 * @author Jiri Tobias
 *
 * DTO for Semaphore entity
 */
data class SemaphoreDTO(
        val id: Long,
        val color: Color,
        val position: Position,
        val sensor: SensorDTO?,
        val button: ButtonDTO
)