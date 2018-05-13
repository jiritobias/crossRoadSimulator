package cz.muni.ib053.crossRoadSimulator.entity

import javax.persistence.*

/**
 * @author Jiri Tobias
 *
 * Cross road entity.
 */
@Entity
@Table(name = "CROSS_ROAD")
class CrossRoad(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column
        @OneToMany(fetch = FetchType.EAGER)
        var semaphores: List<Semaphore> = arrayListOf()
)