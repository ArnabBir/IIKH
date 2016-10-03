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
    
    private String parsetoString(String planName, ArrayList<String> recipes){
        String out = planName + ",,";
        for(String x: recipes)
            out += (x + "::");
        return out;
    }
    public void addPlan(String planName, ArrayList<String> recipes){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planList.txt", true)))) {
            out.println(parsetoString(planName, recipes));  
        }catch (IOException e) {
            e.printStackTrace();
        }
    }  
    public ArrayList<String> planNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            br = new BufferedReader(new FileReader("planList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    public void getPlan(String planName){
        BufferedReader br = null;
        this.planName = null;
        this.plans = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("planList.txt"));
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
    public void editPlan(String oldplanName, String newplanName, ArrayList<String> recipes){

    	try {
            FileInputStream fstream = new FileInputStream("planList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    if (tokens[0].equals(oldplanName)) {  
                        System.out.print("here");
                        String newLine = parsetoString(newplanName, recipes);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            FileWriter fstreamWrite = new FileWriter("planList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
        
    public void removePlan(String planName ){
        try {
            FileInputStream fstream = new FileInputStream("planList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    if (!tokens[0].equals(planName)) {  
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            FileWriter fstreamWrite = new FileWriter("planList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public ArrayList<String> getPlans(){
        return this.plans;
    }
}
