public class Player {
    int money;
    static int count;
    int rounds;
    int salary;
    int ownedStock;
    String house = "";
    String career = "";
    boolean hasStock;
    boolean isCurrentPlayer;
    public static Player PlayerOne;
    private static Player PlayerTwo;

    public Player() {
        money = 10000;
        rounds = 1;
        hasStock = false;
        house = "Hobo";
        salary = 0;
        career = "Bum";
        ownedStock = 0;
        isCurrentPlayer = false;
    }

  /*  public static Player getInstance() {

        switch (count) {
            case 0:
                PlayerOne = new Player();
                count++;
                return PlayerOne;
            case 1:
                PlayerTwo = new Player();
                count++;
                return PlayerTwo;
            default:
                return PlayerOne;
        }
    }*/

    /************GETTERS**************/
    public int getMoney(){
        return money;
    }
    public int getRounds(){
        return rounds;
    }
    public boolean hasStock() {
        return hasStock;
    }
    public boolean isCurrentPlayer() {
        return isCurrentPlayer;
    }
    public String getHouse() {return house;}
    public String getCareer() {return career;}
    public int getSalary() {return salary;}
    public int getStock() {return ownedStock;}

    /************SETTERS**************/
    public void setMoney(int amount){
        money = amount;
    }
    public void setStock(){
        hasStock = true;
    }
    public void setCurrentPlayer(){
        isCurrentPlayer = true;
    }
    public void setRounds(int rounds){
        this.rounds = rounds;
    }
    public void setHouse(String house) {this.house = house;}
    public void setSalary(int salary) {this.salary = salary;}
    public void setCareer(String career) {this.career = career;}
    public void setStock(int stock) {this.ownedStock = stock;}

}
