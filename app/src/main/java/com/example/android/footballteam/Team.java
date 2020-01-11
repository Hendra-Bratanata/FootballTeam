package com.example.android.footballteam;

import org.json.JSONObject;

public class Team {
    String namaTeam;
    String deskripsiTeam;
    String logoTeam;

    public Team(JSONObject object){
        try {
            String namaTeam = object.getString("strTeam");
            String deskripsiTeam = object.getString("strDescriptionEN");
            String logoTeam = object.getString("strTeamBadge");

            this.namaTeam = namaTeam;
            this.deskripsiTeam = deskripsiTeam;
            this.logoTeam = logoTeam;
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getNamaTeam() {
        return namaTeam;
    }

    public void setNamaTeam(String namaTeam) {
        this.namaTeam = namaTeam;
    }

    public String getDeskripsiTeam() {
        return deskripsiTeam;
    }

    public void setDeskripsiTeam(String deskripsiTeam) {
        this.deskripsiTeam = deskripsiTeam;
    }

    public String getLogoTeam() {
        return logoTeam;
    }

    public void setLogoTeam(String logoTeam) {
        this.logoTeam = logoTeam;
    }


}
