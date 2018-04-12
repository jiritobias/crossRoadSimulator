package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import cz.muni.ib053.crossRoadSimulator.repository.SensorRepository
import cz.muni.ib053.crossRoadSimulator.service.SensorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sensor")
class SensorController(private val sensorRepository: SensorRepository,
                       private val sensorService: SensorService) {


    @GetMapping("/all")
    fun getAll(): List<Sensor> = sensorRepository.findAll();

    @PostMapping("/action/{id}")
    fun onSensorAction(@PathVariable(value = "id") sensorId: Long): ResponseEntity<CrossRoad>? {
        return sensorRepository.findById(sensorId)
                .map { sensor -> ResponseEntity.ok(sensorService.onSensorAction(sensor)) }
                .orElse(ResponseEntity.notFound().build())
    }
}