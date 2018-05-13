package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Sensor
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
 * Tests for SensorService.
 */
@RunWith(MockitoJUnitRunner.Silent::class)
internal class SensorServiceImplTest {

    @InjectMocks
    lateinit var sensorService: SensorServiceImpl

    @Mock
    lateinit var crossRoadService: CrossRoadService

    private lateinit var sensor: Sensor

    @Before
    fun setUp() {
        sensor = Sensor(id = 999, active = true)

        Mockito.`when`(crossRoadService.refreshCrossRoadBySensor(sensor)).thenReturn(null)

        MockitoAnnotations.initMocks(this);
    }

    @Test
    fun onSensorAction() {
        // Test, if sensore has inverse value.
        sensorService.onSensorAction(sensor)
        assertThat(sensor.active).isFalse()
    }
}