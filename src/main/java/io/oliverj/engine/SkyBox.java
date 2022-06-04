package io.oliverj.engine;

import io.oliverj.engine.graph.Material;
import io.oliverj.engine.graph.Mesh;
import io.oliverj.engine.graph.OBJLoader;
import io.oliverj.engine.graph.Texture;

public class SkyBox extends GameItem {

    public SkyBox(String objModel, String textureFile) throws Exception {
        super();
        Mesh skyBoxMesh = OBJLoader.loadMesh(objModel);
        Texture skyBoxTexture = Texture.loadAsResource(textureFile);
        skyBoxMesh.setMaterial(new Material(skyBoxTexture, 0.0f));
        setMesh(skyBoxMesh);
        setPosition(0, 0, 0);
    }
}
