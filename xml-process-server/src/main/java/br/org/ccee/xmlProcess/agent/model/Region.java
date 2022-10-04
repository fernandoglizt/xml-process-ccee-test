package br.org.ccee.xmlProcess.agent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
@XmlRootElement(name = "regiao")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "sigla")
    private final String acronym;

    @XmlElement(name = "geracao")
    private final Generation generation;

    @XmlElement(name = "compra")
    private final Purchase purchase;

    @XmlElement(name = "precoMedio")
    private final AveragePrice averagePrice;

}
