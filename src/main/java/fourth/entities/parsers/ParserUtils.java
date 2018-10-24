package fourth.entities.parsers;

import fourth.entities.classes.Learner;
import fourth.entities.classes.Lesson;
import fourth.entities.teachers.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserUtils {

    public static List<Teacher> parseTeachersFile(String fileName) throws IOException {
        List<Teacher> teachers = new ArrayList<>();
        CSVParser csvParser = createParser(fileName, "FirstName", "LastName");

        for (CSVRecord record : csvParser) {
            Teacher teacher = new TeacherImpl(record.get("FirstName"), record.get("LastName"));
            teachers.add(teacher);
        }

        return teachers;
    }

    public static List<Learner> parseLearnersFile(String fileName) throws IOException {
        List<Learner> learners = new ArrayList<>();
        CSVParser csvParser = createParser(fileName, "FirstName", "LastName");

        for (CSVRecord record : csvParser) {
            Learner learner = new Learner(record.get("FirstName"), record.get("LastName"));
            learners.add(learner);
        }

        return learners;
    }

    public static List<Lesson> parseScheduleFile(String fileName, int i) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int count = 0;

        while (count++ != i - 1) {
            reader.readLine();
        }

        String schedule = reader.readLine();

        return Arrays.stream(schedule.split(",")).map(String::trim)
                .map(Lesson::new)
                .collect(Collectors.toList());
    }

    public static Director parseDirectorFile(String fileName) throws IOException {
        CSVParser csvParser = createParser(fileName, "FirstName", "LastName");
        Director director = null;

        for (CSVRecord record : csvParser) {
            director = new DirectorImpl(record.get("FirstName"), record.get("LastName"));
        }

        return director;
    }

    public static HeadTeacher parseHeadTeacherFile(String fileName) throws IOException {
        CSVParser csvParser = createParser(fileName, "FirstName", "LastName");
        HeadTeacher headTeacher = null;

        for (CSVRecord record : csvParser) {
            headTeacher = new HeadTeacherImpl(record.get("FirstName"), record.get("LastName"));
        }

        return headTeacher;
    }

    private static CSVParser createParser(String fileName, String... headers) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(fileName));

        return new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader(headers)
                .withDelimiter(',')
                .withIgnoreHeaderCase()
                .withTrim());
    }
}
