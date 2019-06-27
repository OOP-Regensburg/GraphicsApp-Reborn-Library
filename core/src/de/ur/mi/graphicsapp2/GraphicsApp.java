package de.ur.mi.graphicsapp2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import de.ur.mi.graphicsapp2.graphics.Color;
import de.ur.mi.graphicsapp2.graphics.GraphicsObject;

import java.util.ArrayList;

public class GraphicsApp extends ApplicationAdapter {
	Texture img;
	Camera camera;

	private boolean initilaized = false;

	public static ShapeRenderer shapeRenderer;
	static private boolean projectionMatrixSet;

	private Color backgroundColor = Color.WHITE;

	private ArrayList<GraphicsObject> graphicsObjects = new ArrayList<GraphicsObject>();
	
	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		size((int)camera.viewportWidth,(int)camera.viewportHeight);
		shapeRenderer = new ShapeRenderer();
		projectionMatrixSet = false;

		GraphicsObject.app = this;
	}

	@Override
	public void render () {
		camera.update();
		if(!initilaized){
			setup();
			initilaized = true;
		}
		System.out.println("rendering");
		super.render();

		Gdx.gl.glClearColor(backgroundColor.r/255f,backgroundColor.g/255f,backgroundColor.b/255f,backgroundColor.a/255f);
		Gdx.gl.glClear(Gdx.gl30.GL_COLOR_BUFFER_BIT);
		//see https://stackoverflow.com/questions/15397074/libgdx-how-to-draw-filled-rectangle-in-the-right-place-in-scene2d
		if(!projectionMatrixSet){
			shapeRenderer.setProjectionMatrix(camera.combined);
		}

		draw();

		for(GraphicsObject graphicsObject : graphicsObjects){
			graphicsObject.draw();
		}
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}

	public void addObject(GraphicsObject graphicsObject){
		graphicsObjects.add(graphicsObject);
	}

	public double getWidth(){
		return Gdx.graphics.getWidth();
	}

	public double getHeight(){
		return Gdx.graphics.getHeight();
	}

	public void background(Color color){
		backgroundColor = color;
	}

	public void setup(){
		System.out.println("super");
	}

	public void draw(){

	}

	public void size(int width, int height){
		Gdx.graphics.setWindowedMode(width, height);
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight/2,0);
	}
}
