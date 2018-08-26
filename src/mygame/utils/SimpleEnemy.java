/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.utils;

import com.jme3.app.SimpleApplication;

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
    public SimpleEnemy(SimpleApplication app ){
        this.app = app;
        objectSimpleEnemy = app.getAssetManager().loadModel("Models/cubic/cubic.j3o");
        app.getRootNode().attachChild(objectSimpleEnemy);
        objectSimpleEnemy.setLocalTranslation(new Vector3f(3,5,1));
        phySimpleEnemy = new RigidBodyControl( 1.0f );
        
    }
    public Spatial getObjectSimpleEnemy(){
        return objectSimpleEnemy;
    }
    
    public RigidBodyControl getphySimpleEnemy(){
        return phySimpleEnemy;
    }
}
