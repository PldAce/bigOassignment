/*********************************************************************
 (a) Given a sorted array of N distinct integers that has been rotated 
 * an unknown number of times. Implement (in Java) an efficient algorithm
 * that finds an element * in the array.
(b) What is the running time complexity of your algorithm? 
 Author’s Panther ID: 2056126
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 

package a3p3;


public class A3P3 {

    /*
    The running time complexity would be O(n) if there are duplicate elements,
    but if each element is different then the running time would be O(logn)
    */
   public static int search4element
        (int array[], int leftElement, int rightElement, int a)
    {
       int middleElement = (leftElement + rightElement) / 2;
       
       if (a == array[middleElement]) 
            {
            return middleElement;
            }
       
       else if (leftElement > rightElement)
            {
            return -1;
            }
       
       else if (array[leftElement] < array[middleElement])
            {
            if (a <= array[middleElement] && a >= array[leftElement])
                {
                return search4element(array, leftElement, middleElement -1, a);
                }
            
            else{
                  return search4element
                            (array, middleElement +1, rightElement, a);
                }                 
            }
       
       else if (array[leftElement] == array[middleElement])
           {
           if (array[middleElement] != array[rightElement])
                {
                   return search4element
                            (array, middleElement +1, rightElement, a); 
                }
            else{
               
               int result = 
                       search4element(array, leftElement, middleElement -1, a); 
               
               if (result == -1)                 
                   {
                   return search4element
                            (array, middleElement +1, rightElement, a);                 
                   }
               else{
                   return result;}
                   }
           }
       
       else if (array[middleElement] < array[leftElement])
           {
           if (a >= array[middleElement] && a <= array[rightElement])
               {
               return search4element(array, middleElement +1, rightElement, a);
               }
           else{
               return search4element(array, leftElement, middleElement -1, a); 
               }
           }
       
       
    return -1;
    }
    
    public static void main(String[] args) 
        {
		int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
                int arraySize = array.length -1;
                int findE = 5;
		System.out.println(search4element(array, 0, arraySize, findE));
	}

    
}
