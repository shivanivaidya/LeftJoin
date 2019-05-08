import scala.io.Source
import java.io.{BufferedWriter, FileWriter}

object LeftJoin {
  
  def main(args: Array[String]): Unit = {
    // Print usage and exit if incorrect arguments are passed.
    if(args.size != 3) {
      println("\nUsage: scala LeftJoin <leftFileName> <rightFileName> <outputFileName>")
      System.exit(1)
    }

    /* Function call to process files.
     * args(0) -> leftFileName
     * args(1) -> rightFileName
     * args(2) -> outputFileName
     */
    processFiles(args(0), args(1), args(2))
  }

  // Process leftFile and rightFile and write the output of left join to outputfile.
  def processFiles(leftFileName: String, rightFileName: String, outputFileName: String): Unit = {
    // Load lines from rightFile into a hashmap such that key -> id and value -> rest of the line.
    val rightFileMap = io.Source.fromFile(rightFileName).getLines.map { 
      line => 
        val Array(id,rest) = line.split(",",2)
        id -> rest 
    }.toMap

    // Initialize outputfile writer
    val writer = new BufferedWriter(new FileWriter(outputFileName));
    
    // Read lines from leftFile
    io.Source.fromFile(leftFileName).getLines.foreach { 
      line => 
       // Write lines from leftFile to the outputFile
        writer.write(line)
        val Array(id,rest) = line.split(",",2)

        /* If an id match is found in the rightFile, append the contents of the 
         * rightFile line to the current line in outputFile else, just append commas. */
        if(rightFileMap.contains(id))
          writer.append("," + rightFileMap(id))
        else 
          writer.append(",,")
        writer.append("\n")
    }

    writer.close()
  }
}