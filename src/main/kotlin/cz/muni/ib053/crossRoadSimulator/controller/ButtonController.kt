package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.repository.ButtonRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/button")
class ButtonController(private val buttonRepository: ButtonRepository) {

    @GetMapping("/all")
    fun getAll(): List<Button> = buttonRepository.findAll()

    @PostMapping("/click/{id}")
    fun buttonClick(@PathVariable(value = "id") buttonId: Long) : ResponseEntity<CrossRoad>? {
        val button = buttonRepository.findById(buttonId)
        return null // TODO
    }

}
