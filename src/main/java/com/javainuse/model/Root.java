package net.fhirfactory.pegacorn.fhirview.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Root {
    public String resourceType;
    public String id;
    public Meta meta;
    public String type;
    public List<Link> link;
    public List<Entry> entry;
}
