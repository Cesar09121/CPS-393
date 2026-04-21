## 1.

### a.

5050

### b.

5050

## 2.

### a.

Final count: 10000 (always)

### b.

Final count: 10000 (always but sequential)

### c.

Final count: 3041 (unpredictable since there's no join)

### d.

Final count: 8327 (<10000 since synchronized is removed)

## 3.

### Two-Thread

        /*
    	 * with n=100
    	 * Double thread sum = 339648
    	 * Double thread time = 431500 ns.
    	 */

    	/*
    	 * with n =100000
    	 * Double thread sum = 338225906
    	 * Double thread time = 2813900 ns.
    	 */
    	/*
    	 * with n=100000000
    	 * Double thread sum = 338366666910
    	 * Double thread time = 32345200 ns.
    	 */

### Single-Thread

         /*
    	 * with n =100
    	 * Single thread sum = 314300
    	 * Single thread time = 2000 ns.
    	 */

    	/*
    	 * with n =100000
    	 * Single thread sum = 339073782
    	 * Single thread time = 170700 ns.
    	 */

    	/*
    	 * with n =100000000
    	 * Single thread sum = 338348268025
    	 * Single thread time = 34501000 ns.
    	 */

### Conclusion:

With the larger n, two-thread runs faster than the single-thread because two-thread splits task so the runtime will be optimized.
