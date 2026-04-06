import java.io.*;
public class Grader {
    static final String[][] T = {
        {"1","0"},{"2","0 1"},{"7","0 1 1 2 3 5 8"},{"10","0 1 1 2 3 5 8 13 21 34"},
    };
    static String run(String in) throws Exception {
        ProcessBuilder pb=new ProcessBuilder("java","-cp","src/q06","Main");
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
            System.out.println((ok?"✅":"❌")+" Q06 Test "+(i+1)+": "+(ok?"PASS":"FAIL | Expected: "+exp+" | Got: "+got));
        }
        System.out.println("Q06: "+pass+"/"+T.length); if(pass<T.length)System.exit(1);
    }
}
