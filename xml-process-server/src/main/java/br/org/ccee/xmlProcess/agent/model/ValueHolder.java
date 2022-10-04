package br.org.ccee.xmlProcess.agent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

@Data
@NoArgsConstructor(force = true)
@XmlAccessorType(XmlAccessType.PROPERTY)
public abstract class ValueHolder implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "valor")
    private final Collection<BigDecimal> value;
}
