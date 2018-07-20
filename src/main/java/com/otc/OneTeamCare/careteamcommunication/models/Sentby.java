package com.otc.OneTeamCare.careteamcommunication.models;
public class Sentby {
  private String reference;
  Identifier identifier;
  private String display = null;


 // Getter Methods 

  public String getReference() {
    return reference;
  }

  public Identifier getIdentifier() {
    return identifier;
  }

  public String getDisplay() {
    return display;
  }

 // Setter Methods 

  public void setReference( String reference ) {
    this.reference = reference;
  }

  public void setIdentifier( Identifier identifier ) {
    this.identifier = identifier;
  }

  public void setDisplay( String display ) {
    this.display = display;
  }
}
