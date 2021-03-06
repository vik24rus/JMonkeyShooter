/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.utils;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.scene.Spatial;

/**
 *
 * @author vik24rus
 */
public class SceneLevel1 {
    Spatial objectFloor;
    SimpleApplication app;
    RigidBodyControl phyFloor;
    BulletAppState bulletApp;
    
    public SceneLevel1(SimpleApplication app , BulletAppState bulletApp){
        this.app = app;
        this.bulletApp = bulletApp;
        objectFloor = app.getAssetManager().loadModel("Models/floor/floor.j3o");
        Quaternion rotationFloor = new Quaternion();
        objectFloor.setLocalRotation(rotationFloor.fromAngles(0, 45*FastMath.DEG_TO_RAD, 0));
        addPhysics();
        
    }
   
    private void addPhysics(){
        phyFloor = new RigidBodyControl(0.0f);
        objectFloor.addControl(phyFloor);
        phyFloor.setPhysicsSpace(bulletApp.getPhysicsSpace());
    }
    
    public Spatial getObjectFloor(){
        return objectFloor;
    }
    
    public RigidBodyControl getphyFloor(){
        return phyFloor;
    }
}
