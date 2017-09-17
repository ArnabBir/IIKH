# IIKH
## Interactive Intelligent Kitchen Helper
Suppose we want to plan for our menu by planning for a meal or planning for a week or
planning for a month by sitting at a terminal, we should have the IIKH at our terminal. This is an object oriented problem where we create a graphical user interface for the user who sits at the terminal for planning his/her menu. It has a list of recipes, the ingredients used and even the method of preparing it. A user can change the existing change the existing recipe, provide a new recipe with required ingredients and its method of preparation.

### Classes

#### IIKH :: Welcome:
It is the welcome window of IIKH. There is navigation menu which has several options like meal, recipes, plans, show plan etc.

#### IIKH :: Meals:
This interface is to show and browse different meals (recipies) and select them.

#### IIKH :: Plans:
This interface is to show and browse create meal plans  and to add them delete them or remove them.

#### IIKH :: Recipes:
It has a browse option to check different recipies, adding recipoes, editing and removing them.

#### IIKH :: SelectPlan:
This Window shows different meal plans. Diay, Weekly and monthly meals can be shown here.

#### IIKH :: RecipeData:

#### Data:

##### Name:
Name of the recipe
##### Ingredients:
Ingredients required to prepare that particular recipe
##### Recipe:
Preparation method of that recipe

#### Methods:

##### public void addRecipe(String Name, ArrayList<String> ingredients, ArrayList<String> method):
Adds a particular recipe in the database. The data of that recipe is parsed in a particular string and the output string is written in “Recipedata.txt”.

##### getRecipe(String Name): 
The name of the particular recipe is taken as “Name”. We search for the recipe in the database file and when the name of the racipe matches with “Name” we get recipe as output. The instance of RecipeData class gets the name of the recipe name, ingredient and recipe as output.

##### public void editRecipe(String oldName, String newName, ArrayList<String> ingredients, ArrayList<String> recipe ):
This function edits the existing recipe. The oldName variable is searched in the database and when the search result matches, the string is fetched and new name, ingredients and recipes are assigned the the instance of the object. 

##### public void removeRecipe(String Name ): 
This function deletes a particular recipe. It takes argument Name as input and searches for the name in the database and whenever the string does not matches with the name of the recipe, it is stored in the string strline and appended to fileContent. The the database is edited and fileContent is written.

##### private String parsetoString(String Name, ArrayList<String> ingredients, ArrayList<String> recipe):  
This method is to parse the information regarding a particular recipe and save it in a particular recipe.

#### IIKH :: PlanData:

##### Data:
##### Names: Names of plans
##### Plans: Plans of meal

#### Methods:
##### public void addPlan(String Name, ArrayList<String> recipes): 
This function takes 2 arguments. Name is the name of the recipe and recipes stores the names of different recipes accordingly. It parses the name of the recipe with recipes and append it with the plan database “PanData.txt”.

##### public void editPlan(String oldName, String newName, ArrayList<String> recipes): 
This function edits the existing plan. The oldName variable is searched in the database and when the search result matches, the string is fetched and new name, and plans  are assigned the the instance of the object. 

##### public void removePlan(String Name ): 
This function deletes a particular meal plan. It takes argument Name as input and searches for the name in the database and whenever the string does not matches with the name of the plan, it is stored in the string strline and appended to fileContent variable. The the database is edited and fileContent is written.

##### private String parsetoString(String Name, ArrayList<String> recipes):
This method is to parse the information regarding a particular meal plan and save it in a particular recipe.
