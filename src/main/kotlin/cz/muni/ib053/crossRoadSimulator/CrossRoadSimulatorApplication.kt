package cz.muni.ib053.crossRoadSimulator

import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CrossRoadSimulatorApplication

@Autowired
lateinit var defaulData: DefaulData;

fun main(args: Array<String>) {
    runApplication<CrossRoadSimulatorApplication>(*args);
}




