package mapper;

import dto.MessageJsonDTO;
import model.Message;

import java.time.LocalDateTime;

public class MessageMapper{
    static public Message mapFromJsonDTO(MessageJsonDTO dto){

        Message result = new Message(dto.title,dto.content,UserMapper.mapFromJsonDTO(dto.author));
        result.setPublished(LocalDateTime.parse(dto.published));
        return result;
    }
}