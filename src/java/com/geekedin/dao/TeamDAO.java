/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.dao;

import com.geekedin.team.Team;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author user
 */
public class TeamDAO extends DatabaseConnector
{
    public int addTeam(Team team) throws SQLException
    {
        String sql = "INSERT INTO tblteam(name, leaderId, challengeId, maxNumber, skills) VALUES('"+team.getName()+"', "+team.getLeaderId()+", "+team.getChallengeId()+", "+team.getLimit()+", '"+team.getSkills()+"')";
        return statement.executeUpdate(sql);
    }
    
    public int update(Team team) throws SQLException
    {
        String sql = "UPDATE tblteam SET name = '"+team.getName()+"', leaderId = "+team.getLeaderId()+", challengeId = "+team.getChallengeId()+", members = "+team.getNumberOfMembers()+", maxNumber = "+team.getLimit()+", skills = '"+team.getSkills()+"' WHERE id = "+ team.getId();
        return statement.executeUpdate(sql);
    }
    
    public int addMember(int teamId) throws SQLException
    {
        String sql = "UPDATE tblteam SET members = members + 1 WHERE id = " + teamId;
        return statement.executeUpdate(sql);
    }
    
    public int delete(int teamId) throws SQLException
    {
        String sql = "DELETE FROM tblteam WHERE id = " + teamId;
        return statement.executeUpdate(sql);
    }
    
    public Team getTeam(int teamId) throws SQLException
    {
        Team team = null;
        
        String sql = "SELECT * FROM tblteam WHERE id = " + teamId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            team = new Team(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
        }
        
        return team;
    }
    
    public Team getTeamByLeader(int leaderId) throws SQLException
    {
        Team team = null;
        
        String sql = "SELECT * FROM tblteam WHERE leaderId = " + leaderId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            team = new Team(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
        }
        
        return team;
    }    
    
    public Vector<Team> getTeams() throws SQLException
    {
        Vector<Team> teams = new Vector<Team>();
        
        String sql = "SELECT * FROM tblteam";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            teams.add(new Team(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
        }
        return teams;
    }
    
    public Vector<Team> getTeamsByChallenge(int challengeId) throws SQLException
    {
        Vector<Team> teams = new Vector<Team>();
        
        String sql = "SELECT * FROM tblteam WHERE challengeId = " + challengeId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            teams.add(new Team(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
        }
        return teams;
    }
    
    public Team getGeekTeam(int teamId) throws SQLException
    {
        Team team = null;
        if(teamId != 0)
        {
            String sql = "SELECT teamid FROM tblgeek WHERE teamid =" + teamId;
            ResultSet rs = statement.executeQuery(sql);
            int teamid = 0;
            while(rs.next())
            {
                teamId = rs.getInt(1);
            }

            sql = "SELECT * FROM tblteam WHERE id = "+ teamid;
            rs = statement.executeQuery(sql);
            while(rs.next())
            {
                team = new Team(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
            }
        }
        
        return team;
    }
    
    
}
