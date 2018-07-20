package com.otc.OneTeamCare.careteamcommunication.mappers;

import org.springframework.stereotype.Component;

@Component
public class CareTeam {
  private String identifier;
  private String display;


 // Getter Methods 

  public String getIdentifier() {
    return identifier;
  }

  public String getDisplay() {
    return display;
  }

 // Setter Methods 

  public void setIdentifier( String identifier ) {
    this.identifier = identifier;
  }

  public void setDisplay( String display ) {
    this.display = display;
  }
}
