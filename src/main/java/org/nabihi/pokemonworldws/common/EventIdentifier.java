package org.nabihi.pokemonworldws.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class EventIdentifier {

    private String eventId;

    public EventIdentifier(){this.eventId = UUID.randomUUID().toString();
    }

    public EventIdentifier(String eventId){this.eventId = eventId;}
}
