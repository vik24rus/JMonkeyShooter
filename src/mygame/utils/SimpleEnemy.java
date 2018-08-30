/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.utils;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;

import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

/**
 *
 * @author vik24rus
 */
public class SimpleEnemy {
    Spatial objectSimpleEnemy;
    SimpleApplication app;
    RigidBodyControl phySimpleEnemy;
    BulletAppState bulletApp; 
    
    public SimpleEnemy(SimpleApplication app , BulletAppState bulletApp){
        this.app = app;
        this.bulletApp= bulletApp;
        objectSimpleEnemy = app.getAssetManager().loadModel("Models/cubic/cubic.j3o");
        objectSimpleEnemy.setLocalTranslation(new Vector3f(3,5,1));
        addPhysics();
        
        
    }
    
    private void addPhysics(){
        phySimpleEnemy = new RigidBodyControl( 1.0f );
        objectSimpleEnemy.addControl(phySimpleEnemy);
        phySimpleEnemy.setPhysicsSpace(bulletApp.getPhysicsSpace());
    }
    
    public Spatial getObjectSimpleEnemy(){
        return objectSimpleEnemy;
    }
    
    private void delEnemy(){ //TODO при удалении нужно RootNode().detachChild + удалить все остальное (control+physic)
    
    }
    
}
