/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

/**
 *
 * @author Keith
 */
public class Tile {
    
    private float x, y, width, height;
    private TileType type;
    
    
    public Tile(float x, float y, float width, float height, TileType type) {
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;        
    }
    
    public void Draw() {

    }
    
    
    public float getX() {
        return x;
    }
    
    
    public int getXPlace() {
        return (int) x / 64;
    }
    
    public int getYPlace() {
        return (int) y / 64;
    }
    
    
    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }
    
    
    public void setY(float y) {
        this.y = y;
    }
    
    public float getWidth() {
        return width;
    }
    
    public void setWidth(float width) {
        this.width = width;
    }
    
    public float getHeight() {
        return height;
    }
    
    
    public void setHeight(float height) {
        this.height = height;
    }
    
    public TileType getType() {
        return type;
    }
    
    public void setType(TileType type) {
        this.type = type;
    }
}
