package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import cz.muni.ib053.crossRoadSimulator.enums.Color
import cz.muni.ib053.crossRoadSimulator.enums.Position
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author Jiri Tobias
 *
 * Tests for CrossRoadService.
 */
@RunWith(MockitoJUnitRunner.Silent::class)
internal class CrossRoadServiceImplTest {

    @InjectMocks
    lateinit var crossRoadService: CrossRoadServiceImpl
    @Mock
    lateinit var crossRoadRepository: CrossRoadRepository
    @Mock
    lateinit var semaphoreRepository: SemaphoreRepository

    lateinit var sensor: Sensor
    lateinit var sensor1: Sensor
    lateinit var button: Button
    lateinit var button1: Button
    lateinit var semaphore: Semaphore
    lateinit var semaphore1: Semaphore
    lateinit var crossRoad: CrossRoad

    @Before
    fun setUp() {
        sensor = Sensor(88, false)
        sensor1 = Sensor(89, false)
        button = Button(98)
        button1 = Button(99)
        semaphore = Semaphore(id = 100, color = Color.RED, position = Position.UP, sensor = sensor, button = button)
        semaphore1 = Semaphore(id = 101, color = Color.GREEN, position = Position.DOWN, sensor = sensor1, button = button1)
        crossRoad = CrossRoad(999, semaphores = listOf(semaphore, semaphore1))

        Mockito.`when`(crossRoadRepository.save(Mockito.any<CrossRoad>())).thenReturn(crossRoad)
        Mockito.`when`(semaphoreRepository.save(Mockito.any<Semaphore>())).thenReturn(semaphore)

    }


    @Test
    fun refreshCrossRoad() {
        crossRoadService.refreshCrossRoad(crossRoad)

        val semaphores = crossRoad.semaphores
        assertThat(semaphores.size)
                .isEqualTo(2)

        assertThat(semaphores[0].id).isEqualTo(100L)
        assertThat(semaphores[0].color).isEqualTo(Color.GREEN)

        assertThat(semaphores[1].id).isEqualTo(101L)
        assertThat(semaphores[1].color).isEqualTo(Color.RED)

    }
}