import java.util.Scanner;

class Fibonacci {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();

    int fibonacci[] = new int[size];
    fibonacci[0] = 0;
    fibonacci[1] = 1;

    for(int i=2; i<size; i++)
      fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];

    System.out.println(fibonacci[size-1]);  

  }
}
