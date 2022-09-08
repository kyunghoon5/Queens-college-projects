# Analysis of Algorithms - CSCI 323
# Assignment 4 (Graph Algorithms)
# Kyunghoon Oh


import math
import random
import sys
import time
from functools import reduce
from os import listdir
from os.path import isfile, join
import pandas as pd
import matplotlib.pyplot as plt
from copy import deepcopy
from heapq import heappop, heappush

cap = 100


def process_file(file_name, my_path):
    with open(my_path + file_name, 'r') as file:
        weights = []
        lines = file.readlines()
        for line in lines:
            weights.append(int(line))

        print('Item#: ', len(weights))
    return weights


def plot_times_bar_graph(file_dict, algos, file_name):
    search_nums = 0
    plt.xticks([j for j in range(len(algos))], [algo.__name__ for algo in algos])

    for algo in algos:
        search_nums += 1
        d = file_dict[file_name]
        x_axis = [search_nums - 1]
        y_axis = [d[algo.__name__]]
        plt.bar(x_axis, y_axis, width=0.05, alpha=0.25, label=algo.__name__)
    plt.legend()
    plt.title('Bin packing Approximation Runtime')
    plt.xlabel('Number Of Trials')
    plt.ylabel('Number of bins')
    plt.savefig(file_name[0:4] + '_graph.png')
    plt.show()


def make_table(file_dict):
    pd.set_option('display.max_rows', 500)
    pd.set_option('display.max_columns', 500)
    pd.set_option('display.width', 1000)
    df = pd.DataFrame.from_dict(file_dict).T
    print(df)


def bpp_nextFit(weights):
    nBins = 0
    remCap = cap

    for weight in weights:
        if weight > remCap:
            nBins += 1
            remCap = cap
        remCap -= weight
    return nBins


def bpp_FirstFit(weights):
    # Initialize result (Count of bins)
    res = 0
    # Create an array to store remaining space in bins
    # there can be at most n bins
    bin_rem = [0] * len(weights)
    # Place items one by one
    for i in range(len(weights)):
        # Find the first bin that can accommodate
        # weight[i]
        j = 0
        while (j < res):
            if (bin_rem[j] >= weights[i]):
                bin_rem[j] = bin_rem[j] - weights[i]
                break
            j += 1
        # If no bin could accommodate weight[i]
        if (j == res):
            bin_rem[res] = cap - weights[i]
            res = res + 1
    return res


def bpp_BestFit(weights):
    # Initialize result (Count of bins)
    res = 0
    # Create an array to store remaining space in bins there can be at most n bins
    bin_rem = [0] * len(weights)
    # Place items one by one
    for i in range(len(weights)):
        # Find the first bin that can accommodate weight[i]
        # Initialize minimum space left and index of best bin
        min = cap + 1
        bi = 0
        for j in range(res):
            if bin_rem[j] >= weights[i] and bin_rem[j] - weights[i] < min:
                bi = j
                min = bin_rem[j] - weights[i]

        # If no bin could accommodate weight[i],
        # create a new bin
        if min == cap + 1:
            bin_rem[res] = cap - weights[i]
            res += 1
        else:  # Assign the item to best bin
            bin_rem[bi] -= weights[i]
    return res


def optimal_num(weights):
    return math.ceil(reduce(lambda a, b: a + b, weights) / 100)


def offline_ff(weights):
    s = sorted(deepcopy(weights), reverse=True)
    return bpp_FirstFit(s)


def offline_bfd(weights):
    weights.sort()
    weights.reverse()
    return bpp_BestFit(weights)


def main():
    my_path = 'C:\\Users\\oh\\PycharmProjects\\Assignment5\\BPP_data\\'
    t = {}
    key = '40 trials'
    t[key] = {}
    bin_algs = [optimal_num, bpp_nextFit, bpp_FirstFit, bpp_BestFit, offline_ff, offline_bfd]
    files = [f for f in listdir(my_path) if isfile(join(my_path, f))]

    for algo in bin_algs:
        if algo.__name__ != 'optimal_num':
            t[key][algo.__name__] = 0

    for i, file in enumerate(files):
        dict_weights = {}
        print('processing ' + file + '\n')
        weights = process_file(file, my_path)
        dict_weights[file] = {}

        for algo in bin_algs:
            if algo.__name__ != 'optimal_num':
                start_time = time.time()
                dict_weights[file][algo.__name__] = algo(weights)
                end_time = time.time()
                net_time = end_time - start_time
                t[key][algo.__name__] += (net_time * 1000)

            else:
                dict_weights[file][algo.__name__] = algo(weights)
        if i % 10 == 0:
            plot_times_bar_graph(dict_weights, bin_algs, file)

        make_table(dict_weights)
    make_table(t)


if __name__ == '__main__':
    main()