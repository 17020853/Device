

import com.sun.tools.javah.Gen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {



    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();

        GenerateData phase1 = new GenerateData();
        phase1.genData();
        NomalizeData phase2 = new NomalizeData();
        phase2.nomalize();
        MergeFile phase3 = new MergeFile();
        phase3.mergeFile();

        long endTime = System.currentTimeMillis();
        System.out.println("totalTime: " + (endTime - startTime) / 1000);
    }


}


