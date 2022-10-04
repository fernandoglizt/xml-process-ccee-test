package br.org.ccee.xmlProcess.agent;

import br.org.ccee.xmlProcess.TestConfig;
import br.org.ccee.xmlProcess.agent.service.AgentService;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class AgentServiceTest {

    @Autowired
    private AgentService agentService;


    @Test
    public void unmarshallerAgentByFileTest() throws URISyntaxException {
        final File[] files = new File(this.getClass().getResource("/agent").toURI()).listFiles();
        Stream.of(files).forEach(file -> {
            try {
                MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", FileUtils.readFileToByteArray(file));
                assertNotNull(agentService.processXml(multipartFile));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

}
