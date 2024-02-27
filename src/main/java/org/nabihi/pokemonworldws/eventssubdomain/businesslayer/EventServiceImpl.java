package org.nabihi.pokemonworldws.eventssubdomain.businesslayer;

import org.nabihi.pokemonworldws.common.EventIdentifier;
import org.nabihi.pokemonworldws.eventssubdomain.dataccesslayer.Event;
import org.nabihi.pokemonworldws.eventssubdomain.dataccesslayer.EventRepository;
import org.nabihi.pokemonworldws.eventssubdomain.mapperlayer.EventRequestMapper;
import org.nabihi.pokemonworldws.eventssubdomain.mapperlayer.EventResponseMapper;
import org.nabihi.pokemonworldws.eventssubdomain.presentationlayer.EventRequestModel;
import org.nabihi.pokemonworldws.eventssubdomain.presentationlayer.EventResponseModel;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final EventResponseMapper eventResponseMapper;

    private final EventRequestMapper eventRequestMapper;

    public EventServiceImpl(EventRepository eventRepository, EventResponseMapper eventResponseMapper, EventRequestMapper eventRequestMapper) {
        this.eventRepository = eventRepository;
        this.eventResponseMapper = eventResponseMapper;
        this.eventRequestMapper = eventRequestMapper;
    }

    @Override
    public List<EventResponseModel> getAllEvents() {
        List<Event> events = eventRepository.findAll();

        return eventResponseMapper.entityListToResponseModel(events);
    }

    @Override
    public EventResponseModel getEventByEventId(String eventId) {
        Event event = eventRepository.findEventByEventIdentifier_EventId(eventId);

        return eventResponseMapper.entityToResponseModel(event);
    }

    @Override
    public EventResponseModel addEvent(EventRequestModel eventRequestModel) {
        Event event = eventRequestMapper.requestModelToEntity(eventRequestModel, new EventIdentifier());

        return eventResponseMapper.entityToResponseModel(eventRepository.save(event));
    }

    @Override
    public EventResponseModel updateEvent(EventRequestModel eventRequestModel, String eventId) {
        Event event = eventRepository.findEventByEventIdentifier_EventId(eventId);
        Event updatedEvent = eventRequestMapper.requestModelToEntity(eventRequestModel, event.getEventIdentifier());
        updatedEvent.setId(event.getId());

        return eventResponseMapper.entityToResponseModel(eventRepository.save(updatedEvent));
    }

    @Override
    public void deleteEvent(String eventId) {
        Event foundEvent = eventRepository.findEventByEventIdentifier_EventId(eventId);
        eventRepository.delete(foundEvent);
    }
}
