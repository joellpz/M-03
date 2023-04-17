package com.example.lastdemo;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class PlayerDto {
    int playerId;
    String name;
    int age;
    String position;
    String college;
    String draftTeam;
    int draftPos;
    int draftYear;
    Date born;
    int expCareer;

    public PlayerDto(int playerId, String name, int age, String position, String college, String draftTeam, int draftPos, int draftYear, Date born, int expCareer) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.position = position;
        this.college = college;
        this.draftTeam = draftTeam;
        this.draftPos = draftPos;
        this.draftYear = draftYear;
        this.born = born;
        this.expCareer = expCareer;
    }

    public PlayerDto(Player player) {
        this.playerId = player.getPlayerId();
        this.name = player.getName();
        this.age = player.getAge();
        this.position = player.getPosition();
        this.college = player.getCollege();
        this.draftTeam = player.getDraftTeam();
        this.draftPos = player.getDraftPos();
        this.draftYear = player.getDraftYear();
        this.born = player.getBorn();
        this.expCareer = player.getExpCareer();
    }
}
