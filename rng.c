nt main(void)
{
    int num, i;
    srand(time(NULL));  // Seed ONCE

    for(i=0; i<100; ++i) // Loop 100 times for random numbers
    {
        num = rand();
        printf("%d\n", num);
}
}

