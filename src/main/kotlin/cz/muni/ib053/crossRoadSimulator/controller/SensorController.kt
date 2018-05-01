package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.DTO.CrossRoadDTO
import cz.muni.ib053.crossRoadSimulator.DTO.SensorDTO
import cz.muni.ib053.crossRoadSimulator.mapper.DTOMapper
import cz.muni.ib053.crossRoadSimulator.repository.SensorRepository
import cz.muni.ib053.crossRoadSimulator.service.SensorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * @author Jiri Tobias
 *
 * Rest controller for sensor entity
 */
@RestController
@RequestMapping("/sensor")
class SensorController {
    @Autowired
    lateinit var sensorRepository: SensorRepository
    @Autowired
    lateinit var sensorService: SensorService
    @Autowired
    lateinit var mapper: DTOMapper


    /**
     * Returns all sensors in repository.
     */
    @GetMapping("/all")
    fun getAll(): List<SensorDTO> = mapper.mapAsList(sensorRepository.findAll(), SensorDTO::class.java);

    /**
     * Handles sensor action
     * @param sensorId id of source sensor
     * @return updated crossroad or NotFound
     */
    @PostMapping("/action/{id}")
    fun onSensorAction(@PathVariable(value = "id") sensorId: Long): ResponseEntity<CrossRoadDTO> {
        return sensorRepository.findById(sensorId)
                .map { sensor ->
                    ResponseEntity.ok(
                            mapper.map(sensorService.onSensorAction(sensor), CrossRoadDTO::class.java))
                }
                .orElse(ResponseEntity.notFound().build())
    }
}