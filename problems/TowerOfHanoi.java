public class TowerOfHanoi {
    static int count =0;
    public static void main(String[] args) {
        int n = 5;
        towerOfHanoi(n, 'A', 'C', 'B');
        System.out.println(count);
    }
    static void towerOfHanoi(int n, char from, char to, char aux) {
        //base case
        if(n==1){
            System.out.println("Move disk "+ n + " from"+ from+ " to "+ to);
            count++;
            return;}
        //recursive case
        towerOfHanoi(n-1, from,aux,to);
        System.out.println("Move disk "+ n + " from"+ from+ " to "+ to);
        count++;
        towerOfHanoi(n-1, aux, to, from);

    }

}

/*
 * Tower of Hanoi - Summary Notes

Problem Statement:

Move N disks from the source rod to the destination rod, using an auxiliary rod, while following these rules:
	1.	Only one disk can be moved at a time.
	2.	A larger disk cannot be placed on a smaller disk.
	3.	All disks must be moved while following the above constraints.

Approach (Recursive Solution):
	1.	Move (N-1) disks from source → auxiliary.
	2.	Move the Nth (largest) disk from source → destination.
	3.	Move (N-1) disks from auxiliary → destination.

Base Case:
	•	If N == 1, directly move the disk to the destination rod.

Time Complexity:
	•	O(2ⁿ - 1) ≈ O(2ⁿ) → Exponential time complexity (Each recursive call splits into two).

Space Complexity:
	•	O(N) (Recursive stack space for N function calls).

Number of Moves Formula:
	•	2ⁿ - 1 (For N disks).

 */