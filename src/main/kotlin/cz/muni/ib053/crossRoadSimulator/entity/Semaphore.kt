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

        var color: Color = Color.RED,

        val position: Position = Position.UP,

        @OneToOne(optional = true)
        val sensor: Sensor? = null,

        @OneToOne
        val button: Button = Button(),

        @Column
        @OneToMany(fetch = FetchType.EAGER)
        val relatedSemaphores: MutableSet<Semaphore> = mutableSetOf()


) {
    fun addRelatedSemaphore(semaphore: Semaphore) {
        relatedSemaphores.add(semaphore)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Semaphore

        if (id != other.id) return false
        if (color != other.color) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + color.hashCode()
        result = 31 * result + position.hashCode()
        return result
    }


}

