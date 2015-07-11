/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.geekedin.dao.GeekDAO;
import com.geekedin.dao.SkillDAO;
import com.geekedin.dao.TeamDAO;
import com.geekedin.geek.Geek;
import com.geekedin.skill.Skill;
import com.geekedin.team.Team;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class GeekServlet extends HttpServlet 
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
            
           if(decision.equalsIgnoreCase("ViewGeeks"))
           {
               Vector<Geek> geeks = dao.getGeeks();
               
               
                TeamDAO td = new TeamDAO();
                    td.open(usn, pwsd, url);
                    Vector<Team> teams = td.getTeams();
                    td.close();
               
                SkillDAO sd = new SkillDAO();
                
                sd.open(usn, pwsd, url);
                Vector<Skill> skills = sd.getSkills();     
                sd.close();
               
               session.setAttribute("geeksSkills", skills);
               session.setAttribute("geeksTeams", teams);
               session.setAttribute("allgeeks", geeks);
               response.sendRedirect("geeks.jsp");
           } 
           dao.close();
        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
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
