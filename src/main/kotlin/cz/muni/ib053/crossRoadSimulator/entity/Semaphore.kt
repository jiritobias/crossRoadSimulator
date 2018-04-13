package cz.muni.ib053.crossRoadSimulator.entity

import cz.muni.ib053.crossRoadSimulator.enums.Color
import cz.muni.ib053.crossRoadSimulator.enums.Position
import javax.persistence.*

@Entity
class Semaphore(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long = 0,

        val color: Color = Color.RED,

        val position: Position = Position.UP,

        @OneToOne
        val sensor: Sensor = Sensor(),

        @OneToOne
        val button: Button = Button()

)

