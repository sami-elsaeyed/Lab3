/*Data is input from a CSV file cointainng list of song title artist and number of streams.
 * Code orders list in alphabetical order and prints only unique elements of list based on artist name.
 * Counts total number of times each artist appears in Top 200 list but only prints once.
 * Outputs each unique artist followed by number of appearances.
 */
import java.util.*;
import java.io.*;
public class Lab3 {
    public static void main(String[] args) throws Exception {
      //Create,output PrintWriter Scanner,input file,2D Array\
      File file = new File("MusicData.csv");
      Scanner scan= new Scanner(file,"UTF-8").useDelimiter("\\s*,\\s*");
      String s;
      String [][] data=new String[200][4]; 
      //Nested 'for' loop to fill in array 
      for(int i=0;i<200;i++){
        for(int k=0;k<4;k++){
          data[i][k]=scan.next();
        }  
        s=scan.nextLine(); 
      }
      //Methods take care of ordering and getting rid of repetitons in the original list.
      sort(data);
      String[][] report=artists(data);
      //Method makes the sorted array of unique artist into a Linked List
      linkedList(report);
    }/*Method recieves 4 column array and creates a new array with two columns.
     * Returns new array to main method
     */
    public static String[][] artists(String [][] data){
      String[][] report = new String[200][2];
      //Double nested for loop
      for(int m=0;m<200;m++){
        boolean print=true;
        int repeat=0;
        //nested loop that prints unique artist names 
        for(int n=0;n<m;n++){
          if(data[m][2].equals(data[n][2])){
            print=false;
            break;
          }
        }
        if(print){
          report[m][0]=data[m][2];
          //nested loop that counts repetitons
          for(int k=0;k<200;k++){
            if(report[m][0].equals(data[k][2])){
            repeat++;
            }  
          }
        }
      }
    return report;
    }/*Method recieves 4 column array
     * Bubble sort array in ascending alphabetical order.
     */
      public static void sort(String[][] data)throws Exception{
      boolean swapped;
      String temp;
      do{
        swapped=false;
        for(int d=0;d<data.length-1;d++){
          if(data[d][2].compareTo(data[d+1][2])<0){
            temp=data[d][2];
            data[d][2]=data[d+1][2];
            data[d+1][2]=temp;
            swapped=true;
          } 
        }
      }while(swapped);
    }/*Method uses Linked Lit classes to enterte arra into a list and print.
     */
    public static void linkedList(String[][] report)throws Exception{
      LinkedList topArtists=new LinkedList();
      for(int i=0;i<200;i++){
        if(report[i][0]!=null){
        topArtists.insertFirst(report[i][0]);
        }
      }
      topArtists.displayList();
    }
}

    
    
    

    
    
  
     
  


