import java.util.Scanner;
import java.util.Random;
import java.io.*;
import javax.swing.*;

public class arrayActivity {

	public static String[][] tableSize;

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Random 	rnd = new Random();
        boolean operation=true;
        boolean operation2=true;
        int 	row;
        int 	col;
        int 	selection=0;
        int 	i;
        int 	j;
        int 	k;

    while (operation == true) {
    	System.out.println("\nDetermine the Size of the Table\n");

		  do {
		    	System.out.print("Input Number of Rows: ");
			    	while(!sc1.hasNextInt()){
				    	System.out.println("Please input a number!");
				      sc1.next();
			    	}
		    	row = sc1.nextInt();
		  } while ( row<=0 ) ;

		  do{
		      System.out.print("Input Number of Columns: ");
		      while(!sc2.hasNextInt()){
		       System.out.println("Please input a number!");
		       sc2.next();
		      }
		     	col = sc2.nextInt();
		    } while ( col<=0 );

				tableSize = new String[row][col];
			    for(i=0; i < tableSize.length; i++){
			      for(j=0; j < tableSize[i].length; j++){
			      	tableSize[i][j] = new Character((char)
															(rnd.nextInt(94)+33)).toString();
			        for(k=1; k<3; k++){
			          tableSize[i][j] += new Character((char)
																	(rnd.nextInt(94)+33)).toString();
			        }
			      }
			   } //assignment of value for table

        printArray(tableSize);
        operation2 = true;

      while(operation2==true){
		    selection = selectOperation(selection);
		      switch(selection){
			      case 1:
			        System.out.println(searchResult(tableSize));
			        break;
			      case 2:
			        editData(tableSize);
			        break;
			      case 3:
			        printArray(tableSize);
			        break;
			      case 4:
			        System.out.print("\033[H\033[2J");
   						System.out.flush();
			        operation2 = false;
			        break;
			      case 5:
			        System.out.println("Thank you for using the program!");
			        operation = false;
			        operation2 = false;
			        break;
			        default:
			        System.out.println("Please input a valid selection!");
		      } //end of switch selection
		  }  // end of operation2
	} //end of operation
} //end of main method

    /*
     *Selection for operation2
     */

public static int selectOperation(int a){
  do{
  	Scanner option = new Scanner(System.in);
    System.out.print("\n\n Choose Operation \n"
    						+ "1. Search \n"
                + "2. Edit \n"
                + "3. Print \n"
                + "4. Reset \n"
                + "5. Exit \n"
                + "Select:" );
    	while(!option.hasNextInt()){
       	System.out.println("Invalid option. Please input a Valid Option!");
       	option.next();
      }
    a = option.nextInt();
  } while(a<0);

	return a;
}

    /*
   	 *method for search operation
     */

public static int searchResult(String[][] tableSize){
    Scanner scan = new Scanner(System.in);
    int 	lastIndex;
    int 	count = 0;

    System.out.print("Input characters to Search: ");
    String findStr = scan.nextLine();

    for ( int i=0; i<tableSize.length; i++ ) {
      for (int j=0; j < tableSize[i].length; j++) {
      	lastIndex = 0;
        while (lastIndex != -1) {
					lastIndex = tableSize[i][j].indexOf(findStr, lastIndex);
        	if (lastIndex != -1) {
          	count++;
            lastIndex += 1;
          }
      	}
      }
    }
        return count;
} //end of search method

    /*
   	 * method for editing array content
     */

    public static void editData(String[][] tableSize){
        int 	a,b;
        int 	row;
        int 	column;
        Scanner r = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        Scanner value = new Scanner(System.in);

        row = tableSize.length-1;
        column = tableSize[0].length-1;

        System.out.println("row(0-" + row + "), column(0-" + column +")");
       			do{
		        	System.out.print("Choose Row: ");
		        	while(!r.hasNextInt()){
		        		System.out.println("Please input a number!");
		        		r.next();
		        	}
		        	a = r.nextInt();
		        }while(a>=tableSize.length || a<0);

		        do{
		        	System.out.print("Choose Column: ");
		        	while(!c.hasNextInt()){
		        		System.out.println("Please input a number!");
		        		c.next();
		        	}
		        	b = c.nextInt();
		        }while(b>=tableSize[0].length || b<0);

        System.out.println("The selected index contains: " + tableSize[a][b]);
        System.out.print("Input new content for the index: ");
        tableSize[a][b] = value.nextLine();
        System.out.println("Change Successful!");
    }

    /*
   	 * method for printing array
     */
    public static void printArray(String[][] tableSize){
    	System.out.println();
        for(int i=0; i<tableSize.length; i++){
          for(int j=0; j < tableSize[i].length; j++){
            System.out.print(tableSize[i][j] +  "  |");
          }
          System.out.println();
        }
    }
}
