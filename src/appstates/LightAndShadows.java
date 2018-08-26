/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appstates;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.shadow.DirectionalLightShadowFilter;

/**
 *
 * @author vik24rus
 */
public class LightAndShadows extends BaseAppState{
    private SimpleApplication app;
    @Override
    protected void initialize(Application app)
    {
        this.app = (SimpleApplication) app;
        
    }

    @Override
    protected void cleanup(Application app)
    {
        
    }

    @Override
    protected void onEnable()
    {
        //AmbientLight al = new AmbientLight();
        //al.setColor(ColorRGBA.White.mult(1.0f));
        //rootNode.addLight(al);

        
        // create light
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-1.5f, -5f, -1.5f)).normalizeLocal());
        System.out.println("Here We Go: " + sun.getDirection());
        sun.setColor(ColorRGBA.White);
        this.app.getRootNode().addLight(sun); 
        
         // init shadows
        FilterPostProcessor processor = new FilterPostProcessor(this.app.getAssetManager());
        DirectionalLightShadowFilter filter = new DirectionalLightShadowFilter(this.app.getAssetManager(), 2048, 1);
        filter.setLight(sun);
        processor.addFilter(filter);
        app.getViewPort().addProcessor(processor);
    }

    @Override
    protected void onDisable()
    {
       
    }
    
}
