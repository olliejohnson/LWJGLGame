package io.oliverj.game;

import io.oliverj.engine.GameItem;
import io.oliverj.engine.IHud;
import io.oliverj.engine.TextItem;
import io.oliverj.engine.Window;
import io.oliverj.engine.graph.FontTexture;
import io.oliverj.engine.graph.Material;
import io.oliverj.engine.graph.Mesh;
import io.oliverj.engine.graph.OBJLoader;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.awt.*;

public class Hud implements IHud {

    private static final Font FONT = new Font("Minecraft", Font.PLAIN, 30);

    private static final String CHARSET = "US-ASCII";

    private final GameItem[] gameItems;

    private final TextItem statusTextItem;

    private final GameItem compassItem;

    public Hud(String statusText) throws Exception {
        FontTexture fontTexture = new FontTexture(FONT, CHARSET);
        this.statusTextItem = new TextItem(statusText, fontTexture);
        this.statusTextItem.getMesh().getMaterial().setAmbientColour(new Vector4f(1, 1, 1, 1));

        Mesh mesh = OBJLoader.loadMesh("/models/compass.obj");
        Material material = new Material();
        material.setAmbientColour(new Vector4f(1, 0, 0, 1));
        mesh.setMaterial(material);
        compassItem = new GameItem(mesh);
        compassItem.setScale(40.0f);
        compassItem.setRotation(0f, 0f, 180f);

        gameItems = new GameItem[]{statusTextItem, compassItem};
    }

    public void setStatusText(String statusText) {
        this.statusTextItem.setText(statusText);
    }
    @Override
    public GameItem[] getGameItems() {
        return gameItems;
    }
    public void updateSize(Window window) {
        this.statusTextItem.setPosition(10f, window.getHeight() - 50f, 0);
    }

    public void rotateCompass(float angle) {
        this.compassItem.setRotation(0, 0, 180 + angle);
    }
}
