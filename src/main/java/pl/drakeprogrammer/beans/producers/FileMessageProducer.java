package pl.drakeprogrammer.beans.producers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import pl.drakeprogrammer.beans.producers.MessageProducerType.ProducerType;

@Component
@MessageProducerType(type = ProducerType.FILE_MESSAGE_PRODUCER)
public class FileMessageProducer implements MessageProducer {

	@Autowired
	private Environment environment;

	@Override
	public String getMessage() {
		List<String> lines = readLines();
		return lines.stream().reduce("", (a, b) -> a + b);
	}

	private List<String> readLines() {
		try {
			String fileName = environment.getProperty("messageFileProperty");
			Path path = new File(getClass().getResource(fileName).toURI()).toPath();
			return Files.readAllLines(path);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
