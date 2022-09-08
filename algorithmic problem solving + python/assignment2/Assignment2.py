# Analysis of Algorithms - CSCI 323 15W
# Assignment 2
# Kyunghoon Oh 23779321


import math
import random
import time
import pandas as pd
import matplotlib.pyplot as plt


def random_list(max_int, size, do_sort=False):
    arr = [random.randint(1, max_int) for i in range(size)]
    if do_sort:
        arr.sort()
    return arr


def native_sort(arr):
    return arr.sort()


def bubble_sort(arr):
    n = len(arr)
    # Traverse through all array elements
    for i in range(n):
        # Last i elements are already in place
        for j in range(0, n-i-1):
            # traverse the array from 0 to n-i-1
            # Swap if the element found is greater
            # than the next element
            if arr[j] > arr[j+1] :
                arr[j], arr[j+1] = arr[j+1], arr[j]


# https://www.geeksforgeeks.org/selection-sort/
def selection_sort(arr):
    # Traverse through all array elements
    for i in range(len(arr)):

        # Find the minimum element in remaining
        # unsorted array
        min_idx = i
        for j in range(i+1, len(arr)):
            if arr[min_idx] > arr[j]:
                min_idx = j

        # Swap the found minimum element with
        # the first element
        arr[i], arr[min_idx] = arr[min_idx], arr[i]


# Python program for implementation of Insertion Sort
# Function to do insertion sort
def insertion_sort(arr):
    # Traverse through 1 to len(arr)
    for i in range(1, len(arr)):
        key = arr[i]
        # Move elements of arr[0..i-1], that are
        # greater than key, to one position ahead
        # of their current position
        j = i-1
        while j >= 0 and key < arr[j] :
                arr[j + 1] = arr[j]
                j -= 1
        arr[j + 1] = key


def cocktail_sort(arr):
    n = len(arr)
    swapped = True
    start = 0
    end = n - 1
    while (swapped == True):

        # reset the swapped flag on entering the loop,
        # because it might be true from a previous
        # iteration.
        swapped = False

        # loop from left to right same as the bubble
        # sort
        for i in range(start, end):
            if (arr[i] > arr[i + 1]):
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swapped = True

        # if nothing moved, then array is sorted.
        if (swapped == False):
            break

        # otherwise, reset the swapped flag so that it
        # can be used in the next stage
        swapped = False

        # move the end point back by one, because
        # item at the end is in its rightful spot
        end = end - 1

        # from right to left, doing the same
        # comparison as in the previous stage
        for i in range(end - 1, start - 1, -1):
            if (arr[i] > arr[i + 1]):
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swapped = True

        # increase the starting point, because
        # the last stage would have moved the next
        # smallest number to its rightful spot.
        start = start + 1


def shell_sort(arr):
    gap = len(arr) // 2  # initialize the gap

    while gap > 0:
        i = 0
        j = gap

        # check the array in from left to right
        # till the last possible index of j
        while j < len(arr):

            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]

            i += 1
            j += 1

            # now, we look back from ith index to the left
            # we swap the values which are not in the right order.
            k = i
            while k - gap > -1:

                if arr[k - gap] > arr[k]:
                    arr[k - gap], arr[k] = arr[k], arr[k - gap]
                k -= 1

        gap //= 2


# Python program for implementation of MergeSort
def merge_sort(arr):
    if len(arr) > 1:

        # Finding the mid of the array
        mid = len(arr)//2

        # Dividing the array elements
        L = arr[:mid]

        # into 2 halves
        R = arr[mid:]

        # Sorting the first half
        merge_sort(L)

        # Sorting the second half
        merge_sort(R)

        i = j = k = 0

        # Copy data to temp arrays L[] and R[]
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        # Checking if any element was left
        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1

        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1


# https://www.geeksforgeeks.org/quick-sort/
def partition(start, end, array):

    # Initializing pivot's index to start
    pivot_index = start
    pivot = array[pivot_index]

    # This loop runs till start pointer crosses
    # end pointer, and when it does we swap the
    # pivot with element on end pointer
    while start < end:

        # Increment the start pointer till it finds an
        # element greater than  pivot
        while start < len(array) and array[start] <= pivot:
            start += 1

        # Decrement the end pointer till it finds an
        # element less than pivot
        while array[end] > pivot:
            end -= 1

        # If start and end have not crossed each other,
        # swap the numbers on start and end
        if start < end:
            array[start], array[end] = array[end], array[start]

    # Swap pivot element with element on end pointer.
    # This puts pivot on its correct sorted place.
    array[end], array[pivot_index] = array[pivot_index], array[end]

    # Returning end pointer to divide the array into 2
    return end


def quick_sort_real(start, end, array):

    if start < end:

        p = partition(start, end, array)

        quick_sort_real(start, p - 1, array)
        quick_sort_real(p + 1, end, array)


def quick_sort(arr):
    quick_sort_real(0, len(arr) - 1, arr)

# Python program for implementation of heap Sort
# To heapify subtree rooted at index i.
# n is size of heap


