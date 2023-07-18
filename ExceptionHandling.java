/*
    Exception handling in java is one the most important feature to handle the runtime error so that regular flow of feature can be preserved.
    Java exception handling is a machanism to handle runtime error such as classNotFoundException, IOException, SQLException, etc.

    Exception in unwanted and unexpected event, which occurs during executin of program, i.e. at run time, that distrupts the normal flow of program instruction.
*/

class ExceptionHandling {
    public static void main(String[]args){
        try{
            int i = 100/0;
        }catch(Exception e){
            System.out.println(e);
        }
    }
}