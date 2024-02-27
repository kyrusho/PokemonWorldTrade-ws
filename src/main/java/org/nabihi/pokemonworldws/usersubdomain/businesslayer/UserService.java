package org.nabihi.pokemonworldws.usersubdomain.businesslayer;

import org.nabihi.pokemonworldws.usersubdomain.presentationlayer.UserRequestModel;
import org.nabihi.pokemonworldws.usersubdomain.presentationlayer.UserResponseModel;

import java.util.List;

public interface UserService {

    List<UserResponseModel> getAllUsers();

    UserResponseModel getUserByUserId(String userId);

    UserResponseModel addUser(UserRequestModel userRequestModel);

    UserResponseModel updateUser(UserRequestModel userRequestModel, String userId);

    void deleteUser(String userId);
}
