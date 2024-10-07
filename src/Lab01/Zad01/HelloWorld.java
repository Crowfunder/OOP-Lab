package Lab01.Zad01;

class HelloWorld {
    public static void main(String[] args) {
      int maxWys = Integer.parseInt(args[0]);
      for (int wys=0; wys<=maxWys; wys++) {
        System.out.println("*".repeat(wys)); 
      }
    }
}


