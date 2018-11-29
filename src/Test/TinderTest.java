package Test;
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
              {{1,1,1,1,1},
               {1,1,0,0,1},
               {1,1,0,0,1},
               {1,1,1,1,1}};
               
 const image = [[1,1,1,1,1],
                [1,1,0,0,1],
                [1,1,0,0,1],
                [1,1,1,1,1]];
topLeft to bottomRight
[(row, column), (row, column)] = [[1, 2], [2,3]]
 */

class Solution {
  
  public static int[][] image = {{1,1,1,1,1},
                        {1,0,1,0,0},
                        {1,1,1,0,0},
                        {0,0,1,1,1}};
  
  public int[] get_left_top(int[][] image) {
    int[] result = new int[2];
    for (int i=0; i< image.length;i++) {
      int[] im = image[i];
      for(int j=0; j<im.length;j++) {
        if(im[j]==0) {
            
            result[0]=j;
            result[1]=i;
            return result;
        }
      }
    }
    System.out.println("0 not found!");
    return result;
  }
  
  public int[] get_right_bottom(int[][] image) {
    int[] result = new int[2];
    for (int i=image.length-1; i> -1;i--) {
      int[] im = image[i];
      for(int j=im.length-1; j>-1;j--) {
        if(im[j]==0) {
            
            result[0]=j;
            result[1]=i;
            return result;
        }
      }
    }
    System.out.println("0 not found!");
    return result;
  }
  
  public void solution(int[][] image) {
    int[] left_top = get_left_top(image);
    int[] right_bottom = get_right_bottom(image);
    System.out.println("result=["+left_top[0]+","+left_top[1]+"],["+right_bottom[0]+","+right_bottom[1]+"]");
  }
  
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");
    Solution s = new Solution();
    s.solution(image);

    for (String string : strings) {
      System.out.println(string);
    }
  }
}