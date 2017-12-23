import java.io.*;

class RoundRobin {
	public static void main(String args[]) throws IOException {
		DataInputStream in = new DataInputStream(System.in);

		int i, j, k, q, sum = 0;

		//prompt user 
		System.out.println("Enter number of process:");

		//reading from user the number of processes
		int n = Integer.parseInt(in.readLine());

		//burst times
		int bt[] = new int[n];

		//waiting times
		int wt[] = new int[n];

		//turn around times
		int tat[] = new int[n];

		int a[] = new int[n];

		for (i = 0; i < n; i++)

		{

			System.out.println("Enter brust Time for " + (i + 1));

			bt[i] = Integer.parseInt(in.readLine());

		}
		System.out.println("Enter Time quantum:");

		q = Integer.parseInt(in.readLine());

		for (i = 0; i < n; i++)

			a[i] = bt[i];

		for (i = 0; i < n; i++)

			wt[i] = 0;

		//calculating burst times and waiting times
		do {
			for (i = 0; i < n; i++) {
				if (bt[i] > q) {
					bt[i] -= q;

					for (j = 0; j < n; j++) {
						if ((j != i) && (bt[j] != 0))
							wt[j] += q;
					}
				} else {
					for (j = 0; j < n; j++) {
						if ((j != i) && (bt[j] != 0))
							wt[j] += bt[i];
					}
					bt[i] = 0;
				}
			}
			sum = 0;
			for (k = 0; k < n; k++)
				sum = sum + bt[k];
		} while (sum != 0);
		
		
		for (i = 0; i < n; i++)
			tat[i] = wt[i] + a[i];
		
		
		
		System.out.println("process\t\tBT\tWT\tTAT");
		
		
		for (i = 0; i < n; i++) {
			System.out.println("process" + (i + 1) + "\t" + a[i] + "\t" + wt[i] + "\t" + tat[i]);
		}
		float avg_wt = 0;
		float avg_tat = 0;
		
		
		//calculating average waiting time
		for (j = 0; j < n; j++) {
			avg_wt += wt[j];
		}
		
		//calculating average turn around time
		for (j = 0; j < n; j++) {
			avg_tat += tat[j];
		}
		System.out.println("average waiting time " + (avg_wt / n) + "\n Average turn around time " + (avg_tat / n));
	}
}