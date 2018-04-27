package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.DTO.ButtonDTO
import cz.muni.ib053.crossRoadSimulator.DTO.CrossRoadDTO
import cz.muni.ib053.crossRoadSimulator.mapper.DTOMapper
import cz.muni.ib053.crossRoadSimulator.repository.ButtonRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/button")
class ButtonController(private val buttonRepository: ButtonRepository,
                       private val mapper: DTOMapper) {

    @GetMapping("/all")
    fun getAll(): List<ButtonDTO> = mapper.mapAsList(buttonRepository.findAll(), ButtonDTO::class.java)

    @PostMapping("/click/{id}")
    fun buttonClick(@PathVariable(value = "id") buttonId: Long): ResponseEntity<CrossRoadDTO> {
        val button = buttonRepository.findById(buttonId)

        return ResponseEntity.notFound().build();
    }

}
