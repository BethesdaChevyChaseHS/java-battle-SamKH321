package bcc.javaJostle;

import java.util.ArrayList;
public class MyRobot extends Robot{
    private int curXMovement = 0;
    private int curYMovement = 0;
    public MyRobot(int x, int y){
        super(x, y, 3, 1, 3, 3,"The Frog", "myRobotImage.png", "defaultProjectileImage.png");
        // Health: 3, Speed: 3, Attack Speed: 2, Projectile Strength: 2
        // Total = 10
        //I say for stat spread; health 1, speed 3, attack speed 3, projectle strength 3
       
    }

    public void think(ArrayList<Robot> robots, ArrayList<Projectile> projectiles, Map map, ArrayList<PowerUp> powerups) {
       /* Implement your robot's logic here
         For example, you can move towards the nearest robot or shoot at a target
         to move, choose a direciton to go
         to move left - use xMovement = -1
         to move right - use xMovement = 1
         to move up - use yMovement = -1
         to move down - use yMovement = 1
         You can ONLY move in one direction at a time, if your output doesn't match the above you will get an error

         to shoot, use shootAtLocation(x, y) where x and y are the coordinates of the target
         only shoot when canAttack() is true!
        */
       if (robots.size() < 3) {
        
                if(Math.random() < 0.4) {
                    if(Math.random() < 0.1) {
                    double r = Math.random();
                        if (r < 0.40) {
                            for(Robot robot : robots) {
                                if (robot != this && robot.isAlive() ){
                                    if(((robot.getX() > this.getX()) && (robot.getX()-this.getX() > 40)) && (this.getX() != 0)){
                                    curXMovement = 1;
                                    curYMovement = 0; 
                                    }else{
                                    curXMovement = -1;
                                    curYMovement = 0; 
                                    }
                                }
                            }
                        } else if (r < 0.8) {
                            for(Robot robot : robots) {
                                if (robot != this && robot.isAlive() ){
                                    if((robot.getY() > this.getY()) && (robot.getY()-this.getY() > 40)  && (this.getY() != 0)){
                                    curXMovement = 0;
                                    curYMovement = 1; 
                                    }else{
                                    curXMovement = 0;
                                    curYMovement = -1; 
                                    }
                                }
                            }
                        } else if (r < 0.85) {
                            curXMovement = 1;
                            curYMovement = 0; 
                        } else if (r < 0.9) {
                            curXMovement = 1;
                            curYMovement = 0; 
                        } else if (r < 0.95) {
                            curYMovement = -1; 
                            curXMovement = 0; 
                        } else {
                            curYMovement = 1; 
                            curXMovement = 0;
                        }
                    } 
            }
        }
        xMovement = curXMovement;
        yMovement = curYMovement;
        if(canAttack()){
            for(Robot robot : robots) {
                if (robot != this && robot.isAlive() ){
                    shootAtLocation(robot.getX() + Utilities.ROBOT_SIZE/2, robot.getY() + Utilities.ROBOT_SIZE/2);
                    break; // Shoot at the first target found
                }
            }
        }
    }
    }

