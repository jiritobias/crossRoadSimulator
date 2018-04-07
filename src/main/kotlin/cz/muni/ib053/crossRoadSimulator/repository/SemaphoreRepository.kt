package cz.muni.ib053.crossRoadSimulator.repository

import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author Jiri Tobias
 *
 *  Semaphore repository.
 */
@Repository
interface SemaphoreRepository : JpaRepository<Semaphore,Long>