/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekedin.team;

/**
 *
 * @author user
 */
public class Team
{
    private int id;
    private String name;
    private int leaderId;
    private int challengeId;
    private int numberOfMembers;
    private int limit;
    private String skills;

    public Team() {
    }

    public Team(int id, String name, int leaderId, int challengeId, int numberOfMembers, int limit, String skills) {
        this.id = id;
        this.name = name;
        this.leaderId = leaderId;
        this.challengeId = challengeId;
        this.numberOfMembers = numberOfMembers;
        this.limit = limit;
        this.skills = skills;
    }

    public Team(String name, int leaderId, int challengeId, int limit, String skills) {
        this.name = name;
        this.leaderId = leaderId;
        this.challengeId = challengeId;
        this.limit = limit;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    
}
