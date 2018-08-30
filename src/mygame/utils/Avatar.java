/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.utils;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import controls.avatarCameraInputControl;


/**
 *
 * @author vik24rus
 */
public class Avatar implements AnimEventListener {
    Node objectAvatar;
    SimpleApplication app;
    RigidBodyControl phyAvatar;
    BulletAppState bulletApp;
    avatarCameraInputControl avatarCameraInputControl;
    AnimControl avatarAnimaControl;
    AnimChannel avatarAnimaChannel;
   
    public Avatar(SimpleApplication app , BulletAppState bulletApp ) {
        this.app = app;
        this.bulletApp = bulletApp;
        objectAvatar = (Node) app.getAssetManager().loadModel("Models/Player/Player.j3o"); //LoadPlayerModel
        //player = (Node) app.getAssetManager().loadModel("Models/Player/Player.j3o");
        objectAvatar.setLocalTranslation(new Vector3f(0.5f,0.5f,0.5f));  //StartPlayerPosition
        avatarCameraInputControl = new avatarCameraInputControl(app , objectAvatar);
        objectAvatar.addControl(avatarCameraInputControl);
        addPhysics();
        addAnimation();
    }
    
    private void addPhysics(){
        phyAvatar = new RigidBodyControl( new CapsuleCollisionShape(1 , 2) , 2.0f );
        objectAvatar.addControl(phyAvatar);
        phyAvatar.setPhysicsSpace(bulletApp.getPhysicsSpace());
        phyAvatar.setKinematic(true) ;
    }
    
    private void addAnimation(){
        avatarAnimaControl =  objectAvatar.getChild("Cube").getControl(AnimControl.class);
        avatarAnimaControl.addListener(this);
        avatarAnimaChannel = avatarAnimaControl.createChannel();
        avatarAnimaChannel.setAnim("ArmatureAction");
       
    }
    
    
    
    
    public Spatial getObjectAvatar(){
        return objectAvatar;
    }

    @Override
    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName)
    {
         if (animName.equals("ArmatureAction")){
            channel.setAnim("ArmatureAction");
            channel.setLoopMode(LoopMode.Loop);
            channel.setSpeed(2f);
        }
    }

    @Override
    public void onAnimChange(AnimControl control, AnimChannel channel, String animName)
    {
        
    }
    
    public void onAction(String binding, boolean value, float tpf) {
       
    }
        
}
