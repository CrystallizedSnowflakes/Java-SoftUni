import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{

    private Map<Integer, Transaction> transactionsById;

    public ChainblockImpl(){
        this.transactionsById = new HashMap<>();
    }

    public int getCount() {
        return this.transactionsById.size();
    }

    public void add(Transaction transaction) {
        int id = transaction.getId();
        if (!this.contains(id))
        this.transactionsById.put(id, transaction);
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactionsById.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!transactionsById.containsKey(id)){
            throw new IllegalArgumentException();
        }
        this.transactionsById.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!contains(id)){
            throw new IllegalArgumentException();
        }
        this.transactionsById.remove(id);
    }

    public Transaction getById(int id) {
        if (!contains(id)){
            throw new IllegalArgumentException();
        }
        return this.transactionsById.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : transactionsById.values()) {
            if (transaction.getStatus() == status){
                transactionList.add(transaction);
            }
        }

        if (transactionList.size() == 0){
            throw new IllegalArgumentException();
        }

        transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return transactionList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();
        getByTransactionStatus(status).forEach(transactionList::add); // add all by status
        return transactionList.stream()
                .map(Transaction::getFrom) // get all Senders
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();
        getByTransactionStatus(status).forEach(transactionList::add); // add all by status
        return transactionList.stream()
                .map(Transaction::getTo) // get all Receivers
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionsById.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : transactionsById.values()) {
            if (transaction.getFrom().equals(sender)){
                transactionList.add(transaction);
            }
        }
        if (transactionsById.size() == 0){
            throw new IllegalArgumentException();
        }
        return transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : transactionsById.values()) {
            if (transaction.getTo().equals(receiver)){
                transactionList.add(transaction);
            }
        }
        if (transactionsById.size() == 0){
            throw new IllegalArgumentException();
        }
        return transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount)
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
