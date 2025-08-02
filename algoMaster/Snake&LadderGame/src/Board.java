import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    int size;
    Map<Integer,Integer> ladderMap;
    Map<Integer,Integer> snakeMap;


    public Board(int size, List<Ladder> ladders, List<Snake> snakes) {
        this.size = size;
        ladderMap = new HashMap<>();
        snakeMap = new HashMap<>();
        for (Ladder ladder : ladders) {
            ladderMap.put(ladder.start,ladder.end);
        }
        for (Snake snake : snakes) {
            snakeMap.put(snake.start,snake.end);
        }

    }

    public int nextMove(int currPos){
        int nextMove = currPos;
        if(ladderMap.containsKey(currPos)){
            System.out.println("move to " + ladderMap.get(currPos));
            nextMove = ladderMap.get(currPos);
        }
        if(snakeMap.containsKey(currPos)){
            System.out.println("move to " + snakeMap.get(currPos));
            nextMove = snakeMap.get(currPos);
        }
        return nextMove;
    }

    public int getSize(){
        return size;
    }


}
