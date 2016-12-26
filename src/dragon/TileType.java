/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

/**
 *
 * @author Keith
 */
public enum TileType {
    
    Vegetation ("veg"), Entity("ent"), Loot("loot"), Object("obj");
    
    String name;
    
    TileType(String name) {
        this.name = name;
    }
}
