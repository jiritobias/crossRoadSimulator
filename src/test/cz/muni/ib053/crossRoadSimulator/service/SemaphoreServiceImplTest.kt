package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
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
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author Jiri Tobias
 *
 * Tests for SemaphoreService.
 */
@RunWith(MockitoJUnitRunner.Silent::class)
internal class SemaphoreServiceImplTest {

    @InjectMocks
    lateinit var semaphoreService: SemaphoreServiceImpl

    @Mock
    lateinit var crossRoadRepository: CrossRoadRepository
    @Mock
    lateinit var semaphoreRepository: SemaphoreRepository

    private lateinit var semaphore1: Semaphore
    private lateinit var semaphore2: Semaphore
    private lateinit var semaphore3: Semaphore
    private lateinit var semaphore4: Semaphore
    private lateinit var crossRoad: CrossRoad

    @Before
    fun setUp() {

        semaphore1 = Semaphore(id = 1000L, color = Color.GREEN, position = Position.UP)
        semaphore2 = Semaphore(id = 2000L, color = Color.GREEN, position = Position.DOWN)
        semaphore3 = Semaphore(id = 3000L, color = Color.RED, position = Position.LEFT)
        semaphore4 = Semaphore(id = 4000L, color = Color.RED, position = Position.RIGHT)

        semaphore1.addRelatedSemaphore(semaphore2)
        semaphore2.addRelatedSemaphore(semaphore1)
        semaphore3.addRelatedSemaphore(semaphore4)
        semaphore4.addRelatedSemaphore(semaphore3)

        crossRoad = CrossRoad(semaphores = mutableListOf(semaphore1, semaphore2, semaphore3, semaphore4))

        Mockito.`when`(semaphoreRepository.save(Mockito.any<Semaphore>())).thenReturn(semaphore1)
        Mockito.`when`(semaphoreRepository.saveAll(Mockito.any<List<Semaphore>>())).thenReturn(listOf(semaphore1, semaphore2, semaphore3, semaphore4))
        Mockito.`when`(crossRoadRepository.save(Mockito.any<CrossRoad>())).thenReturn(crossRoad)

        MockitoAnnotations.initMocks(this);
    }

    @Test
    fun changeSemaphoreAndRelated() {


        // Preconditions
        assertThat(crossRoad.semaphores)
                .isNotEmpty()
                .contains(semaphore1, semaphore2, semaphore3, semaphore4)

        assertThat(semaphore1.color)
                .isEqualTo(Color.GREEN)

        assertThat(semaphore1.relatedSemaphores)
                .containsOnly(semaphore2)

        // -- Tests
        var newCrossRoad = semaphoreService.changeSemaphoreAndRelated(semaphore1, crossRoad)
        var semaphores = newCrossRoad.semaphores

        assertByIdAndColor(1000L, Color.RED, semaphores)
        assertByIdAndColor(2000L, Color.RED, semaphores)
        assertByIdAndColor(3000L, Color.GREEN, semaphores)
        assertByIdAndColor(4000L, Color.GREEN, semaphores)

        // -- Reverse again
        newCrossRoad = semaphoreService.changeSemaphoreAndRelated(semaphore1, crossRoad)
        semaphores = newCrossRoad.semaphores

        assertByIdAndColor(1000L, Color.GREEN, semaphores)
        assertByIdAndColor(2000L, Color.GREEN, semaphores)
        assertByIdAndColor(3000L, Color.RED, semaphores)
        assertByIdAndColor(4000L, Color.RED, semaphores)

    }

    fun assertByIdAndColor(id: Long, color: Color, semaphores: List<Semaphore>) {
        semaphores.forEach { semaphore ->
            if (semaphore.id.equals(id)) {
                assertThat(semaphore.color).isEqualTo(color)
            }
        }
    }
}