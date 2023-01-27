package dsa.proyecto.g6.Models;

public class Enemigo {
    public Integer idEnemy;

    public Integer enemySpeed;
    public Integer enemyHealth;
    public Integer tmeBetweenShots;


    public Enemigo(){}


    public Enemigo(Integer idEnemy, Integer enemySpeed, Integer enemyHealth, Integer tmeBetweenShots) {
        this.idEnemy = idEnemy;
        this.enemySpeed = enemySpeed;
        this.enemyHealth = enemyHealth;
        this.tmeBetweenShots = tmeBetweenShots;
    }

    public Integer getIdEnemy() {
        return idEnemy;
    }

    public void setIdEnemy(Integer idEnemy) {
        this.idEnemy = idEnemy;
    }

    public Integer getEnemySpeed() {
        return enemySpeed;
    }

    public void setEnemySpeed(Integer enemySpeed) {
        this.enemySpeed = enemySpeed;
    }

    public Integer getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(Integer enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public Integer getTmeBetweenShots() {
        return tmeBetweenShots;
    }

    public void setTmeBetweenShots(Integer tmeBetweenShots) {
        this.tmeBetweenShots = tmeBetweenShots;
    }
}
