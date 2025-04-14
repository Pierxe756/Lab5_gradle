package managers;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import models.Person;
import models.Semester;
import models.StudyGroup;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;

public class DumpManager {
    private static final CsvMapper mapper = new CsvMapper();

    static {
        SimpleModule module = new SimpleModule();
        module.addSerializer(models.Person.class, new PersonSerializer());
        module.addDeserializer(models.Person.class, new PersonDeserializer());
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(module);
    }

    public static void saveCollection(String filePath, LinkedList<?> list) throws IOException {
        File file = new File(filePath);
        file.setWritable(true);

        if (list == null || list.isEmpty()) {
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(file), StandardCharsets.UTF_8)) {
                writer.write("");
            }
            System.out.println("Коллекция пуста. Файл очищен.");
            return;
        }

        // Запись непустой коллекции с использованием OutputStreamWriter
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8)) {

            CsvSchema schema = mapper.schemaFor(list.getFirst().getClass()).withHeader();
            ObjectWriter objectWriter = mapper.writerFor(list.getClass()).with(schema);

            // Создаем временный StringWriter для получения CSV-строки
            StringWriter stringWriter = new StringWriter();
            objectWriter.writeValue(stringWriter, list);

            // Записываем результат в файл через OutputStreamWriter
            writer.write(stringWriter.toString());
        }

        System.out.println("Коллекция сохранена в файл: " + file.getAbsolutePath());
    }

    public static LinkedList<StudyGroup> loadCollection(String filePath) throws IOException {
        LinkedList<StudyGroup> collection = new LinkedList<>();
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            System.out.println("Файл не существует или недоступен для чтения: " + filePath);
            return collection;
        }

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                try {
                    StudyGroup group = parseStudyGroupFromCsvLine(line);
                    if (group != null) {
                        collection.add(group);
                    }
                } catch (Exception e) {
                    System.err.println("Ошибка при парсинге строки: " + line);
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Загружено " + collection.size() + " элементов из файла: " + filePath);
        return collection;
    }

    private static StudyGroup parseStudyGroupFromCsvLine(String csvLine) throws IOException {
        CsvMapper lineMapper = new CsvMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Person.class, new PersonSerializer());
        module.addDeserializer(Person.class, new PersonDeserializer());
        module.addDeserializer(Semester.class, new SemesterDeserializer()); // Добавлено

        lineMapper.registerModule(new JavaTimeModule());
        lineMapper.registerModule(module);

        CsvSchema schema = lineMapper.schemaFor(StudyGroup.class).withoutHeader();
        ObjectReader reader = lineMapper.readerFor(StudyGroup.class).with(schema);

        try (StringReader stringReader = new StringReader(csvLine)) {
            return reader.readValue(stringReader);
        }
    }
}