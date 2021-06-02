import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NomalizeData {

    public void nomalize() throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("etc\\input.txt"));

        String line = "";
        while (true) {
            line = br.readLine();
            if(line == null) {
                break;
            }
            WriteThread writeThread = WriteThreadFactory.getThreadPool(line.charAt(line.length()-1) - '0');
            writeThread.push(line);
        }
        WriteThreadFactory.stopThread();
        long endTime = System.currentTimeMillis();
        System.out.println("nomalizeTime: " + (endTime - startTime) / 1000);
    }
}
