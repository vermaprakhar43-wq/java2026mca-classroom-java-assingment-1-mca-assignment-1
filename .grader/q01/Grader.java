import java.io.*;
public class Grader {
    static final String[][] T = {
        {"1","*"},
        {"2"," *\n* *\n *"},
        {"3","  *\n * *\n*   *\n * *\n  *"},
        {"4","   *\n  * *\n *   *\n*     *\n *   *\n  * *\n   *"},
    };
    static String run(String in) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java","-cp","src/q01","Main");
        pb.redirectErrorStream(true); Process p=pb.start();
        p.getOutputStream().write((in+"\n").getBytes());
        p.getOutputStream().flush(); p.getOutputStream().close();
        String o=new String(p.getInputStream().readAllBytes()).stripTrailing(); p.waitFor(); return o;
    }
    public static void main(String[] a) throws Exception {
        int pass=0;
        for(int i=0;i<T.length;i++){
            String got=run(T[i][0]).replaceAll("\r\n","\n").strip();
            String exp=T[i][1].strip();
            boolean ok=got.equals(exp); if(ok)pass++;
            System.out.println((ok?"✅":"❌")+" Q01 Test "+(i+1)+": "+(ok?"PASS":"FAIL | Expected:\n"+exp+"\nGot:\n"+got));
        }
        System.out.println("Q01: "+pass+"/"+T.length); if(pass<T.length)System.exit(1);
    }
}
