class Solution {
    public double angleClock(int hour, int minutes) {
        double hourdegree=(hour%12)*30+(0.5)*minutes;
        double minutesdegree=6*minutes;

        double diff=Math.abs(hourdegree-minutesdegree);

        return Math.min(diff,360-diff);

        
    }
}
