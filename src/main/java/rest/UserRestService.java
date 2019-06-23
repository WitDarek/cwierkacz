package rest;

import dto.UserJsonDTO;
import mapper.UserMapper;
import model.Message;
import model.User;
import repository.MessageRepository;
import repository.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(value = "/api/user")
public class UserRestService {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAll() {
        return Response.ok(UserRepository.INSTANCE.getDAO().getAll()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/one/{id}")
    public Response GetOne(@PathParam("id") long id) {
        return Response.ok(UserRepository.INSTANCE.getDAO().get(id)).build();
    }

    @POST
    @Path("/add/form")
    public Response addUser(
            @FormParam("login") String login,
            @FormParam("password") String password,
            @FormParam("email") String email
    ) {
        UserRepository.INSTANCE.getDAO().save(new User(login, password, email));
        return Response.ok("Dodano użytkownia").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(UserJsonDTO userDto) {
        User user = UserMapper.mapFromJsonDTO(userDto);
        //user.setRegistered(userDto.registered);
        if (user != null) {
            UserRepository.INSTANCE.getDAO().save(user);
        }
        return Response.ok("Użytkownik został dodany").build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        User user = UserRepository.INSTANCE.getDAO().get(id);
        if (user != null) {
            UserRepository.INSTANCE.getDAO().delete(user);
            return Response.ok(user).build();
        }
        return Response.notModified().build();
    }

    @GET
    @Path("/{id}/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response userMessages(@PathParam("id") long id) {
        User user = UserRepository.INSTANCE.getDAO().get(id);
        if (user != null) {
            List<Message> messages = MessageRepository.INSTANCE.getDAO().findByAuthor(user);
            return Response.ok(messages).build();
        }
        return Response.status(404).build();
    }

}
