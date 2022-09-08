# Analysis of Algorithms - CSCI 323 15W
# Assignment 3
# Kyunghoon Oh 23779321


import math
import random
import string
import time
import pandas as pd
import matplotlib.pyplot as plt
from lorem_text import lorem


def random_txt(m):
    s = string.ascii_uppercase
    return ''.join(random.choice(s) for i in range(m))


def random_pattern(n, txt):
    pattern = ''.join((random.choice(txt)) for x in range(n // 2))
    return pattern


def native_search(pat, txt):
    a = txt.find(pat)


def brute_force_search(pat, txt):
    M = len(pat)
    N = len(txt)

    # A loop to slide pat[] one by one */
    for i in range(N - M + 1):
        j = 0

        # For current index i, check
        # for pattern match */
        while (j < M):
            if (txt[i + j] != pat[j]):
                break
            j += 1

        if (j == M):
            print("Pattern found at index ", i)


def kmp_search(pat, txt):
    M = len(pat)
    N = len(txt)

    # create lps[] that will hold the longest prefix suffix
    # values for pattern
    lps = [0] * M
    j = 0  # index for pat[]

    # Preprocess the pattern (calculate lps[] array)
    computeLPSArray(pat, M, lps)

    i = 0  # index for txt[]
    while i < N:
        if pat[j] == txt[i]:
            i += 1
            j += 1

        if j == M:
            print("Found pattern at index " + str(i - j))
            j = lps[j - 1]

        # mismatch after j matches
        elif i < N and pat[j] != txt[i]:
            # Do not match lps[0..lps[j-1]] characters,
            # they will match anyway
            if j != 0:
                j = lps[j - 1]
            else:
                i += 1


def computeLPSArray(pat, M, lps):
    len = 0  # length of the previous longest prefix suffix

    lps[0]  # lps[0] is always 0
    i = 1

    # the loop calculates lps[i] for i = 1 to M-1
    while i < M:
        if pat[i] == pat[len]:
            len += 1
            lps[i] = len
            i += 1
        else:
            # This is tricky. Consider the example.
            # AAACAAAA and i = 7. The idea is similar
            # to search step.
            if len != 0:
                len = lps[len - 1]

                # Also, note that we do not increment i here
            else:
                lps[i] = 0
                i += 1


def rabin_karp_search(pat, txt):
    base = 26
    p_hash = 0
    s_hash = 0
    for i in txt:
        p_hash = p_hash * base + ord(i)-ord('A')
    for j,v in enumerate(pat):
        if j < len(txt) - 1:
            s_hash = s_hash * base + ord(v)-ord('A')
            continue
        s_hash = s_hash * base + ord(v)-ord('A')
        if s_hash == p_hash:
            return j - len(txt)+1
        s_hash = s_hash - (ord(pat[j-len(txt)+1]) - ord('A')) * base ** (len(txt) - 1)
    return -1


def read_graph(file_name):
    with open(file_name, 'r') as file:

        lines = file.readlines()
        graph = []

        for line in lines:
            costs = line.split(' ')
            row = []
            for cost in costs:
                row.append(int(cost))
            graph.append(row)
        return graph


def plot_times_line_graph(dict_sorts):
    for sort in dict_sorts:
        x = dict_sorts[sort].keys()
        y = dict_sorts[sort].values()
        plt.plot(x, y, label=sort)
    plt.legend()
    plt.title("Run Time of Sort Algorithms")
    plt.xlabel("Number of Elements")
    plt.ylabel("Time for 100 Trials")
    plt.savefig("sort_graph.png")
    plt.show()


def plot_times_bar_graph(dict_sorts, sizes, sorts):
    sort_num = 0
    plt.xticks([j for j in range(len(sizes))], [str(size) for size in sizes])

    for sort in sorts:
        sort_num += 1
        d = dict_sorts[sort.__name__]
        x_axis = [j + 0.05 * sort_num for j in range(len(sizes))]
        y_axis = [d[i] for i in sizes]
        plt.bar(x_axis, y_axis, 0.05, alpha=0.25, label=sort.__name__)
    plt.legend()
    plt.title("Run Time of sort Algorithms")
    plt.xlabel("Number of Elements")
    plt.ylabel("Time for 100 Trials")
    plt.savefig("sort_graph.png")
    plt.show()


def main():

    dict_searches = {}
    searches = [native_search, brute_force_search, kmp_search, rabin_karp_search]

    trials = 500
    sizes = [10, 100, 200, 300, 400, 500]
    for search in searches:
        dict_searches[search.__name__] = {}
    for size in sizes:
        for search in searches:
            dict_searches[search.__name__][size] = 0
        for trial in range(1, trials):
            txt = random_txt(size)
            pat = random_pattern(len(txt), txt)
            for search in searches:
                start_time = time.time()
                search(pat, txt)
                end_time = time.time()
                net_time = end_time - start_time
                dict_searches[search.__name__][size] +=1000 * net_time

    pd.set_option('display.max_rows', 500)
    pd.set_option('display.max_columns', 500)
    pd.set_option('display.width', 1000)
    df = pd.DataFrame.from_dict(dict_searches).T
    print(df)
    # plot_times_line_graph(dict_searches)
    plot_times_bar_graph(dict_searches, sizes, searches)

    #plot_times_bar_graph(dict_searches, 20, searches)


if __name__ == '__main__':
    main()