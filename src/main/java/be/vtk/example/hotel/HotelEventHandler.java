package be.vtk.example.hotel;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.context.ApplicationEvent;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@RepositoryEventHandler(Hotel.class)
@Component
public class HotelEventHandler {
    private static final Logger LOGGER = getLogger(HotelEventHandler.class);

    private final CounterService counterService;
    @Autowired
    public HotelEventHandler(CounterService counterService) {
        this.counterService = counterService;
    }

    @HandleBeforeSave
    public void handleHotel(Hotel h) {
        LOGGER.info("post triggerd");
        counterService.increment("services.hotel.create");
    }

    @HandleBeforeDelete
    public void handleDeleteHotel(Hotel h) {
        LOGGER.info("delete triggered");
        counterService.increment("services.hotel.delete");
    }
}
