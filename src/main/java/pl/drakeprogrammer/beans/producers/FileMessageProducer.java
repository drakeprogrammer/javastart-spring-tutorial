package pl.drakeprogrammer.beans.producers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
@FileMessage
public class FileMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		List<String> lines = readLines();
		return lines.stream().reduce("", (a, b) -> a + b);
	}

	private List<String> readLines() {
		try {
			Path path = new File(getClass().getResource("/message.txt").toURI()).toPath();
			return Files.readAllLines(path);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
