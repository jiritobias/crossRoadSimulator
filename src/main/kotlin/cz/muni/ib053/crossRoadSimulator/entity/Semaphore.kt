package cz.muni.ib053.crossRoadSimulator.entity

import cz.muni.ib053.crossRoadSimulator.enums.Color
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Semaphore(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        val color: Color = Color.RED
)

