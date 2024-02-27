package org.nabihi.pokemonworldws.eventssubdomain.businesslayer;

import org.nabihi.pokemonworldws.eventssubdomain.presentationlayer.EventRequestModel;
import org.nabihi.pokemonworldws.eventssubdomain.presentationlayer.EventResponseModel;

import java.util.List;

public interface EventService {

    List<EventResponseModel> getAllEvents();

    EventResponseModel getEventByEventId(String eventId);

    EventResponseModel addEvent(EventRequestModel eventRequestModel);

    EventResponseModel updateEvent(EventRequestModel eventRequestModel, String eventId);

    void deleteEvent(String eventId);
}
