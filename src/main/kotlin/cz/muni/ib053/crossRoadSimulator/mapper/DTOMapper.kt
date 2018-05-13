package cz.muni.ib053.crossRoadSimulator.mapper

import cz.muni.ib053.crossRoadSimulator.DTO.ButtonDTO
import cz.muni.ib053.crossRoadSimulator.DTO.CrossRoadDTO
import cz.muni.ib053.crossRoadSimulator.DTO.SemaphoreDTO
import cz.muni.ib053.crossRoadSimulator.DTO.SensorDTO
import cz.muni.ib053.crossRoadSimulator.entity.Button
import cz.muni.ib053.crossRoadSimulator.entity.CrossRoad
import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.entity.Sensor
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.ConfigurableMapper
import org.springframework.stereotype.Component

/**
 * @author Jiri Tobias
 *
 * Mapper for mapping between DTOs and entities.
 */
@Component
class DTOMapper : ConfigurableMapper(true) {
    override fun configure(factory: MapperFactory) {
        super.configure(factory)

        factory.classMap(ButtonDTO::class.java, Button::class.java).byDefault().register();
        factory.classMap(SemaphoreDTO::class.java, Semaphore::class.java).byDefault().register();
        factory.classMap(SensorDTO::class.java, Sensor::class.java).byDefault().register();
        factory.classMap(CrossRoadDTO::class.java, CrossRoad::class.java).byDefault().register();

    }
}