package sort;

import java.util.*;

public class TopologySort {
    public static void main(String[] args) {
        // 그래프 구성
        int N = 6; //노드 개수 (0~5)
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; ++i) graph.add(new ArrayList<>());

        //      5       4
        //     / \     / \
        //    2   0   0   1
        //    |
        //    3
        //    |
        //    1
        addEdge(graph, 5, 2);
        addEdge(graph, 5, 0);
        addEdge(graph, 4, 0);
        addEdge(graph, 4, 1);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);

        // DFS Topo Sort
        topoSortDFS(N, graph);

        // BFS(Kahn) Topo Sort
        topoSortBFS(N, graph);
    }

    static void addEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
    }

    /*
        1. 방문 여부 배열 visited[] 준비
        2. 모든 노드에 대해 방문하지 않았다면 DFS 실행
        3. DFS(node)
            1. node 방문 표시
            2. node의 모든 자식(node → next) 재귀 DFS
            3. node를 스택에 push
        4. DFS 종료 시 스택을 뒤집거나 pop 순서대로 출력
     */
    static void dfsTopo(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[node] = true;
        for(int next : graph.get(node)) {
            if(!visited[next]) dfsTopo(next, visited, stack, graph);
        }
        stack.push(node);
    }

    static void topoSortDFS(int N, List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];

        for(int i = 0; i < N; i++) {
            if(!visited[i]) dfsTopo(i, visited, stack, graph);
        }

        System.out.print("DFS Topo Sort: ");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    /*
        1. 각 노드의 진입차수 계산
        2. 진입 차수가 0인 노드를 큐에 넣음
        3. 큐가 빌 때까지 반복
            1. 큐에서 노드를 꺼내 배열에 추가
            2. 해당 노드의 자식 노드들의 진입 차수를 -1
            3. 새로 진입차수가 0된 노드들을 큐에 추가
        4. 모든 노드를 처리 완료했으면 Topo 순서 완성
     */
    static void topoSortBFS(int N, List<List<Integer>> graph) {
        int[] indegree = new int[N];

        for (List<Integer> integers : graph) {
            for (int next : integers) {
                indegree[next]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        for(int i = 0; i < N; ++i) {
            if(indegree[i] == 0) q.offer(i);
        }

        for(int i = 0; i < N; ++i) {
            if(q.isEmpty()) {
                System.out.println("사이클 존재!");
                return;
            }

            int cur = q.poll();

            for(int next : graph.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }

            topo.add(cur);
        }

        System.out.print("BFS(Kahn) Topo Sort: ");
        for(int val : topo) System.out.print(val + " ");
        System.out.println();
    }
}
