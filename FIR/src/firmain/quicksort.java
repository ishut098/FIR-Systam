package firmain;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class quicksort {
   public static int partition(String[] stringArray, int idx1, int idx2) {
        String pivotValue = stringArray[idx1];
        while (idx1 < idx2) {
           String value1;
           String value2;
           while ((value1 = stringArray[idx1]).compareTo( pivotValue ) < 0) {
               idx1 = idx1 + 1;
           }
           while ((value2 = stringArray[idx2]).compareTo( pivotValue ) > 0) {
               idx2 = idx2 - 1;
           }
           stringArray[idx1] = value2;
           stringArray[idx2] = value1;
        }
        return idx1;
    }
    public static void QuicksortString(String[] stringArray, int idx1, int idx2) {
        if (idx1 >= idx2) {
            return;
        }
        int pivotIndex = partition(stringArray, idx1, idx2);
        QuicksortString(stringArray, idx1, pivotIndex);
        QuicksortString(stringArray, pivotIndex+1, idx2);
     }

    public static void QuicksortString(String[] stringArray) {
        QuicksortString(stringArray, 0, stringArray.length - 1);
    }
    private static void printArray( String[] stringArray )
    {
        FileWriter writer = null;
       try {
           writer = new FileWriter("D:\\1AT15IS034\\6th sem\\sortfinal.txt", false);
           BufferedWriter bw = new BufferedWriter(writer);
           for (String s:stringArray) {
               System.out.print( s + " " );
               bw.write(s);
               bw.newLine();
           }
           bw.close();
       } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
       } finally {
           try {
               writer.close();
           } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, ex);
           }
       }
    }

    /**
     *
     */
    public static void quick()
    {
       try {
           try {
            String firno;
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get("D:\\1AT15IS034\\6th sem\\register.txt"));
          
            String name = "";
            char buffer[];
            FileWriter writer = new FileWriter("D:\\1AT15IS034\\6th sem\\sorted.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String line : lines) {
                
                    firno="";
                    name="";
                    buffer=line.toCharArray();
                    int j = 0;
                    
                        while(buffer[j]!=':'){
                            firno+=buffer[j++];
                        }j++;
                        //System.out.println(j+" done");
                        while(buffer[j]!='|')
                           name+=buffer[j++];
                        j++;
                        try
                           {  
                            bufferedWriter.write(name+":"+firno+"|");
                            bufferedWriter.newLine();
                           
                           }catch(Exception e){
            
                                e.printStackTrace();
                            }
            }
            bufferedWriter.close();
            } catch (IOException e) {
            // looks like the file not found with given path
                e.printStackTrace();
            }
    //After this we are implementing Quick Sort
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get("D:\\1AT15IS034\\6th sem\\sorted.txt"));
        String[] mySampleStringArray = lines.toArray(new String[lines.size()]);
        QuicksortString( mySampleStringArray );
        printArray(mySampleStringArray);
       
       } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
       }
    }   
}
