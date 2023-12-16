import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            //Инициализация файла 1
            BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
            String[] line1 = file1.readLine().split(" ");
            float x = Float.parseFloat(line1[0]);
            float y = Float.parseFloat(line1[1]);

            float rad = Float.parseFloat(file1.readLine());
            file1.close();
            //Инициализация файла 2
            BufferedReader file2 = new BufferedReader(new FileReader(args[1]));
            List<Float[]> coords = new ArrayList<>();
            while (file2.ready()) {
                String[] line2 = file2.readLine().split(" ");
                Float[] coord = {Float.parseFloat(line2[0]), Float.parseFloat(line2[1])};
                coords.add(coord);
            }
            file2.close();
            //Вывод результата
            System.out.println(calculatePosition(x, y, rad, coords));
        }
    }

    public static String calculatePosition(float x, float y, float rad, List<Float[]> coords) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coords.size(); i++) {
            //√((coord1-x)² + (coord2-y)²) = dist to circle center
            float distance = (float) Math.sqrt(Math.pow(coords.get(i)[0] - x, 2) +
                    Math.pow(coords.get(i)[1] - y, 2));
            if (distance > rad) {
                sb.append(2).append("\n");
            } else if (distance == rad) {
                sb.append(0).append("\n");
            } else if (distance < rad) {
                sb.append(1).append("\n");
            }
        }
        return sb.toString();
    }
}