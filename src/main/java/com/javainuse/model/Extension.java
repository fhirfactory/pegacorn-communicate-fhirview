package net.fhirfactory.pegacorn.fhirview.model;

import lombok.Data;

@Data
public class Extension {
    public String url;
    public int valueInteger;
    public boolean valueBoolean;
}
