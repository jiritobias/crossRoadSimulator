package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.repository.ButtonRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/button")
class ButtonController(private var buttonRepository: ButtonRepository) {

    @GetMapping("/all")
    fun getAll(): List<Button> = buttonRepository.findAll()


}
