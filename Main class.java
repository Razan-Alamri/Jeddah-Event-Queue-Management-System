
/*
** Name: Razan Arif Alamri
** 9-12-2022
*/
package finallab2022_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main class
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        File InputFile = new File("input.txt");

        if (!InputFile.exists()) {

            System.out.println("input file, " + InputFile + "dose not exist");

            System.exit(0);

        }

        // create output file :
        File outputFile = new File("output.txt");

        // create a printwritter to write to the output files
        PrintWriter output = new PrintWriter(outputFile);

        // Print a welcoming message to the output file
        // ----------------------------------------------
        output.println("	 Welcome to Jeddah Event 2022\n"
                + "	---------------------------------------------------------\n");

        // Create the main queue (unlimeted size)
        // ----------------------------------------------
        QueueOfVisitorLL mainQ = new QueueOfVisitorLL();

        // Create queue of Auditorium 1 and 2 (Fixed size)
        // ----------------------------------------------
        QueueOfAuditoriumArr audi1 = new QueueOfAuditoriumArr(10);

        QueueOfAuditoriumArr audi2 = new QueueOfAuditoriumArr(10);

        // 2 Ticket Stacks
        // ----------------------------------------------
        StackOfTN TiStack1 = new StackOfTN(10);

        StackOfTN TiStack2 = new StackOfTN(10);

        // create a Scanner object to read from the input file
        Scanner input = new Scanner(InputFile);
        String readCommand;

        // read the first command
        // ----------------------------------------------
        readCommand = input.next();

        // to start ticketNumber from 1000 and add 1 after each Visitor
        int ticketNumber = 999;
        // Loop through the input file
        while (input.hasNext()) {
            switch (readCommand) {
                // case 1: Enter
                case "Enter":
                    String firsfNam = input.next();
                    String lastNam = input.next();
                    String shoeNam = input.next();
                    Visitor vi = new Visitor(firsfNam, lastNam, shoeNam, 0, null);
                    mainQ.enqueue(vi);
                    output.println("Enter " + firsfNam + " " + lastNam
                            + " Was sucssuflly enter the main queue, he wants to visit " + shoeNam);
                    break;
                // case 2: Serve
                case "Serve":
                    // if mainQ not empty
                    if (!mainQ.isEmpty()) {

                        // remove Visitor from mainQ
                        Visitor vi2 = mainQ.dequeue();
                        // if show#1 add to audi1
                        if (vi2.getShowName().equalsIgnoreCase("show#1")) {

                            if (!audi1.isFull()) {
                                vi2.setTN(++ticketNumber);
                                // add Visitor to audi1
                                audi1.enqueue(vi2);
                                output.println("Serve " + vi2.getFirstName() + " " + vi2.getLastName()
                                        + " move to auditorium#1 queue with ticket# " + vi2.getTN());
                            } else {
                                // if is full audi1
                                output.println("Serve Sorry, can't serve " + vi2.getFirstName() + " "
                                        + vi2.getLastName() + " auditorium#1 is full");
                            }

                        } else {
                            // else if show#2 add to audi2

                            if (!audi2.isFull()) {

                                vi2.setTN(++ticketNumber);
                                // add Visitor to audi2
                                audi2.enqueue(vi2);
                                output.println("Serve " + vi2.getFirstName() + " " + vi2.getLastName()
                                        + " move to auditorium#2 queue with ticket# " + vi2.getTN());
                            } else {
                                // if is full audi2
                                output.println("Serve Sorry, can't serve " + vi2.getFirstName() + " "
                                        + vi2.getLastName() + " auditorium#2 is full");
                            }
                        }
                    } else {
                        // if the Queue is empty
                        output.println("Serve No Customer available in the main queue to serve");
                    }
                    break;

                // case3: Start
                case "Start":
                    output.println("Start Shows are running now");
                    // save all tickets of show#1 in TiStack2
                    while (!audi2.isEmpty()) {
                        int vStack = audi2.dequeue().getTN();
                        TiStack2.push(vStack);
                    }
                    // save all tickets of show#1 in TiStack1
                    while (!audi1.isEmpty()) {
                        int vStack = audi1.dequeue().getTN();
                        TiStack1.push(vStack);
                    }

                    break;

            }
            // read the next command
            readCommand = input.next();
        } // End loop
        if (readCommand.equalsIgnoreCase("Print")) {
            // Print shows statistics and list of all tickets in each show
            output.println("\nAuditorium#1 has " + TiStack1.size() + " visitor(s) with ticket numbers as follows:");
            while (!TiStack1.isEmpty()) {
                output.print(TiStack1.pop() + ", ");
            }
            output.println();
            output.println("\nAuditorium#2 has " + TiStack2.size() + " visitor(s) with ticket numbers as follows:");
            while (!TiStack2.isEmpty()) {
                output.print(TiStack2.pop() + ", ");
            }
        }
        // closing the files
        input.close();

        output.flush();

        output.close();
    }
}
