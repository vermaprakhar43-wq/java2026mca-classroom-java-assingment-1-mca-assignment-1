import java.io.*;
public class Grader {
    static final String[][] T = {
        {"circle 7","Area: 153.94"},{"rectangle 4 6","Area: 24.00"},
        {"triangle 3 4 5","Area: 6.00"},{"circle 1","Area: 3.14"},
        {"triangle 5 5 5","Area: 10.83"},
    };
    static String run(String in) throws Exception {
        ProcessBuilder pb=new ProcessBuilder("java","-cp","src/q05","Main");
        pb.redirectErrorStream(true); Process p=pb.start();
        p.getOutputStream().write((in+"\n").getBytes());
        p.getOutputStream().flush(); p.getOutputStream().close();
        String o=new String(p.getInputStream().readAllBytes()).stripTrailing(); p.waitFor(); return o;
    }
    public static void main(String[] a) throws Exception {
        int pass=0;
        for(int i=0;i<T.length;i++){
            String got=run(T[i][0]).replaceAll("\r\n","\n").strip(), exp=T[i][1].strip();
            boolean ok=got.equals(exp); if(ok)pass++;
            System.out.println((ok?"✅":"❌")+" Q05 Test "+(i+1)+": "+(ok?"PASS":"FAIL | Expected: "+exp+" | Got: "+got));
        }
        System.out.println("Q05: "+pass+"/"+T.length); if(pass<T.length)System.exit(1);
    }
}
