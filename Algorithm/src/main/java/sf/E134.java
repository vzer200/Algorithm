package sf;

public class E134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int res = 0;

        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            if (currTank<0){
                //表示当前油量无法支撑到下个加油站
                res = i + 1;
                currTank=0;
            }

        }

        return totalTank>=0?res:-1;
    }

}
