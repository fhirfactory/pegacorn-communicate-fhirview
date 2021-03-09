package net.fhirfactory.pegacorn.fhirview.model;

import lombok.Data;

import java.util.List;

@Data
public class Address {
    public List<String> line;
    public String city;
    public String state;
    public String postalCode;
    public String country;
}
