/* Declare second integer, double, and String variables. */
DecimalFormat decimalFormat = new DecimalFormat(".#");
int a;
double b;
String c1, c2;
/* Read and save an integer, double, and String to your variables.*/
// Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
a = scan.nextInt();
b = scan.nextDouble(); 
c2 = scan.nextLine();
c1 = scan.nextLine();
/* Print the sum of both integer variables on a new line. */
System.out.println(i + a);
/* Print the sum of the double variables on a new line. */
	System.out.println(decimalFormat.format(d+b));
/* Concatenate and print the String variables on a new line; 
	the 's' variable above should be printed first. */
System.out.println(s + c1);