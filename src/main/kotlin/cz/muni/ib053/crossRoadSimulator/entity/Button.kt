package cz.muni.ib053.crossRoadSimulator.entity

import javax.persistence.*

@Entity
class Button(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0
)
