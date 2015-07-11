/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.dao;

import com.geekedin.challenge.Challenge;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author user
 */
public class ChallengeDAO extends DatabaseConnector
{
    public int addChallenge(Challenge challenge) throws SQLException
    {
        String sql = "INSERT INTO tblchallenge(geekId, name, overview, skill1, skill2, skill3, skill4, skill5, skill6) VALUES("+challenge.getGeekId()+",'"+challenge.getName()+"', '"+challenge.getOverview()+"', '"+challenge.getCategory()+"', "+challenge.getSkill1()+", "+challenge.getSkill2()+", "+challenge.getSkill3()+", "+challenge.getSkill4()+", "+challenge.getSkill5()+", "+challenge.getSkill6()+")";
        return statement.executeUpdate(sql);
    }
    
    public int updateChallenge(Challenge challenge) throws SQLException
    {
        String sql = "UPDATE tblchallenge SET name = '"+challenge.getName()+"', overview = '"+challenge.getOverview()+"', category = '"+challenge.getCategory()+"', skill1 = "+challenge.getSkill1()+", skill2 = "+challenge.getSkill2()+", skill3 = "+challenge.getSkill3()+", skill4 = "+challenge.getSkill4()+",skill5 = "+challenge.getSkill5()+", skill6 = "+challenge.getSkill6()+" WHERE id ="+challenge.getId();
        return statement.executeUpdate(sql);
    }
    
    public int deleteChallenge(int challengeId) throws SQLException
    {
        String sql = "DELETE FROM tblchallenge WHERE id = "+challengeId;
        return statement.executeUpdate(sql);
    }
    
    public Vector<Challenge> getChallenges() throws SQLException
    {
        Vector<Challenge> challenges = new Vector<Challenge>();
        
        String sql = "SELECT * FROM tblchallenge";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            challenges.add(new Challenge(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
        }
        
        return challenges;
    }
    
    public Vector<Challenge> getChallengesBySkill(int skillId) throws SQLException
    {
        Vector<Challenge> challenges = new Vector<Challenge>();
        
        String sql = "SELECT * FROM tblchallenge where skill1 = "+skillId+" OR skill2 = "+skillId+" OR skill3 = "+skillId+" OR skill4 = "+skillId+" OR skill5 = "+skillId+" OR skill6 = "+skillId+"";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            challenges.add(new Challenge(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
        }
        
        return challenges;
    }
    
    public Vector<Challenge> getChallengeByCategory(String category) throws SQLException
    {
        Vector<Challenge> challenges = new Vector<Challenge>();
        
        String sql = "SELECT * FROM tblchallenge WHERE category = '"+category+"'";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            challenges.add(new Challenge(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
        }
        
        return challenges;
    }
    
    public Vector<Challenge> getChallengesByGeek(int geekId) throws SQLException
    {
        Vector<Challenge> challenges = new Vector<Challenge>();
        
        String sql = "SELECT * FROM tblchallenge WHERE geekId = "+geekId+"";
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            challenges.add(new Challenge(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
        }
        
        return challenges;
    }
    
    public Challenge getChallenge(int challengeId) throws SQLException
    {
        Challenge challenge = null;
        
        String sql = "SELECT * FROM tblchallenge WHERE challengeId ="+ challengeId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            challenge = new Challenge(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
        }
        return challenge;
    }
    
    public Challenge getGeekChallenge(int geekId) throws SQLException
    {
        Challenge challenge = null;
        
        String sql = "SELECT c.id, c.name, c.overview FROM tblchallenge c, tblgeek g WHERE c.challengeId = g.challengeId AND g.id = "+geekId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            challenge = new Challenge(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
        }
        
        return challenge;
    }
    
    public int countTeams(int challengeId) throws SQLException
    {
        int teams = 0;
        
        String sql = "SELECT COUNT(challengeId) FROM tblteam WHERE challengeId = " + challengeId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            teams = rs.getInt(1);
        }
        
        return teams;
    }
    
    public Vector<Integer> getChallengeSkills(int challengeId) throws SQLException
    {
        Vector<Integer> skills = new Vector<Integer>();
        
        String sql = "SELECT skill1, skill2, skill3, skill4, skill5, skill6 FROM tblchallenge WHERE id = "+ challengeId;
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next())
        {
            skills.add(rs.getInt(1));
            skills.add(rs.getInt(2));
            skills.add(rs.getInt(3));
            skills.add(rs.getInt(4));
            skills.add(rs.getInt(5));
            skills.add(rs.getInt(6));
        }
        
        return skills;
    }
}
