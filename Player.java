public class Player {
    int money;
    int rounds;
    boolean hasStock;
    boolean isCurrentPlayer;


    public Player(){
        money = 10000;
        rounds = 0;
        hasStock = false;
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


}
