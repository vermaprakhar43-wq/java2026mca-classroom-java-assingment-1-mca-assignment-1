import java.io.*;
public class Grader {
    static final String[][] T = {
        {"5 1 2 + 4 * + 3 -","14"},
        {"2 3 + 4 *","20"},
        {"5 3 - 2 *","4"},
        {"10 2 8 * + 3 -","23"},
        {"4 13 5 / +","6"},
    };
    static String run(String in) throws Exception {
        ProcessBuilder pb=new ProcessBuilder("java","-cp","src/q10","Main");
        pb.redirectErrorStream(true); Process p=pb.start();
        p.getOutputStream().write((in+"\n").getBytes());
        p.getOutputStream().flush(); p.getOutputStream().close();
        String o=new String(p.getInputStream().readAllBytes()).stripTrailing(); p.waitFor(); return o;
    }
    public static void main(String[] a) throws Exception {
        int pass=0;
        for(int i=0;i<T.length;i++){
            String got=run(T[i][0]).strip(), exp=T[i][1].strip();
            boolean ok=got.equals(exp); if(ok)pass++;
            System.out.println((ok?"✅":"❌")+" Q10 Test "+(i+1)+": "+(ok?"PASS":"FAIL | Expected: "+exp+" | Got: "+got));
        }
        System.out.println("Q10: "+pass+"/"+T.length); if(pass<T.length)System.exit(1);
    }
}
