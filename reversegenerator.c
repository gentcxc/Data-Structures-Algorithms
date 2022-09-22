#include<stdio.h>
#include<time.h>
#include<stdlib.h>


int main(void)
{
    int num = 0, i;
    srand(time(NULL));  // Seed ONCE
    int arr[2000];

    for(i=1999; i>=0; --i) 
    {   
        arr[i] = i;
        printf("%d  ", arr[i]);
        ++num;
    }
    printf("counter = %d \n", num);
}

