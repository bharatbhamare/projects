package com.otc.OneTeamCare.careteamcommunication.models;
public class Identifier {
  private String system;
  private String value;


 // Getter Methods 

  public String getSystem() {
    return system;
  }

  public String getValue() {
    return value;
  }

 // Setter Methods 

  public void setSystem( String system ) {
    this.system = system;
  }

  public void setValue( String value ) {
    this.value = value;
  }
}