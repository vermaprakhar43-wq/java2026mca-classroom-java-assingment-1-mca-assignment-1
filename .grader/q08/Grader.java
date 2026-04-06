import java.io.*;
public class Grader {
    static final String[][] T = {
        {"6\nPUSH 10\nPUSH 20\nPEEK\nPOP\nPOP\nPOP","20\n20\n10\nEMPTY"},
        {"4\nPOP\nPUSH 5\nSIZE\nPOP","EMPTY\n1\n5"},
        {"7\nPUSH 1\nPUSH 2\nPUSH 3\nSIZE\nPOP\nSIZE\nPEEK","3\n3\n2\n2"},
    };
    static String run(String in) throws Exception {
        ProcessBuilder pb=new ProcessBuilder("java","-cp","src/q08","Main");
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
            System.out.println((ok?"✅":"❌")+" Q08 Test "+(i+1)+": "+(ok?"PASS":"FAIL | Expected:\n"+exp+"\nGot:\n"+got));
        }
        System.out.println("Q08: "+pass+"/"+T.length); if(pass<T.length)System.exit(1);
    }
}
