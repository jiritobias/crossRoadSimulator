package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.CrossRoadSimulatorApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(CrossRoadSimulatorApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class CrossRoadServiceImplTest {
    @Autowired
    lateinit var crossRoadService: CrossRoadService

    @Before
    fun setUp() {
        assertThat(crossRoadService).isNotNull()
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