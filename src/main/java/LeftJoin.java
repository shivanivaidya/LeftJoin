import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class LeftJoin {

	public static void main(String args[]) throws IOException {
		// Print usage and exit if incorrect arguments are passed.
    	if(args.length != 3) {
      		System.out.println("\nUsage: java LeftJoin <leftFileName> <rightFileName> <outputFileName>");
      		System.exit(1);
    	}

    	LeftJoin leftJoin = new LeftJoin();

    	/* Function call to process files.
     	 * args(0) -> leftFileName
     	 * args(1) -> rightFileName
     	 * args(2) -> outputFileName
     	*/
    	leftJoin.processFiles(args[0], args[1], args[2]);
	}

	// Process leftFile and rightFile and write the output of left join to outputfile.
	public void processFiles(String leftFileName, String rightFileName, String outputFileName) throws IOException {
		// Load lines from rightFile into a hashmap such that key -> id and value -> rest of the line.
		HashMap<String, String> rightFileMap = new HashMap<String, String>();

		File rightFile = new File(rightFileName);
		BufferedReader reader = new BufferedReader(new FileReader(rightFile));

		String line;

		// parts[0] -> id , parts[1] -> rest of the line
		while((line = reader.readLine()) != null) {
			String[] parts = line.split(",",2);
			rightFileMap.put(parts[0], parts[1]);
		} 

		// Initialize outputfile writer
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName,false));

		// Initialize leftFileReader
		File leftFile = new File(leftFileName);
		reader = new BufferedReader(new FileReader(leftFile));

		// Read lines from leftFile
		while((line = reader.readLine()) != null) {
			// Write lines from leftFile to the outputFile
			writer.write(line);

			String[] parts = line.split(",",2);
			String id = parts[0];

		   /* If an id match is found in the rightFile, append the contents of the 
         	* rightFile line to the current line in outputFile else, just append commas. */
			if(rightFileMap.containsKey(id)) {
				writer.append("," + rightFileMap.get(id));
			}
			else {
				writer.append(",,");
			}

			writer.append("\n");
		} 

		writer.close();
	}
}