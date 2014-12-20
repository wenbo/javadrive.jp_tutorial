class JSample7_1{
  public static void main(String args[]){
    int seiseki[][] = new int[2][3];

    seiseki[0][0] = 80;
    seiseki[0][1] = 92;
    seiseki[0][2] = 45;

    seiseki[1][0] = 75;
    seiseki[1][1] = 89;
    seiseki[1][2] = 54;

    String kyoka[] = {"国語", "数学"};

    for (int i = 0; i < 2; i++){
       System.out.println(kyoka[i] + "の成績");

      for (int j = 0; j < 3; j++){
        System.out.println(seiseki[i][j]);
      }
    }
  }
}
