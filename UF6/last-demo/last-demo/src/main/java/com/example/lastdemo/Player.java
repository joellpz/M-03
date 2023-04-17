package com.example.lastdemo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

/**
 * Class for entity Player
 */
@Entity
@Data
@Table(name = "players")
public class Player{
    @Id
    @Column(name = "idplayer")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int playerId;
    String name;
    int age;
    String position;
    String college;
    @Column(name = "draftteam", length = 45)
    String draftTeam;
    @Column(name = "draftposition")
    int draftPos;
    @Column(name = "draftyear")
    int draftYear;
    Date born;
    @Column(name = "experience")
    int expCareer;


    /**
     * Constructor vacío.
     */
    public Player() {
    }

    /**
     * Permite definir los atributos de la clase
     *
     * @param name      Nombre
     * @param position  Posicion
     * @param college   Universidad
     * @param draftTeam Equipo del Draft
     * @param draftPos  Posicion del Draft
     * @param born      Fecha de Nacimiento
     * @param age       Edad
     * @param draftYear Año del Draft
     * @param expCareer Carrera
     */
    public Player(int playerId,String name, String position, String college, String draftTeam, int draftPos, Date born, int age, int draftYear, int expCareer) {
        super();
        this.playerId = playerId;
        this.name = name;
        this.position = position;
        this.college = college;
        this.draftTeam = draftTeam;
        this.draftPos = draftPos;
        this.born = born;
        this.age = age;
        this.draftYear = draftYear;
        this.expCareer = expCareer;
    }

    public Player(PlayerDto playerDto){
        this.playerId = playerDto.getPlayerId();
        this.name = playerDto.getName();
        this.position = playerDto.getPosition();
        this.college = playerDto.getCollege();
        this.draftTeam = playerDto.getDraftTeam();
        this.draftPos = playerDto.getDraftPos();
        this.born = playerDto.getBorn();
        this.age = playerDto.getAge();
        this.draftYear = playerDto.getDraftYear();
        this.expCareer = playerDto.getExpCareer();
    }

    /**
     * Devuelve como cadena de caracteres los atributos de la clase.
     *
     * @return Cadena con los atributos.
     */
    @Override
    public String toString() {

        return "Player{" +
                "playerId='" + playerId + '\'' + " | " +
                "name='" + name + '\'' + " | " +
                "born='" + born + '\'' + " | " +
                "age=" + age + " | " +
                "college='" + college + '\'' + " | " +
                "position='" + position + '\'' + " | " +
                "draftTeam='" + draftTeam + '\'' + " | " +
                "draftPos='" + draftPos + '\'' + " | " +
                "draftYear=" + draftYear + " | " +
                "expCareer=" + expCareer +
                '}';
    }
}
