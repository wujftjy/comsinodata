package com.sino.data.controller;


import org.apache.commons.logging.LogFactory;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.List;

public class SB {
    // Map<v,boolean>
    private static void dfs_rec(ArrayList<ArrayList<Integer>> adjLists, boolean[] visited, int v, int d,
                                List<Integer> path) {
        visited[v] = true;
        path.add(v);
        if (v == d) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
            }
            System.out.println("");
        } else {
            for (int w : adjLists.get(v)) {
                if (!visited[w]) {
                    dfs_rec(adjLists, visited, w, d, path);
                }
            }
        }
        path.remove(path.size() - 1);
        visited[v] = false;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adjLists, int s, int d) {
        int n = adjLists.size();
        boolean[] visited = new boolean[n];

        List<Integer> path = new ArrayList<Integer>();
        int path_index = 0;
        dfs_rec(adjLists, visited, s, d, path);
    }

   /* public static void dfs(LinkedMultiValueMap map, int s, int d) {
        int n = map.keySet().size();
//        boolean[] visited = new boolean[n];
     //   Map
        List<Integer> path = new ArrayList<Integer>();
        int path_index = 0;
        dfs_rec(adjLists, visited, s, d, path);
    }*/

    public static void main(String[] args) {
        LinkedMultiValueMap map = new LinkedMultiValueMap();

        map.add("0","1");
        map.add("1","2");
        map.add("1","3");
        map.add("1","4");
        map.add("2","5");
        map.add("3","6");
        map.add("4","7");
        map.add("5","8");
        map.add("6","8");
        map.add("7","8");

        LogFactory.getLog("xxx").info(map);
      /*  ArrayList<ArrayList<Integer>> adjLists = new ArrayList<ArrayList<Integer>>();
        final int n = 9;

        for (int v = 0; v < n; v++) {
            adjLists.add(new ArrayList<Integer>());
        }
        adjLists.get(0).add(1);
        adjLists.get(1).add(2);
        adjLists.get(1).add(3);
        adjLists.get(1).add(4);
        adjLists.get(2).add(5);
        adjLists.get(3).add(6);
        adjLists.get(4).add(7);
        adjLists.get(5).add(8);
        adjLists.get(6).add(8);
        adjLists.get(7).add(8);


        dfs(adjLists, 0, 8);*/
    }
}