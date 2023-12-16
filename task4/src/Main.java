import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            List<Integer> num = new ArrayList<>();
            while (br.ready()) {
                num.add(Integer.parseInt(br.readLine()));
            }
            int middle = calculateMiddle(num);
            int count = 0;
            for (Integer numb : num) {
                count = count + Math.abs(numb - middle);
            }
            System.out.println(count);
        }
    }

    public static int calculateMiddle(List<Integer> num) {
        int middle = 0;
        for (Integer numb : num) middle += numb;
        int surplus = middle % num.size();
        middle /= num.size();
        if (surplus > num.size() / 2) {
            middle += 1;
        }
        return middle;
    }
}