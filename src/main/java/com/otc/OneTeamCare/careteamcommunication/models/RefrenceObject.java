package com.otc.OneTeamCare.careteamcommunication.models;
public class RefrenceObject {
  private String reference;
  Identifier IdentifierObject;
  private String display = null;


 // Getter Methods 

  public String getReference() {
    return reference;
  }

  public Identifier getIdentifier() {
    return IdentifierObject;
  }

  public String getDisplay() {
    return display;
  }

 // Setter Methods 

  public void setReference( String reference ) {
    this.reference = reference;
  }

  public void setIdentifier( Identifier identifierObject ) {
    this.IdentifierObject = identifierObject;
  }

  public void setDisplay( String display ) {
    this.display = display;
  }
}
