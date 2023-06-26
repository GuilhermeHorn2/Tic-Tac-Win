package misc;

import java.util.ArrayList;
import java.util.Random;

public class tic_tac_toe_check {
	
	//1 is X and 0 is O
	
	
	public static class position{
		int x;
		int y;
		position(int x,int y){
			this.x = x;
			this.y = y;
		}
		public boolean equals(position p){
			if(this.x == p.x && this.y == p.y) {
				return true;
			}
			return false;
		}
		public String toString(){
			return "("+x+","+y+")";
		}
	}
	
	private ArrayList<ArrayList<Integer>> board = new ArrayList<>();
	
	
	tic_tac_toe_check(){
		for(int i = 0;i < 3;i++) {
			board.add(new ArrayList<>());
			for(int j = 0;j < 3;j++) {
				board.get(i).add(-1);
			}
		}
	}
	
	
	public boolean in_list(ArrayList<position> ones,position pos){
		
		for(int i = 0;i < ones.size();i++){
			if(ones.get(i).equals(pos)){
				return true;
			}
		}
		return false;
		
	}
	
	public void random_board() {
		
		//generate 5 random positions for 1 and fill the rest with 0
		
		ArrayList<position> tmp = new ArrayList<>();
		
		while(tmp.size() < 5){
			
			while(true){
				
				//(0,0) --> (2,2)
				
				Random a = new Random();
				int x = a.nextInt(3);
				Random b = new Random();
				int y = b.nextInt(3);
				position p = new position(x,y);
				
				if(!in_list(tmp,p)) {
					tmp.add(p);
					break;
				}
				
			}
		}
		//System.out.println(tmp);
		
		for(int i = 0;i < tmp.size();i++){
			position p = tmp.get(i);
			board.get(p.x).remove(p.y);
			board.get(p.x).add(p.y,1);
		}
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 3;j++) {
				if(board.get(i).get(j) == -1){
					board.get(i).remove(j);
					board.get(i).add(j,0);
				}
			}
		}
		
		
	}
	
	public void print_board(){
		for(int i = 0;i < 3;i++) {
			System.out.println(board.get(i));
		}
	}
	
	public boolean win(int x) {
		
		//compelte a row:
		for(int i = 0;i < 3;i++){
			int c = 0;
			for(int j = 0;j < 3;j++){
				if(board.get(i).get(j) == x){
					c++;
				}
			}
			if(c == 3){
				System.out.println(x + " wins");
				return true;
			}
		}
		
		//complete a column:
		for(int i = 0;i < 3;i++){
			int c = 0;
			for(int j = 0;j < 3;j++){
				if(board.get(j).get(i) == x){
					c++;
				}
			}
			if(c == 3) {
				System.out.println(x + " wins");
				return true;
			}
		}
		
		//complete a diagonal
		
		int i = 0;
		int c = 0;
		while(i < 3){
			if(board.get(i).get(i) == x){
				c++;
			}
			i++;
		}
		if(c == 3) {
			System.out.println(x + " wins");
			return true;
		}
		
		return false;
	}

}
