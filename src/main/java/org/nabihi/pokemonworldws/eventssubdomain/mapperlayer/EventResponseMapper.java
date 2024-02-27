package org.nabihi.pokemonworldws.eventssubdomain.mapperlayer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nabihi.pokemonworldws.eventssubdomain.dataccesslayer.Event;
import org.nabihi.pokemonworldws.eventssubdomain.presentationlayer.EventResponseModel;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EventResponseMapper {

    @Mapping(expression = "java(event.getEventIdentifier().getEventId())", target = "eventId")
    EventResponseModel entityToResponseModel(Event event);

    List<EventResponseModel> entityListToResponseModel(List<Event> eventList);
}
