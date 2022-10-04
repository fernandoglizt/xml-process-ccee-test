package br.org.ccee.xmlProcess.agent.controller;

import br.org.ccee.xmlProcess.agent.service.AgentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("api/v1/agent")
public class AgentController {
    private final AgentService agentService;

    public AgentController(final AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("file/process")
    public void process(@RequestPart("file") MultipartFile file, @RequestHeader Map<String, String> headers) throws Exception {
        agentService.processXml(file);
    }

}
