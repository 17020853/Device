import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class WriteThread implements Runnable{
    String url;
    int warrantyYear;
    boolean state = true;

    BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    public WriteThread(int warrantyYear) {
        this.url = "etc\\output" + warrantyYear + ".txt" ;
    }

    public void putLine (String line) throws InterruptedException {
        blockingQueue.put(line);
    }

    public void push(String data) {
        blockingQueue.add(data);
    }
    public void stop() {
        this.state = false;
        blockingQueue.add("STOP");
    }

    @Override
    public void run() {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            FileOutputStream fout = new FileOutputStream(url);
            int i = 0;
            while (this.state) {
                i++;
                line = blockingQueue.poll();
                if (line == null) {
                    continue;
                }
                if ("STOP".equals(line)) {
                    break;
                }
                String txt[] = line.split(",");
                sb.append(txt[0]).append(",")
                        .append(txt[1]).append(",")
                        .append(nomalize(txt[2])).append(",")
                        .append(txt[3]).append(",")
                        .append(txt[4]).append("\n");

                if(i % 1000 == 0){
                    fout.write(sb.toString().getBytes());
                    sb.delete(0, sb.length());
                }
            }
            fout.write(sb.toString().getBytes());
        } catch (IOException e) {
        }
    }

    public String nomalize(String txt){

        String st = txt;
        st=st.trim().toLowerCase();
        st = st.replaceAll("\\s+", " ");
        String[] temp= st.split(" ");
        st="";
        for(int i=0;i<temp.length;i++) {
            st+=String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i<temp.length-1)
                st+=" ";
        }

        return st;

    }

}
