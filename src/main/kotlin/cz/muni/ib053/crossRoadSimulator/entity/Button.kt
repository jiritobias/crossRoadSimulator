package cz.muni.ib053.crossRoadSimulator.entity

import javax.persistence.*

/**
 * @author Jiri Tobias
 *
 * Button entity.
 */
@Entity
@Table(name = "BUTTON")
class Button(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0
)
