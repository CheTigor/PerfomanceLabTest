import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Инициализация файлы values.json
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Values.class, new ValuesDeserialize())
                .create();
        JsonReader reader = new JsonReader(new FileReader(args[1]));
        final Values values = gson.fromJson(reader, Values.class);

        //Инициализация файлы tests.json
        reader = new JsonReader(new FileReader(args[0]));
        gson = new GsonBuilder().setPrettyPrinting().create();
        final Tests tests = gson.fromJson(reader, Tests.class);

        //Дополняем values в tests
        for (Test test : tests.getTests()) {
            setValues(test, values);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("report.json"))) {
            bw.write(gson.toJson(tests));
        }
    }

    public static void setValues(Test test, Values values) {
        if (test.getValue() != null) {
            test.setValue(values.getValues().get(test.getId()));
        }
        if (test.getValues() != null) {
            if (!test.getValues().isEmpty()) {
                for (Test value : test.getValues()) {
                    setValues(value, values);
                }
            }
        }
    }
}