package net.fhirfactory.pegacorn.fhirview.model;

import lombok.Data;

import java.util.List;

@Data
public class Telecom {
    public List<Extension> extension;
    public String system;
    public String value;
    public String use;
}
