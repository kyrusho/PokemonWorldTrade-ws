package org.nabihi.pokemonworldws.eventssubdomain.presentationlayer;

import org.nabihi.pokemonworldws.eventssubdomain.businesslayer.EventService;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<EventResponseModel>> getAllEvents(){
        List<EventResponseModel> eventResponseModelList = eventService.getAllEvents();

        return ResponseEntity.status(HttpStatus.OK).body(eventResponseModelList);
    }

    @GetMapping(value = "{eventId}", produces = "application/json")
    public  ResponseEntity<EventResponseModel> getEventByEventId(@PathVariable String eventId){
        EventResponseModel eventResponseModel = eventService.getEventByEventId(eventId);

        return ResponseEntity.status(HttpStatus.OK).body(eventResponseModel);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<EventResponseModel> addEvent(@RequestBody EventRequestModel eventRequestModel){
        EventResponseModel eventResponseModel = eventService.addEvent(eventRequestModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventResponseModel);
    }

    @PutMapping(produces = "application/json", value = "{eventId}")
    public ResponseEntity<EventResponseModel> updateEvent(@RequestBody EventRequestModel eventRequestModel,
                                                          @PathVariable String eventId){
        EventResponseModel eventResponseModel = eventService.updateEvent(eventRequestModel, eventId);

        return ResponseEntity.status(HttpStatus.OK).body(eventResponseModel);
    }

    @DeleteMapping(produces = "application/json", value = "{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String eventId){
        eventService.deleteEvent(eventId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
