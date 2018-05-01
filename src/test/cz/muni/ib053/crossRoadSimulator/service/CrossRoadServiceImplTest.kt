package cz.muni.ib053.crossRoadSimulator.service

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
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

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    fun refreshCrossRoadBySensor() {
    }

    @Test
    fun refreshCrossRoadByButton() {
    }

    @Test
    fun refreshCrossRoadByTimeout() {
    }
}