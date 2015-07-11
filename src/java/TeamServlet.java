/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.geekedin.challenge.Challenge;
import com.geekedin.dao.ChallengeDAO;
import com.geekedin.dao.GeekDAO;
import com.geekedin.dao.TeamDAO;
import com.geekedin.geek.Geek;
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
 * @author user
 */
public class TeamServlet extends HttpServlet
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
            TeamDAO dao = new TeamDAO();
            dao.open(usn, pwsd, url);
            if(decision.equalsIgnoreCase("Create Team"))
            {
                Team team = new Team();
                team.setName(request.getParameter("name"));
                team.setLeaderId(Integer.parseInt(request.getParameter("leaderId")));
                team.setChallengeId(Integer.parseInt(request.getParameter("challengeId")));
                team.setLimit(Integer.parseInt(request.getParameter("limit")));
                team.setSkills(request.getParameter("skills"));
                
                if(dao.addTeam(team) > 0)
                {
                    Vector<Team> teams = new Vector<Team>();
                    teams = dao.getTeams();
                    
                    session.setAttribute("teams", teams);
                    response.sendRedirect("viewTeam.jsp");
                }
                else
                {
                    response.sendRedirect("team.jsp");
                }
            }
            else if(decision.equalsIgnoreCase("ViewTeams"))
            {
                Vector<Team> teams = new Vector<Team>();
                teams = dao.getTeams();
                
                GeekDAO gd = new GeekDAO();
                gd.open(usn, pwsd, url);
                Vector<Geek> geeks = new Vector<Geek>();
                geeks = gd.getGeeks();
                gd.close();
                
                ChallengeDAO cd = new ChallengeDAO();
                cd.open(usn, pwsd, url);
                Vector<Challenge> challenges = new Vector<Challenge>();
                challenges = cd.getChallenges();
                cd.close();
                
                session.setAttribute("teams", teams);
                session.setAttribute("geeks", geeks);
                session.setAttribute("challenges", challenges);
                response.sendRedirect("viewTeam.jsp");
            }
            else if(decision.equalsIgnoreCase("Join"))
            {
                GeekDAO gd = new GeekDAO();
                gd.open(usn, pwsd, url);
                
                int teamId = Integer.parseInt(request.getParameter("teamId"));
                int geekId = Integer.parseInt(request.getParameter("geekId"));
                
                if(gd.updateTeam(geekId, teamId) > 0)
                {
                    if(dao.addMember(teamId) > 0)
                    {
                        response.sendRedirect("profile.jsp");
                    }
                }
                else
                {
                    response.sendRedirect("viewTeam.jsp");
                }
                
                gd.close();
            }
            else if(decision.equalsIgnoreCase("ViewTeamMembers"))
            {
                
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
            TeamDAO dao = new TeamDAO();
            dao.open(usn, pwsd, url);
            if(decision.equalsIgnoreCase("Create Team"))
            {
                Team team = new Team();
                team.setName(request.getParameter("name"));
                team.setLeaderId(Integer.parseInt(request.getParameter("leaderId")));
                team.setChallengeId(Integer.parseInt(request.getParameter("challengeId")));
                team.setLimit(Integer.parseInt(request.getParameter("limit")));
                team.setSkills(request.getParameter("skills"));
                
                if(dao.addTeam(team) > 0)
                {
                    response.sendRedirect("viewTeam.jsp");
                }
                else
                {
                    response.sendRedirect("team.jsp");
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
