public class LevelManager {
    private Handler handler;
    public LevelManager(Handler handler){
        this.handler = handler;
    }
    int level = 0;
    boolean first_time = true;
    boolean you_win;
    public void tick() {
        if (checkEnemyAlive()) return;
        if (level < 5) level++;
        if (first_time) nextLevel();
        if (!checkUserAlive()){ // user is dead
            System.out.println("You Lose!");
            handler.game.currState = 2;
            you_win = false;
        }
        if(level == 5){
            if (!checkEnemyAlive()){ // all enemies are dead
                System.out.println("You Win!");
                you_win = true;
                handler.game.currState = 2;
                
            }
        }
    }
    public void nextLevel() {
        if (level == 1) {
            handler.obj.add(new Enemy(500, 100, handler));
        }
        if (level == 2) {
            handler.obj.add(new Enemy(400, 100, handler));
            handler.obj.add(new Enemy(500, 100, handler));
        }
        if (level == 3) {
            handler.obj.add(new Enemy(400, 100, handler));
            handler.obj.add(new Enemy(500, 100, handler));
            handler.obj.add(new Enemy(600, 100, handler));
        }
        if (level == 4) {
            handler.obj.add(new Enemy(300, 100, handler));
            handler.obj.add(new Enemy(400, 100, handler));
            handler.obj.add(new Enemy(500, 100, handler));
            handler.obj.add(new Enemy(600, 100, handler));
        }
        if (level == 5) {
            handler.obj.add(new Enemy(300, 100, handler));
            handler.obj.add(new Enemy(400, 100, handler));
            handler.obj.add(new Enemy(500, 100, handler));
            handler.obj.add(new Enemy(600, 100, handler));
            handler.obj.add(new Enemy(700, 100, handler));
            first_time = false;
        }
    }
    // if level 5 is over and all enemies dead, 
    // checkDead
    public boolean checkUserAlive(){
        for (int i = 0; i < handler.obj.size(); i++) if (handler.obj.get(i).id == 1) return true;
        return false;
    }
    public boolean checkEnemyAlive(){
        for (int i = 0; i < handler.obj.size(); i++) if (handler.obj.get(i).id == 2) return true;
        return false;
    }
    public void clearObjects(){
        
    }
    
}
