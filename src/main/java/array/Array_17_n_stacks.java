package array;

/**
 * Created by GAURAV on 5/7/2018.
 */
public class Array_17_n_stacks {
    // Java program to demonstrate implementation of k stacks in a single
// array in time and space efficient way

    // A Java class to represent k stacks in a single array of size n
    static class KStack {
        int arr[];   // Array of size n to store actual content to be stored in stacks
        int topOfStack[];   // Array of size k to store indexes of topOfStack elements of stacks
        int nextIndexArr[];  // Array of size n to store nextIndexArr entry in all stacks
        // and nextAvailable list
        int n, k;
        int nextAvailable; // To store beginning index of nextAvailable list

        // A utility function to check if there is space available
        boolean isFull() {
            return (nextAvailable == -1);
        }

        //constructor to create k stacks in an array of size n
        KStack(int k1, int n1) {
            // Initialize n and k, and allocate memory for all arrays
            k = k1;
            n = n1;
            arr = new int[n];
            topOfStack = new int[k];
            nextIndexArr = new int[n];

            // Initialize all stacks as empty
            for (int i = 0; i < k; i++)
                topOfStack[i] = -1;

            // Initialize all spaces as nextAvailable
            nextAvailable = 0;
            for (int i = 0; i < n - 1; i++)
                nextIndexArr[i] = i + 1;
            nextIndexArr[n - 1] = -1; // -1 is used to indicate end of nextAvailable list
        }

        // To push an item in stack number 'stackNumber' where stackNumber is from 0 to k-1
        void push(int item, int stackToChange) {
            // Overflow check
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }

            // Store index of first nextAvailable slot
            int tempNextAvailable = nextAvailable;
            nextAvailable = nextIndexArr[tempNextAvailable];
            nextIndexArr[tempNextAvailable] = topOfStack[stackToChange];
            topOfStack[stackToChange] = tempNextAvailable;
            arr[tempNextAvailable] = item;
        }

        // To pop an from stack number 'stackToChange' where stackToChange is from 0 to k-1
        int pop(int stackToChange) {
            // Underflow check
            if (isEmpty(stackToChange)) {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }

            int stackMaxIndex = topOfStack[stackToChange];
            int poppedElement = arr[stackMaxIndex];
            topOfStack[stackToChange] = nextIndexArr[stackMaxIndex];
            nextIndexArr[stackMaxIndex] = nextAvailable;
            nextAvailable = stackMaxIndex;
            return poppedElement;


            /*// Find index of topOfStack item in stack number 'stackToChange'
            int i = topOfStack[stackToChange];

            topOfStack[stackToChange] = nextIndexArr[i]; // Change topOfStack to store nextIndexArr of previous topOfStack

            // Attach the previous topOfStack to the beginning of nextAvailable list
            nextIndexArr[i] = nextAvailable;
            nextAvailable = i;

            // Return the previous topOfStack item
            return arr[i];*/
        }

        // To check whether stack number 'sn' is empty or not
        boolean isEmpty(int stackToChange) {
            return (topOfStack[stackToChange] == -1);
        }

    }

    // Driver program
    public static void main(String[] args) {
        // Let us create 3 stacks in an array of size 10
        int k = 3, n = 10;

        KStack ks = new KStack(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));

        ks.push(45, 2);
        ks.push(39, 1);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}
