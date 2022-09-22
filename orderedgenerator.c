#include<stdio.h>
#include<time.h>
#include<stdlib.h>


int main(void)
{
    int num, i;
    srand(time(NULL));  // Seed ONCE
    int arr[2000];

    for(i=0; i<2000; ++i) // Loop 100 times for random numbers
    {   
        arr[i] = i;
        printf("%d  ", arr[i]);
    }
}

