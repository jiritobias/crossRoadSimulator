package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.DTO.ButtonDTO
import cz.muni.ib053.crossRoadSimulator.DTO.CrossRoadDTO
import cz.muni.ib053.crossRoadSimulator.mapper.DTOMapper
import cz.muni.ib053.crossRoadSimulator.repository.ButtonRepository
import cz.muni.ib053.crossRoadSimulator.service.ButtonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author Jiri Tobias
 *
 * Rest controller for button entity
 */
@RestController
@RequestMapping("/button")
class ButtonController {
    @Autowired
    lateinit var buttonRepository: ButtonRepository
    @Autowired
    lateinit var buttonService: ButtonService
    @Autowired
    lateinit var mapper: DTOMapper

    /**
     * Returns all buttons in repository.
     */
    @GetMapping("/all")
    fun getAll(): List<ButtonDTO> = mapper.mapAsList(buttonRepository.findAll(), ButtonDTO::class.java)

    /**
     * Handling button click action.
     * @param buttonId source button id
     * @return updated crossroad or NotFound
     */
    @PostMapping("/click/{id}")
    fun buttonClick(@PathVariable(value = "id") buttonId: Long): ResponseEntity<CrossRoadDTO> {
        val button = buttonRepository.findById(buttonId)

        return button.map { b ->
            val crossRoad = buttonService.onButtonAction(b)
            ResponseEntity.ok(mapper.map(crossRoad, CrossRoadDTO::class.java))
        }.orElse(ResponseEntity.notFound().build())

    }

}
