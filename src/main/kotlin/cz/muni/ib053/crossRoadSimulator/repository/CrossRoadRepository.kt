package cz.muni.ib053.crossRoadSimulator.repository

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CrossRoadRepository : JpaRepository<CrossRoad, Long>
