package cz.muni.ib053.crossRoadSimulator.entity

import cz.muni.ib053.crossRoadSimulator.enums.Color
import cz.muni.ib053.crossRoadSimulator.enums.Position
import javax.persistence.*

/**
 * Semaphore entity
 */
@Entity
@Table(name = "SEMAPHORE")
class Semaphore(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long = 0,

        val color: Color = Color.RED,

        val position: Position = Position.UP,

        @OneToOne(optional = true, fetch = FetchType.LAZY)
        val sensor: Sensor? = null,

        @OneToOne
        val button: Button = Button(),

        @Column
        @ElementCollection(targetClass=Semaphore::class)
        val relatedSemaphores: MutableSet<Semaphore> = mutableSetOf()


) {
    fun addRelatedSemaphore(semaphore: Semaphore) {
        relatedSemaphores.add(semaphore)
    }
}

