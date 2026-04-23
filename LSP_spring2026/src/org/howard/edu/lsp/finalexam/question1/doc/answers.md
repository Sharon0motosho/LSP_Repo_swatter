Part 1:
Shared Resource #1: nextId (shared counter across threads)

Shared Resource #2: requests list (ArrayList is not thread-safe)

Concurrency Problem: Race condition (multiple threads accessing/modifying shared data simultaneously)

Why addRequest() is unsafe:

getNextId() is not synchronized → multiple threads can get the same ID
requests.add() is not thread-safe → concurrent modification can corrupt the list
The entire sequence (get ID + add request) is not atomic



Part 2:

Fix A: Not correct
Synchronizing getNextId() ensures unique IDs
BUT requests.add() is still not thread-safe
The full operation is still not atomic → race condition remains

Fix B: Correct
Synchronizing addRequest() ensures:
Only one thread executes the entire method at a time
ID generation + list insertion happen atomically
Prevents both duplicate IDs and list corruption

Fix C: Not correct
Synchronizing getRequests() only protects reading the list
Does NOT protect writes (addRequest())
Race condition still exists


Part 3:
Answer + Explanation:
getNextId() should NOT be public
According to Riel’s heuristics (information hiding):
Internal implementation details should be hidden
ID generation is an internal responsibility of RequestManager
Making it public allows misuse (external classes generating IDs incorrectly)
It should be private to maintain encapsulation and control


Part 4:

Description:
Use explicit locking (ReentrantLock) instead of synchronized
A lock ensures only one thread executes the critical section
Provides more control (lock/unlock, fairness, tryLock, etc.)
Protects both ID generation and list modification


Code Snippet:

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RequestManager {
    private int nextId = 1;
    private List<String> requests = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addRequest(String studentName) {
        lock.lock();
        try {
            int id = nextId++;
            String request = "Request-" + id + " from " + studentName;
            requests.add(request);
        } finally {
            lock.unlock();
        }
    }
}