/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 File:    ReadGameFile.java
 Date:    6/4/10
 Author:  Bill Dell'Anno
 Purpose: Reads in the text file with the game moves
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class ReadGameFile {

    public ArrayList<String> loadMoves(String fileName) { // pass in file name to read

        //fileName = "test.txt"; // use temp file name to mess with
        ArrayList<String> temp = new ArrayList<String>(); //creates temp arraylist
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileName));

            //Read the first move or find and end of file
            String tempLine;
            tempLine = br.readLine();

            for (int i = 0; tempLine != null; i++) { //Loop as long as there are more
                if (tempLine.equals("")) { // after all moves have been read, breaks loop
                    break;
                }
                //Put this stuff in the arrayList
                temp.add(tempLine);
                //move to next line
                tempLine = br.readLine();
            }
            //Close the stream
            br.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

}
