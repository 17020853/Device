import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class GenerateData {
    private static String[] listCode = {"ERICVTTEK01","NOKIAGHTK02", "HUANET03", "APPHTEK04"};
    private static String[] listName = {"MSC ERICSSON", "EPC HUAWEI", "MSC NOKIA", "EPC VIETTEL"};
    private static String[] listfirstName = {" NgUyen", " LE", " PhAm", "trAn "};
    private static String[] listmidName = {" VAN "," ThI ", " HA ", "  LINh"};
    private static String[] listlastName = {" VAN "," ThI ", " HA ", "  LINh"};

    public void genData() throws IOException {
        long startTime = System.currentTimeMillis();
        FileOutputStream fos = new FileOutputStream("etc\\input.txt");
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 100000000; i++) {
            sb.append(listCode[random.nextInt(listCode.length)]).append(",")
                    .append(listName[random.nextInt(listName.length)]).append(",")
                    .append(listlastName[random.nextInt(listlastName.length)])
                    .append(listmidName[random.nextInt(listmidName.length)])
                    .append(listfirstName[random.nextInt(listfirstName.length)]).append(",")
                    .append("10/11/1999").append(",")
                    .append(random.nextInt(9) + 1).append("\n");

            if(i % 1000 == 0){
                fos.write(sb.toString().getBytes());
                sb.delete(0, sb.length());
            }
        }
        fos.write(sb.toString().getBytes());
        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("genTime: " + (endTime - startTime) / 1000);

    }
}
