package org.nabihi.pokemonworldws.eventssubdomain.mapperlayer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nabihi.pokemonworldws.common.EventIdentifier;
import org.nabihi.pokemonworldws.eventssubdomain.dataccesslayer.Event;
import org.nabihi.pokemonworldws.eventssubdomain.presentationlayer.EventRequestModel;

@Mapper(componentModel = "spring")
public interface EventRequestMapper {

    @Mapping(target = "id", ignore = true)
    Event requestModelToEntity(EventRequestModel eventRequestModel, EventIdentifier eventIdentifier);

}
