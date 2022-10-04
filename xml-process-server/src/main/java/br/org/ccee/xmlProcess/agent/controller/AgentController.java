package br.org.ccee.xmlProcess.agent.controller;

import br.org.ccee.xmlProcess.agent.service.AgentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/agent")
public class AgentController {
    private final AgentService agentService;

    public AgentController(final AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("file/process")
    public void process(@RequestPart("file") MultipartFile file) throws Exception {
        agentService.processXml(file);
    }

}
