package be.axxes.example.hotel;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@RepositoryEventHandler
@Component
public class HotelEventHandler {
    private static final Logger LOGGER = getLogger(HotelEventHandler.class);

    private final MeterRegistry registry;

    @Autowired
    public HotelEventHandler(MeterRegistry registry) {
        this.registry = registry;
    }

    @HandleBeforeCreate
    public void handleHotel(Hotel h) {
        LOGGER.info("post triggerd");
        registry.counter("services.hotel.create").increment();
    }

    @HandleBeforeDelete
    public void handleDeleteHotel(Hotel h) {
        LOGGER.info("delete triggered");
        registry.counter("services.hotel.delete").increment();
    }
}
