package net.fhirfactory.pegacorn.fhirview.model;

import lombok.Data;

@Data
public class Link {
    public String relation;
    public String url;
}
