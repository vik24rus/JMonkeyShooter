/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author vik24rus
 */
public class AvatarControl extends AbstractControl {
    SimpleApplication app;
    CameraNode cameranode;
    Spatial objectAvatar;
    public AvatarControl (SimpleApplication app , Spatial objectAvatar){
        this.app = app;
        this.objectAvatar = objectAvatar;
        initKeys();
        
        cameranode = new CameraNode("Main Camera", this.app.getCamera());
        this.app.getRootNode().attachChild(cameranode);
        float aspect = (float) 1280 / 720;
        float invZoom = -6f;
        this.app.getCamera().setParallelProjection( true );
        this.app.getCamera().setFrustum( -100, 200, -invZoom * -aspect, invZoom * -aspect, -invZoom, invZoom );
        Quaternion q2 = new Quaternion();
        float angle_vertical = 30*FastMath.DEG_TO_RAD; //наклон
        float angle_turn = 180*FastMath.DEG_TO_RAD; //разворот
        cameranode.setLocalRotation(q2.fromAngles(angle_vertical,angle_turn,0)); 
      
    }
    @Override
    protected void controlUpdate(float tpf)
    {
       cameranode.setLocalTranslation(objectAvatar.getLocalTranslation().x  , 0 ,objectAvatar.getLocalTranslation().z   );
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp)
    {
        
    }
    
    private void initKeys() {
    // Можно сопоставить один или несколько вводов одному названию действия
        
        app.getInputManager().addMapping("Left",   new KeyTrigger(KeyInput.KEY_A));
        app.getInputManager().addMapping("Right",  new KeyTrigger(KeyInput.KEY_D));
        app.getInputManager().addMapping("UP", new KeyTrigger(KeyInput.KEY_W));
        app.getInputManager().addMapping("DOWN", new KeyTrigger(KeyInput.KEY_S));                              
    // Добавить названия к слушателю действий.
        //inputManager.addListener(actionListener, "Pause");
        app.getInputManager().addListener(analogListener, "Left", "Right", "UP" , "DOWN");
 
    }
 
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            
        }
    };
 
    private final AnalogListener analogListener = new AnalogListener() {
        @Override
        public void onAnalog(String name, float value, float tpf) {
           
            if (name.equals("Right")) {
                Vector3f v = objectAvatar.getLocalTranslation();
                objectAvatar.setLocalTranslation(new Vector3f (v.x  + value * 3, v.y, v.z));
                //phyAvatar.setLinearVelocity(new Vector3f (v.x + value * speed, v.y, v.z));
            }   
 
            if (name.equals("Left")) {
                Vector3f v = objectAvatar.getLocalTranslation();
                objectAvatar.setLocalTranslation(new Vector3f (v.x   - value * 3, v.y, v.z ));
                //phyAvatar.setLinearVelocity (new Vector3f (v.x - value * speed, v.y, v.z));
            }
            
            if (name.equals("UP")) {
                Vector3f v = objectAvatar.getLocalTranslation();
                objectAvatar.setLocalTranslation(new Vector3f (v.x     , v.y, v.z  - value * 3));
                //phyAvatar.setLinearVelocity(new Vector3f (v.x , v.y, v.z  + value * speed));
                
            }   
 
            if (name.equals("DOWN")) {
                Vector3f v = objectAvatar.getLocalTranslation();
                objectAvatar.setLocalTranslation(new Vector3f (v.x   , v.y, v.z  + value * 3));
                //phyAvatar.setLinearVelocity (new Vector3f (v.x , v.y, v.z - value * speed));
            }
            
        }
    };
}
