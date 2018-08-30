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
    
    public SceneAppState(BulletAppState bulletApp){
        this.bulletApp = bulletApp;
    }
    
    @Override
    protected void initialize(Application app)
    {
        this.app = (SimpleApplication) app;
        
        sceneLevel1 = new SceneLevel1(this.app , this.bulletApp);   
        avatar = new Avatar (this.app , this.bulletApp);
        simpleEnemy = new SimpleEnemy (this.app , this.bulletApp);
        
        
    }

    @Override
    protected void cleanup(Application app)
    {
        
    }

    @Override
    protected void onEnable()
    {
        app.getRootNode().attachChild(sceneLevel1.getObjectFloor());
        app.getRootNode().attachChild(avatar.getObjectAvatar()); 
        app.getRootNode().attachChild(simpleEnemy.getObjectSimpleEnemy());  

    }

    @Override
    protected void onDisable()
    {

    }
    
    @Override
    public void update(float tpf) {
        //TODO: реализовать поведение во время выполнения

    }
    
    
}
