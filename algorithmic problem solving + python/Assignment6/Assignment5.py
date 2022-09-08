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

        nbins = BPP_nextFit(weights)
        opt_bins = sum(weights) / cap

        print(file_name, ' Number of weights: ', len(weights), "Bins for BPP next fit: ", nbins, 'Opt bins: ', opt_bins)
    return weights


def BPP_nextFit(weights):
    nBins = 0
    remCap = cap

    for weight in weights:
        if weight > remCap:
            nBins += 1
            remCap = cap
        remCap -= weight
    return nBins


def BBP_firstFit(weights):
    n = len(weights)
    res = 0
    bin_rem = [0] * n
    for i in range(n):
        j = 0
        while j < res:
            if bin_rem[j] >= weights[i]:
                bin_rem[j] = bin_rem[j] - weights[i]
                break
            j += 1
        if j == res:
            bin_rem[res] = cap = weights[i]
            res = res + 1
    return res


def BBP_bestFit(weights):
    n = len(weights)
    res = 0
    bin_rem = [0] * n

    for i in range(n):
        j = 0
        while j < res:
            if bin_rem[j] >= weights[i]:
                bin_rem[j] = bin_rem[j] - weights[i]
                break
            j += 1
        if j == res:
            bin_rem[res] = cap - weights[i]
            res = res + 1
    return res


def offline_ffd(weights):
    weights.sort()
    weights.reverse()
    return BBP_firstFit(weights)


def offline_bfd(weights):
    weights.sort()
    weights.reverse()
    return BBP_bestFit(weights)


def optimal_num(weights):
    return math.ceil(reduce(lambda a, b: a + b, weights) / 100)


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
    plt.title('bin packing')
    plt.xlabel('algorithms')
    plt.ylabel('bins')
    plt.savefig(file_name[0:4] + '_graph.png')
    plt.show()


def make_table(file_dict):
    df = pd.DataFrame.from_dict(file_dict).T
    print(df)


def main():
    my_path = '/Users/rishaavgupta/PycharmProjects/Assignment5/data/'
    t = {}
    key = '40 trials'
    t[key] = {}
    bin_algs = [BBP_bestFit, BBP_firstFit, BPP_nextFit, offline_ffd, offline_bfd, optimal_num]
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
                print(algo.__name__ + ' fin \n')
            else:
                dict_weights[file][algo.__name__] = algo(weights)
        if i % 10 == 0:
            plot_times_bar_graph(dict_weights, bin_algs, file)

        make_table(dict_weights)
    make_table(t)


if __name__ == '__main__':
    main()
