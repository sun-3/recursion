package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazePathJump {

    public static void main(String[] args) {

        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int m= sr.nextInt();
        List<String> paths = getMazePath(1,1,n,m);
        System.out.println(paths);
    }
    public static List<String> getMazePath(int sr, int sc, int dr, int dc){

        if (sc== dc || sr == dr){
            List<String>bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (sr > dr || sc > dc) {
            List<String> bres = new ArrayList<>();
            return bres;
        }
        List<String> paths = new ArrayList<>();
        for (int hms = 1; hms <= dc - sc;hms++){
            List<String>hpaths = getMazePath(sr,sc+hms,dr,dc);
            for (String hpath : hpaths){
                hpaths.add("h" + hms + hpath);
            }
        }
        for (int vms = 1;vms <= dr - sr;vms++){
            List<String>vpaths = getMazePath(sr+vms,sc,dr,dc);
            for (String vpath : vpaths){
                vpaths.add("v" + vms + vpath);
            }
        }
        for (int dms = 1;dms <= dr-sr && dms <= dc - sc;dms++){
            List<String> dpaths = getMazePath(sr+dms,sc+dms,dr,dc);
            for (String dpath : dpaths){
                paths.add("d" + dms + dpath);
            }
        }
        return paths;
    }
}
