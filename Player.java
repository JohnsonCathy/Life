public class Player {
    int money;
    int rounds;
    int salary;
    String house = "";
    String career = "";
    boolean hasStock;
    boolean isCurrentPlayer;

    public Player(){
        money = 10000;
        rounds = 0;
        hasStock = false;
        house = "";
        salary = 0;
        career = "Broke ass";
    }

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

}
