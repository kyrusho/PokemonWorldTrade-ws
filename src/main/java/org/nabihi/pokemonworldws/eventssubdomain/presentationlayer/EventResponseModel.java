package org.nabihi.pokemonworldws.eventssubdomain.presentationlayer;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.nabihi.pokemonworldws.eventssubdomain.dataccesslayer.EventStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EventResponseModel {
    private String eventId;

    private String eventName;

    private String eventType;

    private LocalDate eventDate;

    private String eventDescription;

    private EventStatus eventStatus;
}
