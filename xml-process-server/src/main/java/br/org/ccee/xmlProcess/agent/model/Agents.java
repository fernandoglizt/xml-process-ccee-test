package br.org.ccee.xmlProcess.agent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor(force = true)
@XmlRootElement(name = "agentes")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Agents implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "versao")
    private final String version;

    @XmlElement(name = "agente")
    private final Collection<Agent> all;

}
