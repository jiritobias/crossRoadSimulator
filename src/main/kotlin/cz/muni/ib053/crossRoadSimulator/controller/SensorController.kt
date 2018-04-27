package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.DTO.CrossRoadDTO
import cz.muni.ib053.crossRoadSimulator.DTO.SensorDTO
import cz.muni.ib053.crossRoadSimulator.mapper.DTOMapper
import cz.muni.ib053.crossRoadSimulator.repository.SensorRepository
import cz.muni.ib053.crossRoadSimulator.service.SensorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sensor")
class SensorController(private val sensorRepository: SensorRepository,
                       private val sensorService: SensorService,
                       private val mapper: DTOMapper) {


    @GetMapping("/all")
    fun getAll(): List<SensorDTO> = mapper.mapAsList(sensorRepository.findAll(), SensorDTO::class.java);

    @PostMapping("/action/{id}")
    fun onSensorAction(@PathVariable(value = "id") sensorId: Long): ResponseEntity<CrossRoadDTO> {
        return sensorRepository.findById(sensorId)
                .map { sensor -> ResponseEntity.ok(mapper.map(sensorService.onSensorAction(sensor), CrossRoadDTO::class.java)) }
                .orElse(ResponseEntity.notFound().build())
    }
}