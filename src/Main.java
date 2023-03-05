import java.util.Scanner;
import javax.tools.ToolProvider;
class Main {
    public static void main(String[] args) {
        char yesorno = 'f'; //  declaring the variable "yesorno" as a char data type and giving it the value of "f"
        String s = "f"; //  declaring the variable "s" as a string data type and giving it the value of "f"
        String u = "z"; //  declaring the variable "u" as a string data type and giving it the value of "z"
        Boolean valid = false; //  declaring the variable "valid" as a boolean data type and giving it the value of "false"
        Boolean loop = false; //  declaring the variable "loop" as a boolean data type and giving it the value of "false"
        char unicode = 'z'; //  declaring the variable "unicode" as a char data type and giving it the value of "z"
        int bottom = 0; //  declaring the variable "bottom" as a intiger data type and giving it the value of "0"
        int top = 0; //  declaring the variable "top" as a string intiger type and giving it the value of "0"
        Scanner scan = new Scanner(System.in); // declaring my scanner value as "scan" if i try using sc.next it will not work
        System.out.println("Welcome to The Unicode Lister"); // Welcome Message
        while (! loop){ // Everything after this and before the ending curly bracket will be looped
            System.out.println("This Is The Main Menu:"); //  Main Menu Text
            System.out.println("Would you like to continue with the program?. Type (Y) or (N)"); //Asks wewther the use wants to continue or not
            s = scan.next().toLowerCase(); // Scans the input and makes it all lower case
            yesorno = s.charAt(0); // Takes the very first character of the string above and stores it into the char
            if (yesorno == 'y'){ // if it is "y" or "yes" then...
                System.out.println("Please Choose A Character Out Of the Many Below"); // allows the user to see their options
                System.out.println("a    Box drawing                b    Geometric Shapes Extended"); //^^^^^^^
                System.out.println("c    Emoticons                  d    Cuneiform Numbers and Punctuation");//^^^^^^^
                System.out.println("e    Braille                    f    Playing Cards");
                System.out.println("g    CJK Unified Ideographs Extension B ");//^^^^^^^
                System.out.print("You Choose: -> "); //No println here because we want it to look nice so the input goes right after the arrow
                u = scan.next().toLowerCase(); //  Again it takes the input and scans it into the variable "u" while also making it all lower case
                unicode = u.charAt(0); // takes the first character in the string "u" and stores it in the variable "unicode"
                valid = (unicode == 'a' || unicode == 'b' || unicode == 'c' || unicode == 'd' || unicode == 'e' || unicode == 'f'|| unicode == 'g'); // if the value of the variable "unicode" is any of these then the variable "valid" is true
                if (! valid) System.out.println("This is an Invalid Input."); // this always happpens unless the value of "unicode" is any of the ones above
            }// all of this happenened if the variable "yesorno" is y
            if (yesorno == 'n'){ //If the variable "yesorno" is no
                System.out.print("Goodbye!!!\n"); //Code says goodbye to the user
                System. exit(0);// ends the entire code right here so no other code runs by mistake
            }
            switch (unicode){ //this is creating a switch for the unicode variable
                case 'a':
                    bottom = 0x2500; //  this is the value of the lowest number for our option a
                    top = 0x257f; //  this is the value of the highest number for our option a
                    break;
                case 'b':
                    bottom = 0x1F780; //  this is the value of the lowest number for our option b
                    top = 0x1F7CF;  //  this is the value of the highest number for our option b
                    break;
                case 'c':
                    bottom = 0x1F600; //  this is the value of the lowest number for our option c
                    top = 0x1F64F; //  this is the value of the highest number for our option c
                    break;
                case 'd':
                    bottom = 0x12400; //  this is the value of the lowest number for our option d
                    top = 0x1245F; //  this is the value of the highest number for our option d
                    break;
                case 'e':
                    bottom = 0x2800; //  this is the value of the lowest number for our option e
                    top = 0x28FF; //  this is the value of the highest number for our option e
                    break;
                case 'f':
                    bottom = 0x1F0A0; //  this is the value of the lowest number for our option f
                    top = 0x1F0FF; //  this is the value of the highest number for our option f
                    break;
                case 'g':
                    bottom = 0x20000; //  this is the value of the lowest number for our option g
                    top = 0x2A6DD; //  this is the value of the highest number for our option g
                    break;
                default: break; // by default, there is no value for bottom and top and the switch closes
            }
            if (yesorno == 'y'){// everything in between these brackets only happens if the "yesorno" variable is y because sometimes if you type a random letter other than y or n, it still prints out the characters because it doesnt understand what to do
                if (valid){ // everything in between these brackets will also only happen if the value for "unicode" is actually a valid option
                    for (int i =  bottom; i<=top; i++) { // this will take the value of the variable "bottom" and it will keep adding one to it as long as the answer is less than the value of "top"
                        unicode = (char) i;
                        System.out.printf("%4h\t", i); //  this prints out the hexidecimal number value of the character and also the character with a tab spacing in between
                        System.out.printf("%s\t", new String(Character.toChars(i)));
                        if (i%0x8==7) System.out.print("\n"); // if the hexidecimal value is divisble by 8 BUT equals to 7, then it will move the rest of the characters on the next line, this means only 8 chracters are shown every line
                        if (i%0x81==1) { //  if the hexidecimal value is divisble by 81 BUT equals to 1, then it will ask if i want more before providing me with more characters, this means only 10 rows of characters are shown at a time before being asked for more
                            System.out.print("\n");// line spacing
                            System.out.println("More? (y/n) "); //  asks the user if they want the rest of the unicode
                            char yesorno2 = scan.next().charAt(0); // scans the next input as a character data type
                            if (yesorno2=='n' || yesorno2=='N') { // if the answer is no then it breaks and goes to the next piece of code
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(); // line spacing
            loop = false; // the variable "loop" is now false so the loop can start back up again
        }
    }
} 