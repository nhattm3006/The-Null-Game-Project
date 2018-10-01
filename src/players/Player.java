package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import enemies.Enemy;
import game.Platform;
import maps.Hotel;
import maps.Spike;
import players.scenes.GameOverScene;
import players.scenes.WinScene;
import scenes.SceneManager;

public class Player extends GameObject {
    public PlayerMove playerMove;
    PlayerShoot playerShoot;
    public boolean isFaceLeft = false;
    private PlayerAnimator playerAnimator;

    public Player(int x, int y) {
        super(x, y);
        this.playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(x, y, 40, 70);
    }

    public void run() {
        super.run();
        this.move();
        this.shoot();
        this.animate();
        this.hitBySpike();
        this.hitByEnemy();
        this.win();

    }

    private void animate() {
        this.playerAnimator.selectAnimation();
        this.playerAnimator.isFaceLeft = this.isFaceLeft;
    }

    void move() {
        this.playerMove.run(position, boxCollider);
        this.isFaceLeft = playerMove.isFaceLeft;
    }

    void shoot() {
        this.playerShoot.run(this);
    }

    public void getHit() {
        this.gameOver();
        PlayerExplosion playerExplosion =
                new PlayerExplosion((int)this.position.x, (int)this.position.y);
        GameObject.add(playerExplosion);
        this.destroy();


    }

    public void hitBySpike(){
        Spike spike = GameObject.checkCollision(this.boxCollider, Spike.class);
        if (spike != null){
            this.getHit();
            System.out.println("HIT!!!");
        }
    }

    public void hitByEnemy(){
        Enemy enemy = GameObject.checkCollision(this.boxCollider, Enemy.class);
        if (enemy != null){
            this.getHit();
            System.out.println("HIT!!!");
        }
    }

    public void win(){
        Hotel hotel = GameObject.checkCollision(this.boxCollider, Hotel.class);
        if (hotel != null){
            SceneManager.changeScene(new WinScene());
        }
    }
}