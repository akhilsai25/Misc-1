// This solutions goes in opposite direction from target to startValue
// We perform negated operations ie., + for - and / for *
// If a given target is even, we perform /2 as thats the optimized approach to reach the startValue
// If it is not we add +1
// At any point if target goes below startValue we just have to add the difference to existing steps because thats the only option (- in original case)
class Solution {
    
    public int brokenCalc(int startValue, int target) { 
        if(startValue==target) return 0;
        int steps = 0;
        while(startValue!=target) {
            if(target<startValue) {
                return steps+startValue-target;
            }
            else if(target%2==0) {
                target=target/2;
            } else {
                target++;
            }
            steps++;
        }
        return steps;
    }
}
