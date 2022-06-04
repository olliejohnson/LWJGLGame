package io.oliverj.engine;

public interface IGameLogic {
    void init(Window window) throws Exception;

    void input(Window window, MouseInput mouseInput);

    void update(Window window, float interval, MouseInput mouseInput);

    void render(Window window);

    void cleanup();
}
