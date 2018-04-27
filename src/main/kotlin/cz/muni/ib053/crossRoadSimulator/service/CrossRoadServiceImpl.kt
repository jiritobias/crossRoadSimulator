package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.enums.ActionType
import org.springframework.stereotype.Component
import java.util.*

@Component
class CrossRoadServiceImpl : CrossRoadService {

    private val queue: Queue<Action> = ArrayDeque()


    class Action(
            val actionType: ActionType,
            val long: Long
    )

}