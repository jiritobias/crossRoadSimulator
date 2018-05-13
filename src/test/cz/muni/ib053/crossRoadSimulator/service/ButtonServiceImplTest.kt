package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
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
 * Tests for ButtonService.
 */
@RunWith(MockitoJUnitRunner.Silent::class)
internal class ButtonServiceImplTest {

    @InjectMocks
    lateinit var buttonService: ButtonServiceImpl

    @Mock
    lateinit var crossRoadService: CrossRoadService

    lateinit var button: Button
    lateinit var crossRoad: CrossRoad

    @Before
    fun setUp() {
        button = Button(666)
        crossRoad = CrossRoad(semaphores = listOf(Semaphore(button = button)))

        Mockito.`when`(crossRoadService.refreshCrossRoadByButton(button)).thenReturn(crossRoad)
        MockitoAnnotations.initMocks(this);
    }

    @Test
    fun onButtonAction() {
        buttonService.onButtonAction(button)
        val semaphore = crossRoad.semaphores.first()

        assertThat(crossRoad).isNotNull()
        assertThat(semaphore.button)
                .isEqualTo(button)

    }
}