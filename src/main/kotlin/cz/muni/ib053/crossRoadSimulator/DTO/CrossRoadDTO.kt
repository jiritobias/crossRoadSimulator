package cz.muni.ib053.crossRoadSimulator.DTO

data class CrossRoadDTO(
        val id: Long,
        val semaphores: List<SemaphoreDTO>
)