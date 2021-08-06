package leetcode;


import java.util.*;

/**
 * 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * 示例：
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NetworkDelayTime {

    //深度优先算法
//    Map<Integer, Integer> dist;
//    public int networkDelayTime(int[][] times, int N, int K) {
//        Map<Integer, List<int[]>> graph = new HashMap();
//        for (int[] edge: times) {
//            if (!graph.containsKey(edge[0]))
//                graph.put(edge[0], new ArrayList<int[]>());
//            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
//        }
//        for (int node: graph.keySet()) {
//            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
//        }
//        dist = new HashMap();
//        for (int node = 1; node <= N; ++node)
//            dist.put(node, Integer.MAX_VALUE);
//
//        dfs(graph, K, 0);
//        int ans = 0;
//        for (int cand: dist.values()) {
//            if (cand == Integer.MAX_VALUE) return -1;
//            ans = Math.max(ans, cand);
//        }
//        return ans;
//    }
//
//    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
//        if (elapsed >= dist.get(node)) return;
//        dist.put(node, elapsed);
//        if (graph.containsKey(node))
//            for (int[] info: graph.get(node))
//                dfs(graph, info[1], elapsed + info[0]);
//    }
    //迪杰斯特拉最短路径算法（Dijkstra's）
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dist.put(K, 0);
        boolean[] seen = new boolean[N+1];

        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) break;
            seen[candNode] = true;
            if (graph.containsKey(candNode))
                for (int[] info: graph.get(candNode))
                    dist.put(info[0],
                            Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        }

        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}
