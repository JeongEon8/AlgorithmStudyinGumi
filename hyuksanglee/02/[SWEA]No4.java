class UserSolution {
    
    int N ;
    int[][] mSoldier;
    char[][][] mMonarch;
    void init(int N, int mSoldier[][], char mMonarch[][][])
    {
		this.N = N;
        this.mSoldier =mSoldier;
        this.mMonarch  = mMonarch;
    }
    void destroy()
    {

    }
    int ally(char mMonarchA[], char mMonarchB[])
    {
        
        return -4;
    }
    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[])
    {
        return -3;
    }
    int recruit(char mMonarch[], int mNum, int mOption)
    {
        return -1;
    }
}