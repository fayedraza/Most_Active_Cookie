import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

 class most_active_cookie{

    //finds the most active cookie according to date
    public static void main(String[]args){
        BufferedReader br = null;  
    try{
         br  = new BufferedReader(new FileReader(args[0]));
        String line = "";

        //declare a linked hashmap so we know which cookie appear in order of occurence in the log
        Map<String, Integer> cookiesFrequency = new LinkedHashMap<String, Integer>();
        int maxAmount = 0;
        boolean added = false;

        while((line = br.readLine()) != null){
            if(line.indexOf(",")!= -1 ){ //check to make sure that the input is valid
                String[] currentCookie = line.split(",");

                //check to see if cookie's date matches with date given
                if(currentCookie[1].startsWith(args[2])){
                    added = true;

                    //add it to a hashmap
                    cookiesFrequency.put(currentCookie[0],cookiesFrequency.getOrDefault(currentCookie[0],0)+1);

                    //keep track of the larget occurence
                    maxAmount = Math.max(maxAmount,cookiesFrequency.get(currentCookie[0]));
                

                }else if(added){
                    //if it does not match with date and added is true that means the future cookies time will 
                    //no longer be within the same date range
                    break;
                }
            }
        }

        if(br != null)
        br.close();

        //check which cookie has the max frequency
        for(String cookie : cookiesFrequency.keySet()){
            if(cookiesFrequency.get(cookie) == maxAmount){
                    System.out.println(cookie);
            }
        }


    }catch(Exception e){  //stops if any exception happens (ex: file is not found)
         
    }finally{
        if(br != null){
            try{  
                br.close();
            }catch(Exception e){

            }
        }
      
    }


    }
}