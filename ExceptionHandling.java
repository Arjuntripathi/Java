/*
    Exception handling in java is one the most important feature to handle the runtime error so that regular flow of feature can be preserved.
    Java exception handling is a machanism to handle runtime error such as classNotFoundException, IOException, SQLException, etc.

    Exception in unwanted and unexpected event, which occurs during executin of program, 
    i.e. at run time, that distrupts the normal flow of program instruction.
*/

class ExceptionHandling {
    public static void divideThrow(){
        System.out.println("Example of `Throw` : ");
        try {
          // Code that may throw an exception
          int x = 10 / 0;
        } catch (ArithmeticException e) {
          // Handle the exception
          System.out.println("An error occurred: " + e.getMessage());
        }

        // Throw an exception
        // throw new NullPointerException("This is a custom exception");
    }

    public static void divideThrows() throws ArithmeticException{
        // Code that may throw an exception
        int x = 10, y = 0; 
        System.out.println("Example of `Throws` : ");
        int result = x / y;
    }

    public static void main(String[]args){
        divideThrow();
        divideThrows();
    }
}