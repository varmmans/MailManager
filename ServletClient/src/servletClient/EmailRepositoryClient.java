package servletClient;

import ec.com.hananeel.mailmanager.adapter.out.persistence.EmailJpaEntity;
import ec.com.hananeel.mailmanager.adapter.out.persistence.EmailJpaEntityPK;
import ec.com.hananeel.mailmanager.adapter.out.persistence.EmailRepository;
import ec.com.hananeel.mailmanager.adapter.out.persistence.ServerJpaEntity;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

import javax.ejb.EJB;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmailRepositoryClient", urlPatterns = { "EmailRepositoryClient" })
public class EmailRepositoryClient extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    @EJB
    private EmailRepository emailRepository;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>EmailRepositoryClient</title></head>");
        out.println("<body>");
        try {
            
            EmailJpaEntityPK pk = new EmailJpaEntityPK(1, 4);
            EmailJpaEntity e = emailRepository.findEmailJpaEntity(pk);
            //================================
            EmailJpaEntityPK emailJpaEntityPK = pk;
            Number mescodrel=e.getMescodrel();
            String mesorigen=e.getMesorigen();
            String mescoduse=e.getMescoduse();
            String mescodser=e.getMescodser();
            String mesnombre=e.getMesnombre();
            String messender=e.getMessender();
            String mesmailto=e.getMesmailto();
            String mesmailcc=e.getMesmailcc();
            String mesmailco=e.getMesmailco();
            String mesasunto=e.getMesasunto();
            String mescuerpo=e.getMescuerpo();
            String mescarpet=e.getMescarpet();
            String messatt01=e.getMessatt01();
            String messatt02=e.getMessatt02();
            String messatt03=e.getMessatt03();
            String messtatus = "E";
            String messtatut=e.getMesstatut();
            String mesusenew=e.getMesusenew();
            Date mesfecnew = new Date();
            String mesusemod=e.getMesusemod();
            Date mesfecmod=e.getMesfecmod();
            ServerJpaEntity serverJpaEntity = e.getServerJpaEntity();
                
            EmailJpaEntity entity2=    
                new EmailJpaEntity(emailJpaEntityPK, mescodrel, mesorigen, mescoduse, mescodser, mesnombre, messender, mesmailto, mesmailcc, mesmailco, mesasunto, mescuerpo, mescarpet, messatt01, messatt02, messatt03, messtatus, messtatut, mesusenew, mesfecnew, mesusemod, mesfecmod, serverJpaEntity);
            emailRepository.mergeEntity(entity2);
            
            System.out.println(entity2.getMesasunto());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        out.println("</body></html>");
        out.close();
    }
}
