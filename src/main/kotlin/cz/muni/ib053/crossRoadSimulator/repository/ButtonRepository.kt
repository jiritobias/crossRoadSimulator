package cz.muni.ib053.crossRoadSimulator.repository

import cz.muni.ib053.crossRoadSimulator.entity.Button
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ButtonRepository : JpaRepository<Button, Long>