package ec.com.hananeel.mailmanager.adapter.in.web;

import ec.com.hananeel.mailmanager.application.port.in.SendEmailUseCase;
import ec.com.hananeel.mailmanager.exception.ApplicationException;
import ec.com.hananeel.mailmanager.exception.ControllerException;
import ec.com.hananeel.mailmanager.qualifier.WebAdapter;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("send")
@RequestScoped
@WebAdapter
public class SendEmailController {

    @Inject
    private SendEmailUseCase sendEmailUseCase;

    public SendEmailController() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendEmail() throws ControllerException {
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

        String output = "[Mail Manager 1.0]: " + ids.size() + " correos enviados exitosamente.";
        return Response.status(200)
                       .entity(output)
                       .build();
    }
}
