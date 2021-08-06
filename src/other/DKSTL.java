package other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 狄克斯特拉算法
 */
public class DKSTL {
    public int getShortestPath(Map<String, HashMap<String, Integer>> graph, String start, String end) {
        HashSet<String> processedNodeSet = new HashSet<>();
        HashMap<String, Integer> costsMap = new HashMap<>();
        for (String node : graph.keySet()) {
            costsMap.put(node, Integer.MAX_VALUE);
        }
        HashMap<String, Integer> startNeighbors = graph.get(start);
        for (String item : startNeighbors.keySet()) {
            costsMap.put(item, startNeighbors.get(item));
        }
        processedNodeSet.add(start);
        String node = findLowestCostNode(costsMap, processedNodeSet);
        while (node != null) {
            Integer cost = costsMap.get(node);
            HashMap<String, Integer> neighbors = graph.get(node);
            for (String key : neighbors.keySet()) {
                int newCost = cost + neighbors.get(key);
                if (newCost < costsMap.get(key)) {
                    costsMap.put(key, newCost);
                }
            }
            processedNodeSet.add(node);
            node = findLowestCostNode(costsMap, processedNodeSet);
        }
        return costsMap.get(end);

    }

    public String findLowestCostNode(Map<String, Integer> costs, HashSet<String> processedNodeSet) {
        String ans = null;
        int lowCost = Integer.MAX_VALUE;

        for (String key : costs.keySet()) {
            if (costs.get(key) < lowCost && !processedNodeSet.contains(key)) {
                ans = key;
                lowCost = costs.get(key);
            }
        }
        return ans;
    }

}
