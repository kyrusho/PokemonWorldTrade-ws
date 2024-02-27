package org.nabihi.pokemonworldws.usersubdomain.dataccesslayer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nabihi.pokemonworldws.common.UserIdentifier;

import java.util.List;

@Data
@Table(name = "users")
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //database id

    @Embedded
    private UserIdentifier userIdentifier;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_bag_id")
    private PokemonBag pokemonBag;

    private String username;

    public User(String username){
        this.userIdentifier = new UserIdentifier();
        this.username =username;
    }

}
