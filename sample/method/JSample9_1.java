class JSample9_1{
  public static void main(String args[]){
    System.out.println(sum(4, 10));
    System.out.println(sum(7, 2, 8));
    System.out.println(sum());
  }

  private static int sum(int... nums){
    int sum = 0;

    for (int i = 0; i < nums.length; i++){
      sum += nums[i];
    }

    return sum;
  }
}
