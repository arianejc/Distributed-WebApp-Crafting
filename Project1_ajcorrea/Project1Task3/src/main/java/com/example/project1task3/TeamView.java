// Ariane Correa
// ajcorrea

package com.example.project1task3;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class TeamView {
    private List<TeamInfo> teamInfoList;
    private  Map<String,String> teamLogoMap ;
    private List<TeamPlayerStats> teamPlayerStatsList;
    private Map<String, String> stadiumMap;
    private String teamNameScrapperUrl;
    private String teamInfoUrl;
    private String logoUrl;
    private String playerStatsUrl;
    private String stadiumUrl;

    //getters and setters
    public List<TeamInfo>  getTeamInfoList() { return teamInfoList; }
    public void setTeamInfoList(List<TeamInfo>  teamInfoList) {this.teamInfoList = teamInfoList;}

    public Map<String, String> getTeamLogoMap() {
        return teamLogoMap;
    }
    public void setTeamLogoMap(Map<String, String> teamLogoMap) {
        this.teamLogoMap = teamLogoMap;
    }

    public List<TeamPlayerStats>  getTeamPlayerStatsList() {
        return teamPlayerStatsList;
    }
    public void setTeamPlayerStatsList(List<TeamPlayerStats>  teamPlayerStatsList) {this.teamPlayerStatsList = teamPlayerStatsList;}

    public Map<String, String> getStadiumMap() {
        return stadiumMap;
    }
    public void setStadiumMap(Map<String, String> stadiumMap) {
        this.stadiumMap = stadiumMap;
    }

    public String getTeamNameScrapperUrl() {
        return teamNameScrapperUrl;
    }
    public void setTeamNameScrapperUrl(String teamNameScrapperUrl) {
        this.teamNameScrapperUrl = teamNameScrapperUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getTeamInfoUrl() {
        return teamInfoUrl;
    }
    public void setTeamInfoUrl(String teamInfoUrl) {
        this.teamInfoUrl = teamInfoUrl;
    }

    public String getPlayerStatsUrl() {
        return playerStatsUrl;
    }
    public void setPlayerStatsUrl(String playerStatsUrl) {
        this.playerStatsUrl = playerStatsUrl;
    }

    public String getStadiumUrl() {
        return stadiumUrl;
    }
    public void setStadiumUrl(String stadiumUrl) {
        this.stadiumUrl = stadiumUrl;
    }

}
