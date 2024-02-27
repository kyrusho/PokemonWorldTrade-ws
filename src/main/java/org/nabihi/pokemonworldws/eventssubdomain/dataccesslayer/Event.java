package org.nabihi.pokemonworldws.eventssubdomain.dataccesslayer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.nabihi.pokemonworldws.common.EventIdentifier;

import java.time.LocalDate;

@Table(name = "events")
@Entity
@Getter
@Data
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //database id

    @Embedded
    private EventIdentifier eventIdentifier;

    private String eventName;

    private String eventType;

    private LocalDate eventDate;

    private String eventDescription;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    public Event(@NotNull String eventName, @NotNull String eventType, @NotNull LocalDate eventDate, @NotNull String eventDescription, @NotNull EventStatus eventStatus){
        this.eventIdentifier = new EventIdentifier();
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.eventStatus = eventStatus;
    }

    public Event(){}
}
