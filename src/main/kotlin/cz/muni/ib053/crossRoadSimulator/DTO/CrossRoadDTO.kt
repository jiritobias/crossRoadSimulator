package cz.muni.ib053.crossRoadSimulator.DTO

/**
 * @author Jiri Tobias
 *
 * DTO for CrossRoad entity
 */
data class CrossRoadDTO(
        val id: Long,
        val semaphores: List<SemaphoreDTO>
)