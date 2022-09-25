#include<stdio.h>
#include<time.h>
#include<stdlib.h>


int main(void)
{
    int count = 0, i;
    srand(time(NULL));  // Seed ONCE
    int arr[2000];

    for(i=0; i<2000; ++i) // Loop 100 times for random numbers
    {   
        arr[i] = i;
        printf("%d\n", arr[i]);
        ++count;
    }
    printf("\n \n %d ints generated \n \n", count);
}

