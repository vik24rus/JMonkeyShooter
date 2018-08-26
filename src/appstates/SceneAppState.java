/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appstates;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.bullet.BulletAppState;
import controls.AvatarControl;
import mygame.utils.Avatar;
import mygame.utils.SceneLevel1;
import mygame.utils.SimpleEnemy;


/**
 *
 * @author vik24rus
 */
public class SceneAppState  extends BaseAppState {
    private SimpleApplication app;
    BulletAppState bulletApp; 
    SceneLevel1 sceneLevel1;
    Avatar avatar;
    SimpleEnemy simpleEnemy;
    AvatarControl avatarControl;
    public SceneAppState(BulletAppState bulletApp){
        this.bulletApp = bulletApp;
    }
    
    @Override
    protected void initialize(Application app)
    {
        this.app = (SimpleApplication) app;
        
        sceneLevel1 = new SceneLevel1(this.app );   
        avatar = new Avatar (this.app);
        avatarControl = new AvatarControl(this.app , avatar.getObjectAvatar());
        simpleEnemy = new SimpleEnemy (this.app);
        
        
    }

    @Override
    protected void cleanup(Application app)
    {
        
    }

    @Override
    protected void onEnable()
    {
        app.getRootNode().attachChild(sceneLevel1.getObjectFloor());
        sceneLevel1.getObjectFloor().addControl(sceneLevel1.getphyFloor());
        sceneLevel1.getphyFloor().setPhysicsSpace(bulletApp.getPhysicsSpace());
        
        app.getRootNode().attachChild(avatar.getObjectAvatar());
        avatar.getObjectAvatar().addControl(avatar.getphyAvatar());
        avatar.getObjectAvatar().addControl(avatarControl);
        avatar.getphyAvatar().setPhysicsSpace(bulletApp.getPhysicsSpace());
        avatar.getphyAvatar().setKinematic(true) ;
        
        app.getRootNode().attachChild(simpleEnemy.getObjectSimpleEnemy());
        simpleEnemy.getObjectSimpleEnemy().addControl(simpleEnemy.getphySimpleEnemy());
        simpleEnemy.getphySimpleEnemy().setPhysicsSpace(bulletApp.getPhysicsSpace());
        

    }

    @Override
    protected void onDisable()
    {
//        app.getRootNode().detachChild(sceneLevel1.getObjectFloor());
//        sceneLevel1.getObjectFloor().removeControl(sceneLevel1.getphyFloor());
//        sceneLevel1.getphyFloor().getPhysicsSpace().destroy();
    }
    
    @Override
    public void update(float tpf) {
        //TODO: реализовать поведение во время выполнения

    }
    
    
}
