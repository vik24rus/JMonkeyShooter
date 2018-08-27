package mygame;


import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Spatial;
import com.jme3.scene.debug.Arrow;
import com.jme3.system.AppSettings;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mygame.utils.Avatar;
import mygame.utils.MyStateManager;


/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */


public class Main extends SimpleApplication {
    
  

    Spatial objectAvatar;
    RigidBodyControl phyAvatar;
    CameraNode cameranode;
            
    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("jMonkey 3.2");
        //settings.setSettingsDialogImage("Interface/logic-excavator.png");
        try
        {
            
            BufferedImage[] icon = new BufferedImage[] {
            ImageIO.read( Avatar.class.getResource( "favicon.png" ) ) };
            settings.setIcons(icon);
        } catch (IOException ex)
        {
            System.out.println("Error load favicon");
        }
        
        settings.setHeight(720);
        settings.setWidth(1280);

        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        //////Windows Position
        //final LwjglWindow lwjglContext = (LwjglWindow) this.getContext();
        //final long windowHandle = lwjglContext.getWindowHandle();
        //GLFW.glfwSetWindowPos(windowHandle, 0 ,10 );
        //////Windows Position
        //assetManager.registerLocator("/Assets", ClasspathLocator.class);
        //setDisplayFps(false);
        //setDisplayStatView(false);
        flyCam.setEnabled(false);
        inputManager.setCursorVisible(true);
        //JmeCursor jc = (JmeCursor) assetManager.loadAsset("tonegod/gui/style/def/Common/Cursors/Pointer.cur");
        //inputManager.setMouseCursor(jc);
        this.setPauseOnLostFocus(false);
        
        BulletAppState bulletApp = new BulletAppState();
        bulletApp.setDebugEnabled(true);
        stateManager.attach(bulletApp);
        
        MyStateManager myStateManager = new MyStateManager(this , bulletApp , cam  );
        MyStateManager.addScene(); 
        MyStateManager.addLightAndShadows();
      
//        cameranode = new CameraNode("Main Camera", cam);
//        rootNode.attachChild(cameranode);
//        float aspect = (float) 1280 / 720;
//        float invZoom = -15f;
//        cam.setParallelProjection( true );
//        cam.setFrustum( -100, 100, -invZoom * aspect, invZoom * aspect, -invZoom, invZoom );
//        Quaternion q2 = new Quaternion();
//        float angle_vertical = 30*FastMath.DEG_TO_RAD; //наклон
//        float angle_turn = 180*FastMath.DEG_TO_RAD; //разворот
//        cameranode.setLocalRotation(q2.fromAngles(angle_vertical,angle_turn,0)); 
//        cam.update();

        
        
        attachCoordinateAxes(new Vector3f(0f,0f,0f));
    }


    private void attachCoordinateAxes(Vector3f pos){
        Arrow arrow = new Arrow(Vector3f.UNIT_X);
        putShape(arrow, ColorRGBA.Red).setLocalTranslation(pos);

        arrow = new Arrow(Vector3f.UNIT_Y);
        putShape(arrow, ColorRGBA.Green).setLocalTranslation(pos);

        arrow = new Arrow(Vector3f.UNIT_Z);
        putShape(arrow, ColorRGBA.Blue).setLocalTranslation(pos);

    }

    private Geometry putShape(Mesh shape, ColorRGBA color) {
        Geometry g = new Geometry("coordinate axis", shape);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.getAdditionalRenderState().setWireframe(true);
        mat.getAdditionalRenderState().setLineWidth(5);
        mat.setColor("Color", color);
        g.setMaterial(mat);
        g.setLocalScale(50f);
        rootNode.attachChild(g);
        return g;
    }
   
    
    
    @Override
    public void simpleUpdate(float tpf) {
      
        //TODO: add update code
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
