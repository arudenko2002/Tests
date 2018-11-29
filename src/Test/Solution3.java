package Test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {
    Solution3() {
    String line;
    Scanner stdin = new Scanner(System.in);
    line = stdin.nextLine();
    String[] tokens2 = line.split(" ");
    int length=Integer.parseInt(tokens2[0]);
    int tests = Integer.parseInt(tokens2[1]);
    line = stdin.nextLine();
    String[] widths = line.split(" ");
    //int length=Integer.parseInt(tokens[0]);
    //int tests = Integer.parseInt(tokens[1]);
    int count=0;
    while(stdin.hasNextLine() && !( line = stdin.nextLine() ).equals( "" )&&count<=tests)
    {
        String[] tokens = line.split(" ");
        int indexi=Integer.parseInt(tokens[0]);
        int indexj=Integer.parseInt(tokens[1]);
        int minwidth=Integer.parseInt(widths[indexi]);
        for(int i=indexi+1;i< indexj+1;i++) {
            if(Integer.parseInt(widths[i])<minwidth) minwidth = Integer.parseInt(widths[i]);
        }
        System.out.println(minwidth);
        count++;
    }
    stdin.close();
}

public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Solution3 s = new Solution3();
}
}
