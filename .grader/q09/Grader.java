import java.io.*;
public class Grader {
    static final String[][] T = {
        {"2\n1 2\n3 4\n5 6\n7 8","19 22\n43 50"},
        {"2\n1 0\n0 1\n4 5\n6 7","4 5\n6 7"},
        {"3\n1 2 3\n4 5 6\n7 8 9\n9 8 7\n6 5 4\n3 2 1","30 24 18\n84 69 54\n138 114 90"},
    };
    static String run(String in) throws Exception {
        ProcessBuilder pb=new ProcessBuilder("java","-cp","src/q09","Main");
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
            System.out.println((ok?"✅":"❌")+" Q09 Test "+(i+1)+": "+(ok?"PASS":"FAIL | Expected:\n"+exp+"\nGot:\n"+got));
        }
        System.out.println("Q09: "+pass+"/"+T.length); if(pass<T.length)System.exit(1);
    }
}
