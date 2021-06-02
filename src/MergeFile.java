import java.io.*;

public class MergeFile {
    public void mergeFile() throws IOException {
        long startTime = System.currentTimeMillis();
        FileOutputStream fout = new FileOutputStream(new File("etc\\output.txt"));
        FileInputStream fin = null;
        for(int i = 9; i >= 1; i--){
            fin = new FileInputStream(new File("etc\\output"+ i + ".txt"));
            int length;
            byte[] buffer = new byte[10240000];
            while ((length = fin.read(buffer)) > 0) {
                fout.write(buffer, 0, length);
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("mergeTime: " + (endTime - startTime) / 1000);
    }
}
