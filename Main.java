import java.io.*;

public class Main {
    public static void main (String[] args) {
    
        try{        
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            StringBuilder str = new StringBuilder();
            String line;
            
            while ((line = in.readLine()) != null) {
            
                //read parameters
                String[] lineArray = line.split("\\s");                
                if (lineArray.length > 0) {
                
                    int p = Integer.valueOf(lineArray[0]);
                    for (int i = 2; i <= p; i++) {
                        boolean f = true;
                        
                        //reduce scale of looping
                        double l = java.lang.Math.sqrt(i+1);
                        
                        for (int j = 2; j < l; j++) {
                            if (i % j == 0) {
                                f = false;
                                break;
                            }
                        }
                        if (f) {
                        
                            //create output using stringbuilder
                            str.append(i);
                            str.append(",");
                        }
                    }
                    
                    //print and reset stringbuilder
                    str.delete(str.length()-1, str.length());
                    System.out.println(str);
                    str.setLength(0);
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
