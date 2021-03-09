package net.fhirfactory.pegacorn.fhirview.model;

import lombok.Data;

import java.util.List;

@Data
public class Name {
    public String family;
    public List<String> given;
    public List<String> prefix;
}
