package turing;

import enigma.Enigma;  // The Enigma machine
import enigma.Setting; // A specific set of rotors, rotor positions, and ring settings

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

// This class reads encrypted text from filename

public class BreakEnigmaFile {
    // You may need to add one or more private fields here to enable threading.
    // That is fine and expected!
    
    // This is the filename with the encrypted string / decrypted hashcode / settings
    //   triples, which are sorted from fastest to slowest to break.
    //
    // You'll select the number of encrypted triples to break on the command line.
    //   Find a value that runs on your machine from 45 seconds to a minute.
    //
    // (Yes, the third part of the triple is the solution to the break attempt,
    //  which was helpful to me in extensively debugging my code. Do NOT use it!
    //  We're practicing our thread skills, NOT our cheating skills! :D :D :D )
    private final static String filename = "input.txt";
    
    // Breaker adds the actual hashCode for each decrypted string to hashCodeSum.
    // We print it after solving each file to ensure all decryptions succeeded!
    // Once your code is threaded, be sure to verify that you're getting this right.
    private static int hashCodeSum = 0;

    // This is the list of encrypted string / expected hashcode pairs to break.
    // The first argument specifies how many to load from filename.
    // IMPORTANT: ArrayList is NOT thread-safe! If you read or write it within
    //   a thread, you MUST take precautions as discussed in Lecture 14!
    private static List<EncryptedPair> encrypteds = new ArrayList<>();
    
    // -------------------------------------------------------------------
    // MAIN!
    public static void main(String[] args) {
    
        // You must supply either 1 or 2 parameters:
        // The first is the number of encrypted strings to read from filename.
        // The (optional) second is the number of threads to use for breaking,
        //   which is code YOU must add for this assignment!
        if(args.length == 0 || args.length > 2) {
            System.err.println("usage: java BreakEnigma <#lines> [<threads>]");
            System.exit(-1);
        }
        
        final int numStrings = Integer.parseInt(args[0]);
        final int numThreads = (args.length == 2) ? Integer.parseInt(args[1]) : 1;
        
        // Read the requested number of encrypted strings from filename
        //   into the decrypteds ArrayList. These are the encryptions to break.
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while(encrypteds.size() < numStrings) {
                String encrypted = br.readLine();
                int decryptedHashCode = Integer.parseInt(br.readLine());
                String settings = br.readLine(); // Do NOT use this one!
                
                encrypteds.add(new EncryptedPair(encrypted,decryptedHashCode));
            }
        } catch(Exception e) {
            System.err.println("ERROR reading " + filename + ": " + e);
            System.exit(-2);
        } 

    //                         ASSIGNMENT P07
    // ==================================================================
    // Rewrite this section to split the work between numThreads threads!
    
        // marker and pattern indicate how long each string takes to break.
        // OMIT THEM in your threaded version.
        // Instead, add "+++Starting thread nnn" and "###Ending thread nnn"
        //   messages to your breakManager rewrite to monitor thread status.
        int marker = 0;                          // omit
        String pattern = "....,....,....,....:"; // omit
        
        // Solve each of the encrypted pairs
        for(int i=0; i<encrypteds.size(); ++i) {
            BreakEnigmaFile breaker = new BreakEnigmaFile();
            breaker.breakManager(i, numThreads);
            
            System.out.print(pattern.charAt(marker++ % 20)); // omit
        }
        System.out.println("\n\nVERIFY checksum of all decryptions is " + hashCodeSum);
    }
    
    // -------------------------------------------------------------------
    // breakManager will become the "main" for each of the threads
    //   you create in your rewrite of teh above code.
    // REWRITE breakManager. Instead of solving just the encrypted string 
    //   at the index, iterate over the encrypteds array **by numThreads**
    //   and then solve them.
    // For example, if index is 0 and numThreads is 5, you would loop
    //   to solve encrypteds indices 0, 5, 10, 15, ... until the end.
    public void breakManager(int index, int numThreads) {
        EncryptedPair pair = null;
        pair = encrypteds.get(index); // NOT thread-safe!
        breakIt(pair.encrypted, pair.decryptedHashcode);
    }
    // End section to be rewritten (but see another small section below!)
    // ==================================================================

    
    // -------------------------------------------------------------------
    // This is the method that attempts to break the encryption by brute force.
    // It begins to attempt every possible rotor combination with every rotor
    //   position and every ring setting. Testing them all would take a LONG time,
    //   but it exits as soon as it finds the solution - so the earlier in the
    //   series of combinations it finds the solution, the faster it runs.
    // Once the correct setting is found, the hashCode for the decrypted string
    //   is added to hashCodeSum (to ensure we found them all) and then it returns.
    
    // Modify ONLY the line marked below!!!
    
    public void breakIt(String text, int hashcode) {
        for(var rotor1 : Enigma.rotors) {
           for(var rotor2 : Enigma.rotors) {
             if(rotor1 == rotor2) continue;
             for(var rotor3 : Enigma.rotors) {
               if(rotor1 == rotor3 || rotor2 == rotor3) continue;
               for(var rp1 : Enigma.positions) {
                 for(var rp2 : Enigma.positions) {
                   for(var rp3 : Enigma.positions) {
                     for(var rs1 : Enigma.positions) {
                       for(var rs2 : Enigma.positions) {
                         for(var rs3 : Enigma.positions) {
                           Setting setting = new Setting( // Test this Enigma setting
                             new String[]{rotor1, rotor2, rotor3}, // Rotors
                             new int[]{rp1, rp2, rp3},             // Rotor positions
                             new int[]{rs1, rs2, rs3});            // Ring settings
                           String decrypted = (new Enigma(setting)).encrypt(text);
                           
                           if(decrypted.hashCode() == hashcode) {
                               // =======================================
                               // Protect hashCodeSum from data corruption!
                               hashCodeSum += decrypted.hashCode(); // NOT threadsafe!
                               // End data protection region
                               // =======================================
                               return;
                           }
                         }
                       }
                     }
                   }
                 }
               }
             }
           }
        }
    }
}
