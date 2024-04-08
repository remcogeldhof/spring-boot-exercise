package be.optis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class JavaExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaExerciseApplication.class, args);
	}

	/**
	 * Exercise 1
	 */
	private static void logTodoItems1() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/todo.csv"));
			int descriptionIndex = 4;
			int items = 0;
			String line;

			// skip first row (heading names)
			reader.readLine();

			System.out.println("Items:");
			while ((line = reader.readLine()) != null) {
				String[] columns = line.split(",");
				if (columns.length > descriptionIndex) {
					String value = columns[descriptionIndex];
					System.out.println("- " + value);
					items++;
				}
			}

			System.out.println("Nr of items: " + items);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

	/**
	 * Exercise 2
	 */
	private static void logTodoItems2() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/todo.csv"));
			int descriptionIndex = 4;
			int priorityIndex = 1;
			int items = 0;
			String line;
			List<String> sortedLines = new ArrayList<>();

			// skip first row (heading names)
			reader.readLine();

			// add every line in list
			while ((line = reader.readLine()) != null) {
				sortedLines.add(line);
			}

			// sort lines on priority, empty values will be put last
			sortedLines.sort(Comparator.comparing(l -> {
				String[] columns = l.split(",");
				if (columns.length <= priorityIndex || columns[priorityIndex].isEmpty()) {
					return "Z";
				}
				return columns[priorityIndex];
			}));

			// log result
			System.out.println("Items:");
			for (String sortedLine : sortedLines) {
				String[] columns = sortedLine.split(",");
				if (columns.length > descriptionIndex) {
					String value = columns[descriptionIndex];
					System.out.println("- " + value);
					items++;
				}
			}
			System.out.println("Nr of items: " + items);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

	/**
	 * Exercise 3
	 */
	private static void logTodoItems3() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/todo.csv"));
			int descriptionIndex = 4;
			int priorityIndex = 1;
			int contextIndex = 6;
			int items = 0;
			String line;
			List<String> sortedLines = new ArrayList<>();

			// skip first row (heading names)
			reader.readLine();

			// add every line in list
			while ((line = reader.readLine()) != null) {
				sortedLines.add(line);
			}

			// Sort on Optis
			sortedLines = sortedLines.stream().filter(l -> {
				String[] columns = l.split(",");
				if (columns.length > contextIndex) {
					return "optis".equals(columns[contextIndex]);
				}
				return false;
			}).collect(Collectors.toList());

			// sort lines on priority, empty values will be put last
			sortedLines.sort(Comparator.comparing(l -> {
				String[] columns = l.split(",");
				if (columns.length <= priorityIndex || columns[priorityIndex].isEmpty()) {
					return "Z";
				}
				return columns[priorityIndex];
			}));

			// log result
			System.out.println("Items:");
			for (String sortedLine : sortedLines) {
				String[] columns = sortedLine.split(",");
				if (columns.length > descriptionIndex) {
					String value = columns[descriptionIndex];
					System.out.println("- " + value);
					items++;
				}
			}
			System.out.println("Nr of items: " + items);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}
}
