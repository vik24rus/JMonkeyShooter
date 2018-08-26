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
public class Avatar {
    Spatial objectAvatar;
    SimpleApplication app;
    RigidBodyControl phyAvatar;
    public Avatar(SimpleApplication app ){
        this.app = app;
        objectAvatar = app.getAssetManager().loadModel("Models/cubic/cubic.j3o");
        app.getRootNode().attachChild(objectAvatar);
        objectAvatar.setLocalTranslation(new Vector3f(0.5f,0.5f,0.5f));
        phyAvatar = new RigidBodyControl( 2.0f );
       
    }
    
    public Spatial getObjectAvatar(){
        return objectAvatar;
    }
    
    public RigidBodyControl getphyAvatar(){
        return phyAvatar;
    }
    
}
