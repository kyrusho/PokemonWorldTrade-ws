package org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer;

import org.nabihi.pokemonworldws.PokemonworldWsApplication;
import org.nabihi.pokemonworldws.pokemonsubdomain.businesslayer.PokemonService;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pokemons")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PokemonResponseModel>> getAllPokemons(){
        List<PokemonResponseModel> pokemonList = pokemonService.getAllPokemons();
        return ResponseEntity.status(HttpStatus.OK).body(pokemonList);
    }

    @GetMapping(produces = "application/json", value = "{pokemonId}")
    public ResponseEntity<PokemonResponseModel> getPokemonByPokemonId(@PathVariable String pokemonId){
        PokemonResponseModel pokemon = pokemonService.getPokemonByPokemonId(pokemonId);
        return ResponseEntity.status(HttpStatus.OK).body(pokemon);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<PokemonResponseModel> addPokemon(@RequestBody PokemonRequestModel pokemonRequestModel){
        PokemonResponseModel pokemon = pokemonService.addPokemon(pokemonRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pokemon);
    }

    @PutMapping(value = "{pokemonId}", produces = "application/json")
    public ResponseEntity<PokemonResponseModel> updatePokemon(@RequestBody PokemonRequestModel pokemonRequestModel,
                                                              @PathVariable String pokemonId){
        PokemonResponseModel pokemon = pokemonService.updatePokemon(pokemonRequestModel, pokemonId);
        return ResponseEntity.status(HttpStatus.OK).body(pokemon);
    }

    @DeleteMapping(value = "{pokemonId}")
    public ResponseEntity<Void> deletePokemon(@PathVariable String pokemonId){
        pokemonService.deletePokemon(pokemonId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
