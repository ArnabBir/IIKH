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

public class RecipeData {
    String Name;
    ArrayList<String> ingredients;
    ArrayList<String> recipe;
    
    public void addRecipe(String Name, ArrayList<String> ingredients, ArrayList<String> recipe){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("RecipeData.txt", true)))) {
            out.println(parsetoString(Name, ingredients, recipe));  
        }catch (IOException e) {
            e.printStackTrace();
        }
    }  
    
    public ArrayList<String> repNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            br = new BufferedReader(new FileReader("RecipeData.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    
    public void getRecipe(String Name){
        BufferedReader br = null;
        this.Name = null;
        this.ingredients = null;
        this.recipe = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("RecipeData.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(Name)){
                    this.Name = Name;
                    this.ingredients = new ArrayList<String>(Arrays.asList(x[1].split("::")));
                    this.recipe = new ArrayList<String>(Arrays.asList(x[2].split("::")));
                }
            }
	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void editRecipe(String oldName, String newName, ArrayList<String> ingredients, ArrayList<String> recipe ){
        try {
            FileInputStream fstream = new FileInputStream("RecipeData.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    if (tokens[0].equals(oldName)) {  
                        String newLine = parsetoString(newName, ingredients, recipe);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            FileWriter fstreamWrite = new FileWriter("RecipeData.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void removeRecipe(String Name ){
        try {
            FileInputStream fstream = new FileInputStream("RecipeData.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    if (!tokens[0].equals(Name)) {  
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            FileWriter fstreamWrite = new FileWriter("RecipeData.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
        } catch (Exception e) {}
    }
    
    private String parsetoString(String Name, ArrayList<String> ingredients, ArrayList<String> recipe){
        String out = Name + ",,";
        for(String x: ingredients)
            out += (x + "::");
        out += ",,";
        for(String x: recipe)
            out += (x + "::");
        return out;
    }
    
    public ArrayList<String> getingredients(){
        return this.ingredients;
    }
    
    public ArrayList<String> getrecipe(){
        return this.recipe;
    }

}
