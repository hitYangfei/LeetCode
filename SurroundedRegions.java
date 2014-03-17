package yf.leetcode;

public class SurroundedRegions {
	public static void main(String[] argvs){
		char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		int row = board.length;
		int colum = board[0].length;
		new SurroundedRegions().solve(board);
		for(int i=0;i<row;i++){
			for(int j=0;j<colum;j++){
		    	System.out.print(board[i][j]);
		    }
			System.out.println();
		}
	}
	public void solve(char[][] board) {
	    int row = board.length;
	    if(row==0)
	    	return;
	    int colum = board[0].length;
	    if(colum==0)
	    	return;
	    for(int i=0;i<colum;i++){
	    	if(board[0][i]=='O'){
	    		dfs(board,0,i,row,colum);
	    	}
	    }
	    for(int i=0;i<row;i++){
	    	if(board[i][colum-1]=='O'){
	    		dfs(board,i,colum-1,row,colum);
	    	}
	    }
	    for(int i=0;i<colum;i++){
	    	if(board[row-1][i]=='O'){
	    		dfs(board,row-1,i,row,colum);
	    	}
	    }
	    for(int i=0;i<row;i++){
	    	if(board[i][0]=='O'){
	    		dfs(board,i,0,row,colum);
	    	}
	    }
	   
	    for(int i=0;i<row;i++){
	    	for(int j=0;j<colum;j++){
	    		if(board[i][j]=='O'){
	    			board[i][j]='X';
	    		}
	    	}
	    }
	    for(int i=0;i<row;i++){
	    	for(int j=0;j<colum;j++){
	    		if(board[i][j]=='R'){
	    			board[i][j]='O';
	    		}
	    	}
	    }
	}
	private void dfs(char[][] board,int x,int y,int row,int colum){
		board[x][y]='R';
		if(x>1&&board[x-1][y]=='O')
			dfs(board,x-1,y,row,colum);
		if(y>1&&board[x][y-1]=='O')
			dfs(board,x,y-1,row,colum);
		if(x<row-1&&board[x+1][y]=='O')
			dfs(board,x+1,y,row,colum);
		if(y<colum-1&&board[x][y+1]=='O')
			dfs(board,x,y+1,row,colum);
	}
}
