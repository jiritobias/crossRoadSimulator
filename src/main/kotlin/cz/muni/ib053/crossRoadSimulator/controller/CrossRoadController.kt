package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.repository.CrossRoadRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/crossroad")
class CrossRoadController(private val crossRoadRepository: CrossRoadRepository) {

    @GetMapping("/all")
    fun getAll(): List<CrossRoad> = crossRoadRepository.findAll()

    @GetMapping("/{id}")
    fun getCrossRoadById(@PathVariable(value = "id") crossRoadId: Long): ResponseEntity<CrossRoad> = crossRoadRepository.findById(crossRoadId)
            .map { crossRoad ->
                ResponseEntity.ok(crossRoad)
            }.orElse(ResponseEntity.notFound().build())


}