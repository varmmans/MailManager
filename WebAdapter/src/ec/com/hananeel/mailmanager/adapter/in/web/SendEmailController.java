package ec.com.hananeel.mailmanager.adapter.in.web;

import ec.com.hananeel.mailmanager.application.port.in.SendEmailUseCase;
import ec.com.hananeel.mailmanager.exception.ApplicationException;
import ec.com.hananeel.mailmanager.exception.ControllerException;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class SendEmailController {

    @Inject
    @Any
    Instance<SendEmailUseCase> proxy;
    //private SendEmailUseCase sendEmailUseCase;

    /* public SendEmailController(SendEmailUseCase sendEmailUseCase) {
        this.sendEmailUseCase = sendEmailUseCase;
    } */

    @POST
    @Path("/send")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendEmail(String postData) throws ControllerException {
        SendEmailUseCase sendEmailUseCase = proxy.select().get();

        SendEmailUseCase.SendEmailCommand command = new SendEmailUseCase.SendEmailCommand();
        List<String> ids;
        try {
            ids = sendEmailUseCase.sendEmails(command)
                                  .stream()
                                  .map(x -> x.getEmailId()
                                             .getCodigoMensaje()
                                             .toString())
                                  .collect(Collectors.toList());
        } catch (ApplicationException e) {
            throw new ControllerException(e);
        }

        String output = "Mail Manager 1.0: " + ids.size() + " correos enviados exitosamente.";
        return Response.status(200)
                       .entity(output)
                       .build();
    }
}
