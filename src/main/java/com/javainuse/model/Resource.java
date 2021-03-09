package net.fhirfactory.pegacorn.fhirview.model;

import lombok.Data;

import java.util.List;

@Data
public class Resource {
    public String resourceType;
    public String id;
    public Meta meta;
    public List<Extension> extension;
    public List<Identifier> identifier;
    public boolean active;
    public List<Name> name;
    public List<Telecom> telecom;
    public List<Address> address;
    public String gender;
}
