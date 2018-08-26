package mygame.utils;


import appstates.LightAndShadows;
import appstates.SceneAppState;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.renderer.Camera;


public class MyStateManager {
    static SimpleApplication app;
    static BulletAppState bulletApp ;
    static Camera cam;
    static SceneAppState sceneAppState;
    static LightAndShadows lightAndShadows;

        
    public MyStateManager(SimpleApplication application , BulletAppState bulletApp , Camera cam){
        MyStateManager.app = application;    
        MyStateManager.bulletApp = bulletApp;
        MyStateManager.cam = cam;  
        sceneAppState = new SceneAppState(bulletApp);
        lightAndShadows = new LightAndShadows();
    }


    public static void addScene(){
        app.getStateManager().attach(sceneAppState);
    }
    
  
    
    public static void addLightAndShadows(){
        app.getStateManager().attach(lightAndShadows);
    }
    
  


}
