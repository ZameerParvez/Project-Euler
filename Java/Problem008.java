import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problem008 extends Problem {
    
    public String readFile(String path) throws IOException {
        String number = "";
        BufferedReader reader  = new BufferedReader(new FileReader(new File(path)));
        String line = reader.readLine();
        while (line != null) {
            number += line;
            line = reader.readLine();
        }
        reader.close();
        return number;
    }

    @Override
    public String solve() {
        String number = "";
        try {
            number = readFile("Problem008-data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        long maxProduct = 0;
        for (int i = 0; i < number.length() - 12; ++i) {
            long product = 1;
            for (int j = 0; j < 13; ++j) {
                product *= Character.getNumericValue(number.charAt(i + j));
            }
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        return "" + maxProduct;
    }
    
    public static void main(String args[]) {
        new Problem008().benchmark();
    }

}
