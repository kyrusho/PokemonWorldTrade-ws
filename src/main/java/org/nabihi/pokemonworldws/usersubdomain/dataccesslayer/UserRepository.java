package org.nabihi.pokemonworldws.usersubdomain.dataccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserIdentifier_UserId(String userId);



}
