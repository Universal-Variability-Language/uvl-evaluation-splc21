package at.jku.cps.travart.evaluation.standalone.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public final class Utils {

	public static double getFileSizeKiloBytes(final Path outputPath) throws IOException {
		return Math.round(Files.size(outputPath) / 1024.0 * 100.0) / 100.0;
	}

	public static Logger getSimpleLogger(final String className, final String logFileName)
			throws SecurityException, IOException {
		Logger logger = Logger.getLogger(className);
		final FileHandler fh = new FileHandler(String.format("%s.log", logFileName));
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
		return logger;
	}

	public static Set<Path> getPathSet(final Path path, final String extension) throws IOException {
		return getPathSetForLevel(path, extension, 1);
	}

	public static Set<Path> getPathSetForLevel(final Path path, final String extension, final int level)
			throws IOException {
		return Files.walk(path, level).filter(Files::isRegularFile)
				.filter(f -> f.getFileName().toString().endsWith(extension)).collect(Collectors.toSet());
	}

	private Utils() {
	}
}
