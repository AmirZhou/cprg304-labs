package service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {
	private final Path filePath;
	
	public FileHandler(String path) {
		this.filePath = Paths.get(path);
	}
	
	public List<String> getStrings() throws IOException {
		if (Files.notExists(filePath)) {
			throw new FileNotFoundException("File not found: " + filePath.toAbsolutePath());
		}
		return Files.readAllLines(filePath);
	}
	
	public void storeStrings(List<String> strings) throws IOException {
		Files.createDirectory(filePath.getParent());
		try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
			for (String string : strings) {
				writer.write(string);
				writer.newLine();
			}
		}
	}
}
