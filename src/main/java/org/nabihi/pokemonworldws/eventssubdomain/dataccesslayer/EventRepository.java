package org.nabihi.pokemonworldws.eventssubdomain.dataccesslayer;


import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findEventByEventIdentifier_EventId(String eventId);

}
