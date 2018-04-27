package cz.muni.ib053.crossRoadSimulator.entity

import javax.persistence.*

/**
 * Cross road entity.
 */
@Entity
@Table(name = "CROSS_ROAD")
class CrossRoad(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column
        @ElementCollection(targetClass = Semaphore::class)
        val semaphores: List<Semaphore> = arrayListOf()
)