package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/semaphore")
class SemaphoreController(private val semaphoreRepository: SemaphoreRepository) {

    @GetMapping("/all")
    fun getAll(): List<Semaphore> = semaphoreRepository.findAll()


}
