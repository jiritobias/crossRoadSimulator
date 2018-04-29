package cz.muni.ib053.crossRoadSimulator.service

import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import cz.muni.ib053.crossRoadSimulator.enums.ActionType
import org.springframework.stereotype.Component
import java.util.*

@Component
class CrossRoadServiceImpl : CrossRoadService {
    override fun refreshCrossRoadBySensor(sensor: Sensor): CrossRoad {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshCrossRoadByButton(button: Button): Button {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshCrossRoadByTimeout(crossRoad: CrossRoad): CrossRoad {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val queue: Queue<Action> = ArrayDeque()


    class Action(
            val actionType: ActionType,
            val long: Long
    )

}