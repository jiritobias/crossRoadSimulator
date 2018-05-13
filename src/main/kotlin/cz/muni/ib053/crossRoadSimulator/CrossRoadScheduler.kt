package cz.muni.ib053.crossRoadSimulator

import cz.muni.ib053.crossRoadSimulator.service.CrossRoadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.*
import kotlin.concurrent.timerTask

/**
 * @author Jiri Tobias
 * 
 * Scheduler for managing periodic events on cross road.
 */
@Component
class CrossRoadScheduler {
    private var timer: Timer = Timer();
    @Autowired
    lateinit var crossRoadService: CrossRoadService

    private val DELAY_IN_SECONDS: Long = 1000 * 10
    private val THREE_SECOND_DELAY: Long = 1000 * 3

    /**
     * Startafter application start.
     */
    @EventListener(ApplicationReadyEvent::class)
    fun runTimer() {
        timer.scheduleAtFixedRate(timerTask { crossRoadService.refreshCrossRoadsByTimeout() }, DELAY_IN_SECONDS, DELAY_IN_SECONDS)
    }

    /**
     * Run scheduler again after 3s.
     */
    fun runAfterThreeSecondOnce() {
        timer.cancel();
        timer = Timer()
        timer.schedule(timerTask {
            crossRoadService.refreshCrossRoadsByTimeout()
            runTimer()
        }, THREE_SECOND_DELAY)
    }

    /**
     * Cancel timer.
     */
    fun cancel() {
        timer.cancel()
    }

    /**
     * Reinit timer.
     */
    fun reinit(){
        timer = Timer()
        runTimer()
    }
}