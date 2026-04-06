import java.io.*;
public class Grader {
    static final String[][] T = {
        {"4\n6 13 8 28","Perfect\nPrime\nNeither\nPerfect"},
        {"3\n2 4 496","Prime\nNeither\nPerfect"},
        {"4\n1 7 12 17","Neither\nPrime\nNeither\nPrime"},
    };
    static String run(String in) throws Exception {
        ProcessBuilder pb=new ProcessBuilder("java","-cp","src/q04","Main");
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
            System.out.println((ok?"✅":"❌")+" Q04 Test "+(i+1)+": "+(ok?"PASS":"FAIL | Expected:\n"+exp+"\nGot:\n"+got));
        }
        System.out.println("Q04: "+pass+"/"+T.length); if(pass<T.length)System.exit(1);
    }
}
