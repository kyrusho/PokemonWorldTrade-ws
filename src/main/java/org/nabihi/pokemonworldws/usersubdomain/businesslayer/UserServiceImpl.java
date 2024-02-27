package org.nabihi.pokemonworldws.usersubdomain.businesslayer;

import lombok.extern.slf4j.Slf4j;
import org.nabihi.pokemonworldws.usersubdomain.dataccesslayer.User;
import org.nabihi.pokemonworldws.usersubdomain.dataccesslayer.UserRepository;
import org.nabihi.pokemonworldws.usersubdomain.mapperlayer.UserRequestMapper;
import org.nabihi.pokemonworldws.usersubdomain.mapperlayer.UserResponseMapper;
import org.nabihi.pokemonworldws.usersubdomain.presentationlayer.UserRequestModel;
import org.nabihi.pokemonworldws.usersubdomain.presentationlayer.UserResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserResponseMapper userResponseMapper, UserRequestMapper userRequestMapper, UserRepository userRepository) {
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseModel> getAllUsers() {
        List<User> user = userRepository.findAll();

        return userResponseMapper.entityListToResponseModel(user);
    }

    @Override
    public UserResponseModel getUserByUserId(String userId) {
        return null;
    }

    @Override
    public UserResponseModel addUser(UserRequestModel userRequestModel) {
        return null;
    }

    @Override
    public UserResponseModel updateUser(UserRequestModel userRequestModel, String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}
