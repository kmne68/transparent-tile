/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon;

/**
 *
 * @author Keith
 */
public class TileGrid {
    
    public Tile[][] map;
    
    public TileGrid() {
        
        map = new Tile[20][15];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.DEFAULT);                
            }
        }
    }
    
    
    public void setTile(int xCoord, int yCoord, TileType type) {
        
        map[xCoord][yCoord] = new Tile(xCoord * 64, yCoord * 64, 64, 64, type);
    }
    
    
    public Tile getTile(int xPlace, int yPlace) {
        return map[xPlace][yPlace];
    }
    
    
    public void Draw() {
        
        for(int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                map[i][j].Draw;
            }
        }
    }
}
