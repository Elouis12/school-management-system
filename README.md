# Getting Started


### SETTING UP JAVAFX
1. make sure the javafx lub folder is contained within the libraries, go to ( IN INTELLIJ ) :
    - File
    - Project Structure
    - Libraries
    - "+"
    - add the path to the lib folder
    
2. add / edit the configurations
    - Run
    - Edit Configurations
    - Edit VM Options
    - ( paste ) --module-path
      PATH_TO_THE_JAVAFX_LIB_FOLDER
      --add-modules=javafx.controls,javafx.fxml

### SETTING UP MYSQL DRIVER

1. download the driver from [here](https://dbschema.com/jdbc-driver/MySql.html)
   - File
   - Project Structure
   - Libraries
   - "+"
   - add the path to the lib folder