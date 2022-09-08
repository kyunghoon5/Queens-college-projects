# Analysis of Algorithms - CSCI 323
# Assignment 4 (Graph Algorithms)
# Kyunghoon Oh

import sys
from timeit import default_timer as timer
from os import listdir
from os.path import isfile, join
from copy import deepcopy
from heapq import heappop, heappush


def read_graph(file_name):
    with open(file_name, 'r') as file:
        graph = []
        lines = file.readlines()
        for line in lines:
            costs = line.split(' ')
            row = []
            for cost in costs:
                row.append(int(cost))
            graph.append(row)
        return graph


def desc_graph(graph):
    num_vertices = len(graph)
    message = ''
    message += 'Number of vertices = ' + str(num_vertices) + '\n'
    non_zero = 0
    for i in range(num_vertices):
        for j in range(num_vertices):
            if graph[i][j] > 0:
                non_zero += 1
    num_edges = int(non_zero / 2)
    message += 'Number of edges = ' + str(num_edges) + '\n'
    message += 'Symmetric = ' + str(is_symmetric(graph)) + '\n'
    return message


def is_symmetric(graph):
    num_vertices = len(graph)
    for i in range(num_vertices):
        for j in range(num_vertices):
            if graph[i][j] != graph[j][i]:
                return False
    return True


def print_graph(graph, sep=' '):
    str_graph = ''
    for row in range(len(graph)):
        str_graph += sep.join([str(c) for c in graph[row]]) + '\n'
    return str_graph


def print_dist(dist, sep=' '):
    str_dist = ''
    for row in range(len(dist)):
        str_dist += sep.join([str(c) for c in dist[row]]) + '\n'
    return str_dist


# https://stackoverflow.com/questions/43375515/breadth-first-search-with-adjacency-matrix
def matrix_to_list(matrix):
    graph = {}
    for i, node in enumerate(matrix):
        adj = []
        for j, connected in enumerate(node):
            if connected:
                adj.append(j)
        graph[i] = adj
    return graph


def analyze_graph(file_name):
    mypath = "C:\\Users\\oh\\PycharmProjects\\Assignment4"
    graph = read_graph(file_name)
    file_name = file_name[0:len(file_name) - 4] + '_report.txt'
    write_to_console = True
    sys.stdout = sys.__stdout__
    for i in range(2):
        if not write_to_console:
            sys.stdout = open(file_name, 'w')
        print("Analysis of " + file_name + ':\n\n')

        str_graph = print_graph(graph)
        print(str_graph + '\n')
        desc = desc_graph(graph)
        print(desc + '\n')
        s1 = timer()
        dfs(graph)
        e1 = timer()
        t1 = abs(e1 - s1) * 1000
        print('\n' + 'Time(ms): ', t1)
        print()
        s2 = timer()
        bfs(deepcopy(graph))
        e2 = timer()
        t2 = abs(e2 - s2) * 1000
        print('\n' + 'Time(ms): ', t2)
        print()
        s3 = timer()
        prim_mst(deepcopy(graph))
        e3 = timer()
        t3 = abs(e3 - s3) * 1000
        print('Time(ms): ', t3)
        print()
        s4 = timer()
        kruskalmst(deepcopy(graph))
        e4 = timer()
        t4 = abs(e4 - s4) * 1000
        print('Time: ', t4)
        print()
        s5 = timer()
        dijkstra(deepcopy(graph))
        e5 = timer()
        t5 = abs(e5 - s5) * 1000
        print('Time: ', t5)
        s6 = timer()
        floyd(deepcopy(graph))
        e6 = timer()
        t6 = abs(e6 - s6) * 1000
        print('Time: ', t6)
        if not write_to_console:
            sys.stdout.close()
        else:
            write_to_console = False


def dfs_util(graph, v, visited):
    visited[v] = True
    print(v, end=' ')
    for col in range(len(graph[v])):
        if graph[v][col] != 0 and not visited[col]:
            dfs_util(graph, col, visited)


def dfs(graph):
    print('DFS traversal: ')
    visited = [False] * len(graph)
    dfs_util(graph, 0, visited)


def bfs_util(graph, s):
    visited = [False] * len(graph)
    queue = [s]
    visited[s] = True
    while queue:
        v = queue[0]
        print(v, end=' ')
        queue.pop(0)
        for i in range(len(graph)):
            if graph[v][i] > 0 and not visited[i]:
                queue.append(i)
                visited[i] = True


def bfs(graph):
    print('BFS traversal: ')
    bfs_util(graph, 0)


def pmst(graph, parent):
    print("edge \tweight")
    sum = 0
    for i in range(1, len(graph)):
        print(parent[i], ' ', i, "\t", graph[i][parent[i]])
        sum += graph[i][parent[i]]
    print("cost: " + str(sum))


def minKey(graph, key, mstSet):
    min = sys.maxsize

    for v in range(len(graph)):
        if key[v] < min and not mstSet[v]:
            min = key[v]
            min_index = v

    return min_index


def prim_mst(graph):
    print('Prims MST: ')
    key = [sys.maxsize] * len(graph)
    parent = [None] * len(graph)
    key[0] = 0
    mstSet = [False] * len(graph)
    parent[0] = -1

    for count in range(len(graph)):
        u = minKey(graph, key, mstSet)
        mstSet[u] = True
        for v in range(len(graph)):
            if 0 < graph[u][v] < key[v] and not mstSet[v]:
                key[v] = graph[u][v]
                parent[v] = u
    pmst(graph, parent)


