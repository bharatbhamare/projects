package com.otc.OneTeamCare.careteamcommunication.mappers;

import org.springframework.stereotype.Component;

@Component
public class MessageBy {
  private String identifier;
  private String reference;
  private String display;
  private String photo;


 // Getter Methods 

  public String getIdentifier() {
    return identifier;
  }

  public String getReference() {
    return reference;
  }

  public String getDisplay() {
    return display;
  }

  public String getPhoto() {
    return photo;
  }

 // Setter Methods 

  public void setIdentifier( String identifier ) {
    this.identifier = identifier;
  }

  public void setReference( String reference ) {
    this.reference = reference;
  }

  public void setDisplay( String display ) {
    this.display = display;
  }

  public void setPhoto( String photo ) {
    this.photo = photo;
  }
}