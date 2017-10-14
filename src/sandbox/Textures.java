package sandbox;

import engine.gfx.Sprite;
import engine.gfx.SpriteSheet;

public class Textures {

    public static SpriteSheet LEVEL_1_SHEET = new SpriteSheet("spritesheet/level_1.png", 16);

    public static Sprite STONE = new Sprite(LEVEL_1_SHEET, 0, 0);
    public static Sprite GRASS = new Sprite(LEVEL_1_SHEET, 1, 0);
    public static Sprite GRASS_FLOWER = new Sprite(LEVEL_1_SHEET, 2, 0);
    public static Sprite DIRT = new Sprite(LEVEL_1_SHEET, 3, 0);

    public static Sprite COIN = new Sprite("items/coin.png");
    public static Sprite PLAYER = new Sprite("player/player.png");

}
