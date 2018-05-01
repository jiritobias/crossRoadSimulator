package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.DTO.SemaphoreDTO
import cz.muni.ib053.crossRoadSimulator.mapper.DTOMapper
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/semaphore")
class SemaphoreController {
    @Autowired
    lateinit var semaphoreRepository: SemaphoreRepository
    @Autowired
    lateinit var mapper: DTOMapper

    @GetMapping("/all")
    fun getAll(): List<SemaphoreDTO> = mapper.mapAsList(semaphoreRepository.findAll(), SemaphoreDTO::class.java)


}
