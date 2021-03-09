package net.fhirfactory.pegacorn.fhirview.model;

import lombok.Data;

@Data
public class Identifier {
    public String system;
    public String value;
}
