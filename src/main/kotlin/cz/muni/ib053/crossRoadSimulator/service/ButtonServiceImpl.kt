package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ButtonServiceImpl : ButtonService {
    @Autowired
    lateinit var crossRoadService: CrossRoadService

    override fun onButtonAction(button: Button): CrossRoad {
        return crossRoadService.refreshCrossRoadByButton(button)
    }
}