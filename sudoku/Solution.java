class Solution{

    public static void main(String[] args){

	//int[][] st=new int[9][9];
	/*for(int i=0;i<9;i++)
	    for(int j=0;j<9;j++)
		st[i][j]=0;
	*/
	int[][] st=new int[][]{
	            {7,1,8,3,9,4,2,6,0},
		    {0,6,0,2,0,0,0,0,0},
		    {0,4,2,8,0,7,0,1,0},
		    {9,0,6,0,1,0,0,0,0},
		    {0,0,3,9,0,6,1,0,0},
		    {0,0,0,0,3,0,7,0,6},
		    {0,9,0,1,0,3,4,5,0},
		    {0,0,0,0,0,5,0,7,0},
		    {0,8,5,7,4,9,6,3,1}
	};
	System.out.println("return value is "+sudoku(st,0,0));
	for(int i=0;i<9;i++){
	    for(int j=0;j<9;j++){
		System.out.print(st[i][j]+" ");
	    }
	    System.out.println();
	}
    }

    static boolean sudoku(int[][] st,int row,int col){
	if(st[row][col]==0){
	    for(int i=1;i<=9;i++){
		if(isok(st,row,col,i)){
		    st[row][col]=i;
		    if(row==8 && col==8){
			return true;
		    }
		    if(col<8){
			if(sudoku(st,row,col+1))
			    return true;
		    }
		    else{
			if(sudoku(st,row+1,0))
			    return true;
		    }
		}	    
	    }
	    st[row][col]=0;
	    return false;
	}
	else{
	    if(isok(st,row,col,st[row][col])){
		if(row==8 && col==8){
		    return true;
		}
		if(col<8){
		    if(sudoku(st,row,col+1))
			return true;
		}
		else{
		    if(sudoku(st,row+1,0))
			return true;
		}
	    }
	    return false;
	    
	}
    }

    static boolean isok(int[][] st, int row,int col,int x){
	
	    for(int j=0;j<col;j++){
		if(x==st[row][j]){
		    return false;
		}
	    }
	    for(int i=0;i<row;i++){
		if(x==st[i][col]){
		    return false;
		}
	    }
	    for(int i=(row/3)*3;i<(row/3)*3+3;i++){
		for(int j=(col/3)*3;j<(col/3)*3+3;j++){
		    if(i!=row && j!=col){
			if(x==st[i][j])
			    return false;
		    }
		}
	    }
	    return true;

    }
}
