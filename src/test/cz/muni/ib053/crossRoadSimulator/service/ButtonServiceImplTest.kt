package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.CrossRoadSimulatorApplication
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(CrossRoadSimulatorApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class ButtonServiceImplTest {

    @Test
    fun onButtonAction() {
    }
}