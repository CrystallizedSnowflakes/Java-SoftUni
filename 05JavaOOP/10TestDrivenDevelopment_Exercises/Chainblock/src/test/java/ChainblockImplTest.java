import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private Chainblock chainblock;
    private List<Transaction> transactionList;

    @Before
    public void setUp(){
        this.chainblock = new ChainblockImpl();
        this.createTransactions();
    }

    // contains
    @Test
    public void testContainsByIdOnEmptyChainblock(){
        assertFalse(this.chainblock.contains(this.transactionList.get(0).getId()));
    }

    @Test
    public void testContainsReturnCorrectValueOnExistingTransaction(){
        assertFalse(this.chainblock.contains(this.transactionList.get(0)));
        this.chainblock.add(this.transactionList.get(0));
        assertTrue(this.chainblock.contains(this.transactionList.get(0)));
    }

    // add
    @Test
    public void testAddTransactionCorrectly(){
        this.chainblock.add(this.transactionList.get(0));
        assertEquals(1, chainblock.getCount());
        this.chainblock.add(this.transactionList.get(1));
        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testAddTransactionBySameIdNotToBeAdded(){
        Transaction transactionBySameId = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Ivan", "Gogo", 10);
        this.chainblock.add(this.transactionList.get(0));
        assertEquals(1, chainblock.getCount());
        this.chainblock.add(transactionBySameId); // IDs are unique
        assertEquals(1, chainblock.getCount());
    }

    // changeTransactionStatus
    @Test(expected = IllegalArgumentException.class) // if transaction does not exist
    public void testChangeTransactionStatusThrownException_WhenTransactionNotPresent(){
        this.chainblock.changeTransactionStatus(this.transactionList.get(0).getId(), TransactionStatus.FAILED);
    }

    @Test
    public void testChangeTransactionStatusCorrectly(){
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.changeTransactionStatus(this.transactionList.get(0).getId(), TransactionStatus.FAILED);
        assertEquals(TransactionStatus.FAILED, this.transactionList.get(0).getStatus());
    }

    // removeTransactionById
    @Test(expected = IllegalArgumentException.class) // if transaction does not exist
    public void testRemoveTransactionByIdThrownException_WhenTransactionNotPresent(){
        this.chainblock.removeTransactionById(this.transactionList.get(0).getId());
        fillChainBlock();
        this.chainblock.removeTransactionById(this.chainblock.getCount() + 1); // id 5
    }

    @Test
    public void testRemoveTransactionByIdCorrectly(){
        fillChainBlock();
        assertEquals(4, this.chainblock.getCount());
        this.chainblock.removeTransactionById(this.transactionList.get(0).getId());
        assertEquals(3, this.chainblock.getCount());
        assertFalse(this.chainblock.contains(this.transactionList.get(0).getId()));
    }

    // getById
    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdHasToThrowException_WhenIdNotPresent(){
        fillChainBlock();
        this.chainblock.getById(10);
    }

    @Test
    public void testGetByIdHasToReturnCorrectTransaction(){
        fillChainBlock();
        Transaction expected = this.transactionList.get(2);
        Transaction actual = this.chainblock.getById(expected.getId());
        assertEquals(expected, actual); // implement method equals() in TransactionImpl
    }

    // getByTransactionStatus
    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusHasToThrow_WhenStatusNotExist(){
        fillChainBlock();
        this.chainblock.getByTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetByTransactionStatusReturnCorrectTransactions(){
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected.size(), actual.size());

        for (Transaction transaction : actual) {
            assertEquals(TransactionStatus.SUCCESSFUL, transaction.getStatus());
        }
    }

    @Test
    public void testGetByTransactionStatusReturnCorrectTransactionsOrderedByDescendingAmount(){
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()) // OrderedByDescendingAmount
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    // getAllSendersWithTransactionStatus
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusHasToThrow_WhenStatusNotExist(){
        fillChainBlock();
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusReturnCorrectSendersInOrderByDescendingAmount(){
        fillChainBlock();
        List<String> expectedSenders = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()) // OrderedByDescendingAmount
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Iterable<String> result = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<String> actualSenders = new ArrayList<>();
        result.forEach(actualSenders::add);

        assertEquals(expectedSenders.size(), actualSenders.size());
        for (String actualSender : actualSenders) {
            assertEquals("Mario", actualSender);
        }
        assertEquals(expectedSenders, actualSenders);
    }

    //getAllReceiversWithTransactionStatus
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusHasToThrow_WhenStatusNotExist(){
        fillChainBlock();
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusReturnCorrectSendersInOrderByDescendingAmount(){
        fillChainBlock();
        List<String> expectedReceivers = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()) // OrderedByDescendingAmount
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Iterable<String> result = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<String> actualReceivers = new ArrayList<>();
        result.forEach(actualReceivers::add);

        assertEquals(expectedReceivers.size(), actualReceivers.size());
        for (String actualReceiver : actualReceivers) {
            assertEquals("Super", actualReceiver);
        }
        assertEquals(expectedReceivers, actualReceivers);
    }

    // getAllOrderedByAmountDescendingThenById
    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        fillChainBlock();
        List<Transaction> expectedTransactions = this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed() // OrderedByDescendingAmount
                .thenComparing(Transaction::getId)) // ThenById
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getAllOrderedByAmountDescendingThenById();
        assertNotNull(result);
        List<Transaction> actualTransactions = new ArrayList<>();
        result.forEach(actualTransactions::add);

        assertEquals(expectedTransactions, actualTransactions);
    }

    // getBySenderOrderedByAmountDescending
    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingHasToThrowException_WhenSenderNotPresent(){
        this.chainblock.getBySenderOrderedByAmountDescending("Koko");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingReturnTrue_WhenSenderIsPresent(){
        fillChainBlock();
        List<Transaction> expectedTransactions = this.transactionList.stream()
                .filter(transaction -> transaction.getFrom().equals("Mario"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()) // OrderedByDescendingAmount
                .collect(Collectors.toList());

        Iterable<Transaction> result = this.chainblock.getBySenderOrderedByAmountDescending("Mario");
        assertNotNull(result);
        List<Transaction> actualTransactions = new ArrayList<>();
        result.forEach(actualTransactions::add);

        assertEquals(expectedTransactions.size(), actualTransactions.size());
        double startAmount = 100;
        for (Transaction actualTransaction : actualTransactions) {
            assertEquals("Mario", actualTransaction.getFrom());
            assertEquals(startAmount - 1, actualTransaction.getAmount(), 0.01);
            startAmount -= 1;
        }
    }

    // getByReceiverOrderedByAmountThenById
    @Test(expected = IllegalArgumentException.class)
    public void testByReceiverOrderedByAmountThenByIdHasToThrowException_WhenReceiverNotPresent(){
        this.chainblock.getByReceiverOrderedByAmountThenById("Koko");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdReturnTrue_WhenSenderIsPresent(){
        fillChainBlock();
        List<Transaction> expectedTransactions = this.transactionList.stream()
                .filter(transaction -> transaction.getTo().equals("Top"))
                .sorted(Comparator.comparing(Transaction::getAmount)
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> result = this.chainblock.getByReceiverOrderedByAmountThenById("Top");
        assertNotNull(result);
        List<Transaction> actualTransactions = new ArrayList<>();
        result.forEach(actualTransactions::add);

        assertEquals(expectedTransactions.size(), actualTransactions.size());
        double startAmount = 100;
        for (Transaction actualTransaction : actualTransactions) {
            assertEquals("Top", actualTransaction.getTo());
            assertEquals(startAmount - 1, actualTransaction.getAmount(), 0.01);
            startAmount -= 1;
        }

        Transaction expected = this.transactionList.get(2);
        Transaction actual = this.chainblock.getById(expected.getId());
        assertEquals(expected, actual);
    }

    private void createTransactions() {
        this.transactionList = new ArrayList<>();
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Mario", "Super", 98);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Mario", "Super", 99);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.UNAUTHORIZED, "Pepa", "Popova", 96);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Toni", "Fun", 97);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
    }

    private void fillChainBlock(){
        for (Transaction transaction : transactionList) {
            this.chainblock.add(transaction);
        }

    }
}