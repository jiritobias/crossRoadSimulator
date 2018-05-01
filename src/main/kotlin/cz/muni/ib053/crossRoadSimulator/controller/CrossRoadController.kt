package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.DTO.CrossRoadDTO
import cz.muni.ib053.crossRoadSimulator.mapper.DTOMapper
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/crossroad")
class CrossRoadController {
    @Autowired
    lateinit var crossRoadRepository: CrossRoadRepository
    @Autowired
    lateinit var mapper: DTOMapper

    @GetMapping("/all")
    fun getAll(): List<CrossRoadDTO> = mapper.mapAsList(crossRoadRepository.findAll(), CrossRoadDTO::class.java)

    @GetMapping("/{id}")
    fun getCrossRoadById(@PathVariable(value = "id") crossRoadId: Long): ResponseEntity<CrossRoadDTO> = crossRoadRepository.findById(crossRoadId)
            .map { crossRoad ->
                ResponseEntity.ok(mapper.map(crossRoad, CrossRoadDTO::class.java))
            }.orElse(ResponseEntity.notFound().build())


}