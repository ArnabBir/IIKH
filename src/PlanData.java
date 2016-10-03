import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class PlanData{
    String planName;
    ArrayList<String> plans;
    
     
    
    public ArrayList<String> planNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            br = new BufferedReader(new FileReader("PlanData.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }  
    
    public void addPlan(String planName, ArrayList<String> recipes){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("PlanData.txt", true)))) {
            out.println(parsetoString(planName, recipes));  
        }catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    public void getPlan(String planName){
        BufferedReader br = null;
        this.planName = null;
        this.plans = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("PlanData.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(planName)){
                    this.planName = planName;
                    this.plans = new ArrayList<String>(Arrays.asList(x[1].split("::")));
                }
            }
	} catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    private String parsetoString(String planName, ArrayList<String> recipes){
        String out = planName + ",,";
        for(String x: recipes)
            out += (x + "::");
        return out;
    }
    
    public ArrayList<String> getPlans(){
        return this.plans;
    }
}
