package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.DTO.CrossRoadDTO
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.mapper.DTOMapper
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/crossroad")
class CrossRoadController(private val crossRoadRepository: CrossRoadRepository,
                          private val mapper: DTOMapper) {

    @GetMapping("/all")
    fun getAll(): List<CrossRoad> = crossRoadRepository.findAll()

    @GetMapping("/{id}")
    fun getCrossRoadById(@PathVariable(value = "id") crossRoadId: Long): ResponseEntity<CrossRoadDTO> = crossRoadRepository.findById(crossRoadId)
            .map { crossRoad ->
                ResponseEntity.ok(mapper.map(crossRoad, CrossRoadDTO::class.java))
            }.orElse(ResponseEntity.notFound().build())


}