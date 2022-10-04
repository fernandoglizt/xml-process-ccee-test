package br.org.ccee.xmlProcess;

import br.org.ccee.xmlProcess.agent.service.AgentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public AgentService getAgentService() {
        return new AgentService();
    }
}
