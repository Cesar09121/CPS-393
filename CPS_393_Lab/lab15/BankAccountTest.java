package lab15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Starts each test with a fresh account of 100.0
        account = new BankAccount(100.0);
        
    }

    /** 1. Add an @AfterEach annotation and method to delete the current bank account to make it available for garbage collection */
    @AfterEach
   void tearDown() {
	   account =null;
   }

    @Test
    void testDeposit() {
    /** 2. Adeposit $50 and check that the balance is 150 */
    	account.deposit(50);
    	assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdraw() {
    /** 3. withdraw $40 and check that the balance is $60; remember that each test is done on a fresh instance of bank account */
    	account.withdraw(40);
    	assertEquals(60.0, account.getBalance());
    }

    @Test
    void testInvalidDeposit() {
    /** 4. Deposit a negative amount and check if an exception is thrown */
    	assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10);
        });
    }

    @Test
    void testOverdraft() {
    /** 5. Verify that Withdrawing more than the current balance
    throws an exception */

   	    assertThrows(IllegalArgumentException.class, () -> {
    	    account.withdraw(200);
    	 });
    }
    

    @Test
    void testNegativeInitialBalance() {
        /** 6. Creating account with negative balance should throw exception */
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-100);
        });
    }
    
    // Test transfer method
    @Test
    void testTransfer() {
    	BankAccount other = new BankAccount(50);
    	account.transfer(other, 30.0);
    	
    	assertEquals(70.0, account.getBalance());
        assertEquals(80.0, other.getBalance());
    	
    }
    
    // Test negative transfer amount
    @Test
    void testTransferNegativeAmount() {
        BankAccount other = new BankAccount(50.0);

        assertThrows(IllegalArgumentException.class, () -> {
            account.transfer(other, -10.0);
        });
    }
    
  
    // 2. Test values that are greater than 20
    @Test
    void testValueGreaterThan20() {
    	int [] numbers = {23,35,67,77,100};
    	for(int num : numbers) {
        	assertTrue(num>=20);
        }
    }
    
    // 3. Test if two strings contain same character
    @Test
    void testTwoString() {
    	String strOne = "abc";
    	String strTwo = "abc";
    	assertTrue(strOne.equals(strTwo));
    	//assertTrue(strOne,strTwo);
    }

    /*
     * 4. Yes, the other test methods will still be executed. 
     * JUnit runs each test independently, so even if one test fails, the remaining tests will still run.
     */
    
    	
}

