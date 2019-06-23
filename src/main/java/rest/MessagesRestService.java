package rest;

import dto.MessageJsonDTO;
import mapper.MessageMapper;
import model.Message;
import model.User;
import repository.MessageRepository;
import repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/api/message")
public class MessagesRestService {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAll() {
        return Response.ok(MessageRepository.INSTANCE.getDAO().getAll()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/one/{id}")
    public Response GetOne(@PathParam("id") long id) {
        return Response.ok(MessageRepository.INSTANCE.getDAO().get(id)).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/one")
    public Response find(
            @QueryParam("id") long id) {
        return Response.ok(MessageRepository.INSTANCE.getDAO().get(id)).build();
    }


    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/add/{title}/{content}")
    public Response add(@PathParam("title") String title, @PathParam("content") String content) {

        MessageRepository.INSTANCE.getDAO()
                .save(new Message(title, content, UserRepository.INSTANCE.getDAO().get("kazik")));

        return Response.ok(MessageRepository.INSTANCE.getDAO().get(title)).build();
    }

    @POST
    @Path("/add/form")
    public Response addFromForm(
            @FormParam("title") String title,
            @FormParam("content") String content
    ) {
        MessageRepository.INSTANCE.getDAO()
                .save(new Message(title, content, UserRepository.INSTANCE.getDAO().get("kazik")));
        return Response.ok("Wiadomość dodana").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMessage(MessageJsonDTO messageDto) {
        Message m = MessageMapper.mapFromJsonDTO(messageDto);
        User user = UserRepository.INSTANCE.getDAO().get(m.getAuthor().getLogin());
        if (user != null) {
            m.setAuthor(user);
            MessageRepository.INSTANCE.getDAO().save(m);
        }
        return Response.ok("Wiadomość dodana").build();
    }

    @DELETE
    @Path("{id}")
     public Response delete(@PathParam("id") long id){
        Message m = MessageRepository.INSTANCE.getDAO().get(id);
        if(m!=null) {
            MessageRepository.INSTANCE.getDAO().delete(m);
            return Response.ok(m).build();
        }
            return Response.notModified().build();
        }
    }

