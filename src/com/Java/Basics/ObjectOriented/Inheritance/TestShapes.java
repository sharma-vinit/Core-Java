package com.Java.Basics.ObjectOriented.Inheritance;

class GameShape {
    public void display() {
        System.out.println("displaying shape");
    }
    // more code
}
class PlayerPiece extends GameShape {
    public void movePiece() {
        System.out.println("moving game piece");
    }
    // more code
}
class TilePiece extends GameShape {
    public void getAdjacent() {
        System.out.println("getting adjacent tiles");
    }
    // more code
}

public class TestShapes {
    public static void main (String[] args) {
    	// Code re-usability using inheritance
        PlayerPiece shape = new PlayerPiece();
        shape.display();
        shape.movePiece();
        
        // Use of inheritance is to allow your classes to be accessed polymorphically.
        // A capability provided by interfaces as well.
        PlayerPiece player = new PlayerPiece();
        TilePiece tile = new TilePiece();
        doShapes(player);
        doShapes(tile);
    }
    
    public static void doShapes(GameShape shape) {
        shape.display();
    }

}



