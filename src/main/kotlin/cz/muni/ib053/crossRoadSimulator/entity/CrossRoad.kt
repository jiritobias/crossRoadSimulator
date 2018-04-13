package cz.muni.ib053.crossRoadSimulator.entity

import javax.persistence.*

@Entity
class CrossRoad (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @OneToMany(fetch = FetchType.LAZY)
        val semaphores: List<Semaphore> = arrayListOf()
)