
import java.util.HashMap;
import java.util.Map;

public class WriteThreadFactory {


    private WriteThreadFactory(){};
    static Map<Integer, WriteThread> threads = new HashMap<>();
    public static WriteThread getThreadPool(int year){
        if(threads.get(year) == null){
            threads.put(year, new WriteThread(year));
            Thread t = new Thread(threads.get(year));
            t.start();
        }
        return threads.get(year);
    }
    public static void stopThread() {
        threads.entrySet().stream().map((thread) -> {
            System.out.println(thread.getKey() + "completed");
            return thread;
        }).map((thread) -> thread.getValue()).forEachOrdered((threadPool) -> {
            threadPool.stop();
        });
    }

}
