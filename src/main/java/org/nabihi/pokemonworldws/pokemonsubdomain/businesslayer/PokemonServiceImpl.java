package org.nabihi.pokemonworldws.pokemonsubdomain.businesslayer;

import lombok.extern.slf4j.Slf4j;
import org.nabihi.pokemonworldws.common.PokemonIdentifier;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.Pokemon;
import org.nabihi.pokemonworldws.pokemonsubdomain.dataccesslayer.PokemonRepository;
import org.nabihi.pokemonworldws.pokemonsubdomain.mapperlayer.PokemonRequestMapper;
import org.nabihi.pokemonworldws.pokemonsubdomain.mapperlayer.PokemonResponseMapper;
import org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer.PokemonRequestModel;
import org.nabihi.pokemonworldws.pokemonsubdomain.presentationlayer.PokemonResponseModel;
import org.nabihi.pokemonworldws.utils.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService{

    private final PokemonRequestMapper pokemonRequestMapper;

    private final PokemonResponseMapper pokemonResponseMapper;

    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRequestMapper pokemonRequestMapper, PokemonResponseMapper pokemonResponseMapper, PokemonRepository pokemonRepository) {
        this.pokemonRequestMapper = pokemonRequestMapper;
        this.pokemonResponseMapper = pokemonResponseMapper;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<PokemonResponseModel> getAllPokemons() {
        List<Pokemon> pokemonList = pokemonRepository.findAll();

        return pokemonResponseMapper.entityListToResponseModel(pokemonList);
    }

    @Override
    public PokemonResponseModel getPokemonByPokemonId(String pokemonId) {
        Pokemon foundPokemon = pokemonRepository.findPokemonByPokemonIdentifier_PokemonId(pokemonId);
        if (foundPokemon == null){
            throw new InvalidInputException("PokemonId provided is invalid: " + pokemonId);
        }

        return pokemonResponseMapper.entityToResponseModel(foundPokemon);
    }

    @Override
    public PokemonResponseModel addPokemon(PokemonRequestModel pokemonRequestModel) {
        Pokemon newPokemon = pokemonRequestMapper.requestModelToEntity(pokemonRequestModel, new PokemonIdentifier());

        return pokemonResponseMapper.entityToResponseModel(pokemonRepository.save(newPokemon));
    }

    @Override
    public PokemonResponseModel updatePokemon(PokemonRequestModel pokemonRequestModel, String pokemonId) {
        Pokemon foundPokemon = pokemonRepository.findPokemonByPokemonIdentifier_PokemonId(pokemonId);
        Pokemon updatedPokemon = pokemonRequestMapper.requestModelToEntity(pokemonRequestModel, foundPokemon.getPokemonIdentifier());
        updatedPokemon.setId(foundPokemon.getId());

        return pokemonResponseMapper.entityToResponseModel(pokemonRepository.save(updatedPokemon));
    }

    @Override
    public void deletePokemon(String pokemonId) {
        Pokemon foundPokemon = pokemonRepository.findPokemonByPokemonIdentifier_PokemonId(pokemonId);
        pokemonRepository.delete(foundPokemon);
    }
}
