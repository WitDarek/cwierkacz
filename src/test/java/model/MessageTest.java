package model;

import com.google.gson.Gson;
import dto.MessageJsonDTO;
import dto.UserJsonDTO;
import mapper.MessageMapper;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void getTitle() {
        String json = "{\n" +
                "  \"author\": {\n" +
                "    \"email\": \"kazik@.com\",\n" +
                "    \"login\": \"kazik\",\n" +
                "    \"password\": \"1234\",\n" +
                "    \"registered\": \"2019-06-23T09:07:19.258\"\n" +
                "  },\n" +
                "  \"content\": \"KAzik KAzik\",\n" +
                "  \"published\": \"2019-06-23T11:20:07.820\",\n" +
                "  \"title\": \"KAzik 2\"\n" +
                "}";

        Gson gson = new Gson();
        MessageJsonDTO message = gson.fromJson(json, MessageJsonDTO.class);
        assertEquals(message.title,"KAzik 2");
    }

    @Test
    public void mapperTest(){
        String json = "{\n" +
                "  \"author\": {\n" +
                "    \"email\": \"kazik@.com\",\n" +
                "    \"login\": \"kazik\",\n" +
                "    \"password\": \"1234\",\n" +
                "    \"registered\": \"2019-06-23T09:07:19.258\"\n" +
                "  },\n" +
                "  \"content\": \"KAzik KAzik\",\n" +
                "  \"published\": \"2019-06-23T11:20:07.820\",\n" +
                "  \"title\": \"KAzik 2\"\n" +
                "}";

        Gson gson = new Gson();
        Message message = MessageMapper.mapFromJsonDTO(gson.fromJson(json, MessageJsonDTO.class));
        assertEquals(message.getTitle(),"KAzik 2");
        assertEquals(message.getPublished().toString(),"2019-06-23T11:20:07.820");
    }





}