/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.geekedin.dao.GeekDAO;
import com.geekedin.geek.Geek;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class ProfileServlet extends HttpServlet
{
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String usn = getServletContext().getInitParameter("usn");
        String pwsd = getServletContext().getInitParameter("pwsd");
        String url = getServletContext().getInitParameter("url");
        
        String decision = request.getParameter("select");
        
        HttpSession session = request.getSession(true);
        try
        {
            GeekDAO dao = new GeekDAO();
            dao.open(usn, pwsd, url);
            if(decision.equalsIgnoreCase("Edit Profile"))
            {
                Geek geek = new Geek();
                geek.setId(Integer.parseInt(request.getParameter("geekId")));
                geek.setName(request.getParameter("name"));
                geek.setSurname(request.getParameter("surname"));
                geek.setGender(request.getParameter("gender"));
                geek.setPhoneNumber(request.getParameter("phone"));
                geek.setEmail(request.getParameter("email"));
                geek.setCity(request.getParameter("city"));
                geek.setCountry(request.getParameter("country"));

                String[] skills = request.getParameterValues("skills");

                if(skills.length == 1)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                }
                else if(skills.length == 2)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                }
                else if(skills.length == 3)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                    geek.setSkill3(Integer.parseInt(skills[2]));
                }
                else if(skills.length == 4)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                    geek.setSkill3(Integer.parseInt(skills[2]));
                    geek.setSkill4(Integer.parseInt(skills[3]));
                }
                else if(skills.length == 5)
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                    geek.setSkill3(Integer.parseInt(skills[2]));
                    geek.setSkill4(Integer.parseInt(skills[3]));
                    geek.setSkill5(Integer.parseInt(skills[4]));
                }
                else
                {
                    geek.setSkill1(Integer.parseInt(skills[0]));
                    geek.setSkill2(Integer.parseInt(skills[1]));
                    geek.setSkill3(Integer.parseInt(skills[2]));
                    geek.setSkill4(Integer.parseInt(skills[3]));
                    geek.setSkill5(Integer.parseInt(skills[4]));
                    geek.setSkill6(Integer.parseInt(skills[5]));
                }

                if(dao.update(geek) > 0)
                {
                    session.setAttribute("geek", geek);
                    session.setAttribute("message", "Your profile has been edited");
                    response.sendRedirect("profile.jsp");
                }
                else
                {
                    response.sendRedirect("profile.jsp");
                }
            }
            dao.close();
        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
