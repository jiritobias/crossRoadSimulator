package cz.muni.ib053.crossRoadSimulator.entity

import javax.persistence.*

/**
 * @author Jiri Tobias
 *
 * Sensor entity.
 */
@Entity
@Table(name = "SENSOR")
class Sensor (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var active: Boolean = false
)