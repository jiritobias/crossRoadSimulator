package cz.muni.ib053.crossRoadSimulator.repository

import cz.muni.ib053.crossRoadSimulator.entity.Button
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author Jiri Tobias
 *
 * Repository for Button entity.
 */
@Repository
interface ButtonRepository : JpaRepository<Button, Long>