def heapify(arr, n, i):
    largest = i  # Initialize largest as root
    l = 2 * i + 1     # left = 2*i + 1
    r = 2 * i + 2     # right = 2*i + 2

    # See if left child of root exists and is
    # greater than root
    if l < n and arr[largest] < arr[l]:
        largest = l

    # See if right child of root exists and is
    # greater than root
    if r < n and arr[largest] < arr[r]:
        largest = r

    # Change root, if needed
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # swap

        # Heapify the root.
        heapify(arr, n, largest)

# The main function to sort an array of given size


def heap_sort(arr):
    n = len(arr)

    # Build a maxheap.
    for i in range(n//2 - 1, -1, -1):
        heapify(arr, n, i)

    # One by one extract elements
    for i in range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # swap
        heapify(arr, i, 0)


def count_sort(arr):
    max_element = int(max(arr))
    min_element = int(min(arr))
    range_of_elements = max_element - min_element + 1
    # Create a count array to store count of individual
    # elements and initialize count array as 0
    count_arr = [0 for _ in range(range_of_elements)]
    output_arr = [0 for _ in range(len(arr))]
    # Store count of each character
    for i in range(0, len(arr)):
        count_arr[arr[i] - min_element] += 1
    # Change count_arr[i] so that count_arr[i] now contains actual position of this element in output array
    for i in range(1, len(count_arr)):
        count_arr[i] += count_arr[i - 1]
        # Build the output character array
    for i in range(len(arr) - 1, -1, -1):
        output_arr[count_arr[arr[i] - min_element] - 1] = arr[i]
        count_arr[arr[i] - min_element] -= 1
        # Copy the output array to arr, so that arr now contains sorted characters
    for i in range(0, len(arr)):
        arr[i] = output_arr[i]
    return arr


# Bucket Sort in Python


def bucket_sort(array):
    largest = max(array)
    length = len(array)
    size = largest / length

    # Create Buckets
    buckets = [[] for i in range(length)]

    # Bucket Sorting
    for i in range(length):
        index = int(array[i] / size)
        if index != length:
            buckets[index].append(array[i])
        else:
            buckets[length - 1].append(array[i])

    # Sorting Individual Buckets
    for i in range(len(array)):
        buckets[i] = sorted(buckets[i])


# Python program for implementation of Radix Sort
# A function to do counting sort of arr[] according to
# the digit represented by exp.

def countingSort(arr, exp1):
    n = len(arr)

    # The output array elements that will have sorted arr
    output = [0] * (n)

    # initialize count array as 0
    count = [0] * (10)

    # Store count of occurrences in count[]
    for i in range(0, n):
        index = arr[i] // exp1
        count[index % 10] += 1

    # Change count[i] so that count[i] now contains actual
    # position of this digit in output array
    for i in range(1, 10):
        count[i] += count[i - 1]

    # Build the output array
    i = n - 1
    while i >= 0:
        index = arr[i] // exp1
        output[count[index % 10] - 1] = arr[i]
        count[index % 10] -= 1
        i -= 1

    # Copying the output array to arr[],
    # so that arr now contains sorted numbers
    i = 0
    for i in range(0, len(arr)):
        arr[i] = output[i]


# Method to do Radix Sort
def radix_sort(arr):
    # Find the maximum number to know number of digits
    max1 = max(arr)

    # Do counting sort for every digit. Note that instead
    # of passing digit number, exp is passed. exp is 10^i
    # where i is current digit number
    exp = 1
    while max1 / exp > 1:
        countingSort(arr, exp)
        exp *= 10


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
    max_int = 100
    trials = 10
    dict_sorts = {}
    sorts = [native_sort, bubble_sort, selection_sort, insertion_sort, cocktail_sort, shell_sort, merge_sort,
             quick_sort, heap_sort, count_sort, bucket_sort, radix_sort]
    for sort in sorts:
        dict_sorts[sort.__name__] = {}
    sizes = [10, 100, 200, 300, 400, 500, 1000]
    for size in sizes:
        for sort in sorts:
            dict_sorts[sort.__name__][size] = 0
        for trial in range(1, trials):
            arr = random_list(max_int, size)
            temp = arr.copy()

            for sort in sorts:
                start_time = time.time()
                idx2 = sort(temp)
                end_time = time.time()
                net_time = end_time - start_time
                dict_sorts[sort.__name__][size] += net_time * 1000
                # print(search.__name__, search(arr, key), "in time", net_time)
                # error check
                # if idx2 != idx:
                # print("Error in search", search.__name__, idx, idx2)
    # print(dict_searches)
    # print("{:<20} {:<20}".format('Search', 'Time'))
    # for n, t in dict_searches.items():
    # print("{:<20} {:<20}".format(n, round(1000 * t/trials, 4)))
    pd.set_option('display.max_rows', 500)
    pd.set_option('display.max_columns', 500)
    pd.set_option('display.width', 1000)
    df = pd.DataFrame.from_dict(dict_sorts).T
    print(df)
    # plot_times_line_graph(dict_searches)
    plot_times_bar_graph(dict_sorts, sizes, sorts)


if __name__ == '__main__':
    main()
