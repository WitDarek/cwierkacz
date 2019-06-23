package mapper;

import dto.UserJsonDTO;
import model.User;

import java.time.LocalDateTime;

public class UserMapper{
    static public User mapFromJsonDTO(UserJsonDTO dto){
        User user = new User(dto.login,dto.password,dto.email);
        user.setRegistered(LocalDateTime.parse(dto.registered));
        return user;
    }
}