# https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
def find(parent, i):
    if parent[i] == i:
        return i
    return find(parent, parent[i])


# A function that does union of two sets of x and y
# (uses union by rank)
def union(parent, rank, x, y):
    x_root = find(parent, x)
    y_root = find(parent, y)

    # Attach smaller rank tree under root of
    # high rank tree (Union by Rank)
    if rank[x_root] < rank[y_root]:
        parent[x_root] = y_root
    elif rank[x_root] > rank[y_root]:
        parent[y_root] = x_root

    # If ranks are same, then make one as root
    # and increment its rank by one
    else:
        parent[y_root] = x_root
        rank[x_root] += 1


def kruskal_mst(graph, v):
    result = []
    i = 0
    e = 0
    graph = sorted(graph, key=lambda item: item[2])

    parent = []
    rank = []

    for node in range(v):
        parent.append(node)
        rank.append(0)

    while e < v - 1:
        u, v, w = graph[i]
        i = i + 1
        x = find(parent, u)
        y = find(parent, v)
        if x != y:
            e = e + 1
            result.append([u, v, w])
            union(parent, rank, x, y)

    minimumCost = 0
    print("edges \tweight")
    for u, v, weight in result:
        minimumCost += weight
        print("%d  %d    %d" % (u, v, weight))
    print("cost: ", minimumCost)


def kruskalmst(graph):
    print('kruskal MST: ')
    kruskal_mst(graph_to_tuple(graph), len(graph))


def graph_to_tuple(graph):
    list_tuple = []
    for i in range(len(graph)):
        for j in range(len(graph)):
            if graph[i][j] != 0:
                list_tuple.append([i, j, graph[i][j]])
    return list_tuple


def print_matrix(graph):
    for i in range(0, len(graph)):
        for j in range(0, len(graph)):
            print(graph[i][j], end=' ')
        print()


class Node:
    def __init__(self, vertex, weight=0):
        self.vertex = vertex
        self.weight = weight

    # Override the __lt__() function to make `Node` class work with a min-heap
    def __lt__(self, other):
        return self.weight < other.weight


class Graph:
    def __init__(self, edges, n):
        # allocate memory for the adjacency list
        self.adjList = [[] for _ in range(n)]

        # add edges to the directed graph
        for (source, dest, weight) in edges:
            self.adjList[source].append((dest, weight))


def get_route(prev, i, route):
    if i >= 0:
        get_route(prev, prev[i], route)
        route.append(i)


def find_shortest_paths(graph, source, n):
    pq = []
    heappush(pq, Node(source))

    dist = [sys.maxsize] * n

    dist[source] = 0

    done = [False] * n
    done[source] = True

    prev = [-1] * n

    while pq:

        node = heappop(pq)
        u = node.vertex

        for (v, weight) in graph.adjList[u]:
            if not done[v] and (dist[u] + weight) < dist[v]:
                dist[v] = dist[u] + weight
                prev[v] = u
                heappush(pq, Node(v, dist[v]))

        done[u] = True

    route = []
    for i in range(n):
        if i != source and dist[i] != sys.maxsize:
            get_route(prev, i, route)
            print(dist[i], end=' ')
            route.clear()
        else:
            print(0, end=' ')
    return prev


def graph_to_tuple2(graph):
    list_tuple = []
    for i in range(len(graph)):
        for j in range(len(graph)):
            if graph[i][j] != 0:
                list_tuple.append((i, j, graph[i][j]))
    return list_tuple


def dijkstra(graph):
    pre = []
    temp_graph = graph_to_tuple2(graph)
    tuple_graph = Graph(temp_graph, len(graph))
    print("Dijkstra's APSP: ")
    for i in range(len(graph)):
        pre.append(find_shortest_paths(tuple_graph, i, len(graph)))
        print()
    print()
    print("Dijkstra's Pred APSP: ")
    print_matrix(pre)


def floyd(graph):
    v =len(graph)
    dist = [(v*[0]) for i in range(v)]
    pred = [(v*[0]) for i in range(v)]

    for i in range(v):
        for j in range(v):
            dist[i][j] = graph[i][j]
            pred[i][j] = i

            if dist[i][j] ==0:
                dist[i][j] = sys.maxsize
        dist[i][i] = 0
        pred[i][i] = -1

    for k in range(v):
        for i in range(v):
            for j in range(v):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
                    pred[i][j] = pred[k][j]
    print()
    print("Floyd's APSP: ")
    print_matrix(dist)
    print()
    print("Floyd's Pred: ")
    print_matrix(pred)


def floydp(graph):
    v =len(graph)
    dist = [(v*[0]) for i in range(v)]
    pred = [(v*[0]) for i in range(v)]

    for i in range(v):
        for j in range(v):
            dist[i][j] = graph[i][j]
            pred[i][j] = i

            if dist[i][j] ==0:
                dist[i][j] = sys.maxsize
        dist[i][i] = 0
        pred[i][i] = -1

    for k in range(v):
        for i in range(v):
            for j in range(v):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
                    pred[i][j] = pred[k][j]
                    result = print_graph(pred)
    return result


def main():
    mypath = "C:\\Users\\oh\\PycharmProjects\\Assignment4"
    files = [f for f in listdir(mypath) if isfile(join(mypath, f))]
    for file in files:
        if file[0:5] == 'graph' and file.find('_report') < 0:
            analyze_graph(file)


if __name__ == '__main__':
    main()