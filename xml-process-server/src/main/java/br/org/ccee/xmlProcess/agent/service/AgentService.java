package br.org.ccee.xmlProcess.agent.service;

import br.org.ccee.xmlProcess.agent.model.Agent;
import br.org.ccee.xmlProcess.agent.model.Agents;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

@Service
public class AgentService {

    public Agents processXml(final MultipartFile xmlFile) throws JAXBException, IOException {
        final JAXBContext jc = JAXBContext.newInstance(Agents.class);
        final Unmarshaller unmarshaller = jc.createUnmarshaller();

        final StringReader reader = new StringReader(new String(xmlFile.getBytes(), StandardCharsets.UTF_8));
        final Agents agents = (Agents) unmarshaller.unmarshal(reader);

        agents.getAll().stream().map(Agent::getCode).forEach(System.out::println);

        return agents;
    }


}
