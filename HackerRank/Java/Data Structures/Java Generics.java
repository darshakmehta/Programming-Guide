class Printer<T>
{
   //Write your code here
    public <T> void printArray(T[] element) {
        for(T item: element) {
            System.out.println(item);
        }
        
    }
}