class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkInMap;
    private Map<String, double[]> travelStats; // key: "start->end", value: [totalTime, count]

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInInfo = checkInMap.remove(id);
        String startStation = checkInInfo.getKey();
        int startTime = checkInInfo.getValue();
        
        String key = startStation + "->" + stationName;
        double[] stats = travelStats.getOrDefault(key, new double[]{0, 0});
        stats[0] += (t - startTime);
        stats[1] += 1;
        travelStats.put(key, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        double[] stats = travelStats.get(key);
        return stats[0] / stats[1];
    }
}
