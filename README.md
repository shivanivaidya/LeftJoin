# LeftJoin

All files and folders:

1) bin - All the Java and Scala class files and binaries will get stored in this folder after compilation of the Java and Scala programs.

2) data_files - employee_names.csv and employee_pay.csv files are stored in this folder. Any other input csv files can also be stored here. The output files from the Java or Scala programs also get generated in this folder.

3) src - The source codes for the Java and Scala versions of LeftJoin are stored in src/main/java and src/main/scala folders respectively.

4) LeftJoinJavaRunner - This is an executable file that compiles and runs the java code for LeftJoin. The instructions on how to run it are given in the next section.

5) LeftJoinScalaRunner - This is an executable file that compiles and runs the Scala code for LeftJoin. The instructions on how to run it are given in the next section.

6) Task2.pdf - Contains pseudo code with screenshots for Task2.

-----------------------------------------------------------------------------------------------------------------------------------------
TASK 1
-----------------------------------------------------------------------------------------------------------------------------------------

Left join or left outer join returns all rows from the table on the left and only returns those rows from the table on the right which have a matching id or join field value in the left table. The algorithm used for solving the task1 is as follows:

Step 1

Read lines from the rightFile and split each line on the first comma such that the text on the left of this comma (id) is the key and rest of the text is the value. Store all the key-value pairs in a HashMap since it has O(1) search time.

Step 2

Since all the lines from the leftTable should be returned, read the leftFile and for each line read, do the following:

- Write the entire line to file.
- Split it on the first comma such that the text to it's left is the key (id) and that to it's right is the value.
- Use this id to search the HashMap to identify if there's a corresponding row found in the rightFile.
- If found, append a comma and the value of that id stored in the Hashmap to the current line in the output file.
- If not found, append two commas to the current line in the output file to indicate null values.
- Append a new line character.

The instructions on how to run the Java and Scala programs are given below:

1) Java program for LeftJoin:
1. Assumption: Java is installed correctly.
2. On terminal, navigate to the LeftJoin project directory.
3. Run the following command:

	./LeftJoinJavaRunner

4. The output file will get generated in the LeftJoin/data_files folder with the name - "leftjoin_java_output.csv"

2) Scala program for LeftJoin:
1. Assumption: Java and Scala are installed correctly.
2. On terminal, navigate to the LeftJoin project directory.
3. Run the following command:
	
   ./LeftJoinScalaRunner

4. The output file will get generated in the LeftJoin/data_files folder with the name - "leftjoin_scala_output.csv"
