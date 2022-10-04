package br.org.ccee.xmlProcess.agent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor(force = true)
@XmlRootElement(name = "agente")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "codigo")
    private final Integer code;

    @XmlElement(name = "data")
    private final Date date;

    @XmlElement(name = "regiao")
    private final Collection<Region> region;

}
