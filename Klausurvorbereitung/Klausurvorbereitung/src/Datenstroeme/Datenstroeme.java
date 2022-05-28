package Datenstroeme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Datenstroeme {
    public static void changeFile(String dateiVor, String dateiNach, char z1, char z2) {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;
        try {
            bReader = new BufferedReader(new FileReader(dateiVor));
            bWriter = new BufferedWriter(new FileWriter(dateiNach));
            String s = null;
            while (bReader.ready()) {
                s = bReader.readLine();
                String s1 = changeString(s, z1, z2);
                bWriter.write(s1);
                bWriter.newLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bWriter.close();
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String changeString(String s, char z1, char z2) {
        StringBuilder sb = new StringBuilder(s);
        for (int j = 0; j < sb.length(); j++)
            if (sb.charAt(j) == z1)
                sb.setCharAt(j, z2);
        return sb.toString();
    }

    public static void main(String[] args) {
        String dateiVor = "C:\\Users\\knechtrootrecht\\source\\repos\\github.com\\hetzlefetz\\uni-grundlagen-programmierung-ii\\Klausurvorbereitung\\Klausurvorbereitung\\src\\Datenstroeme\\dateiVor.txt";
        String dateiNach = "C:\\Users\\knechtrootrecht\\source\\repos\\github.com\\hetzlefetz\\uni-grundlagen-programmierung-ii\\Klausurvorbereitung\\Klausurvorbereitung\\src\\Datenstroeme\\dateiNach.txt";
        changeFile(dateiVor, dateiNach, 'i', 'X');
    }

}
