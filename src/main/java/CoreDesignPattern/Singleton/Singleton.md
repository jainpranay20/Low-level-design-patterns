✅ Constructor should be private.
✅ Create a private static instance variable.
✅ Provide a public static getInstance() method.
✅ Return the same object every time.
✅ Prevent object creation using new.
✅ Use lazy initialization if object creation can be deferred.
✅ Make it thread-safe in multithreaded applications.
✅ Use Double-Checked Locking (DCL) for efficient thread safety.
✅ Mark the instance as volatile when using DCL.
✅ Synchronize only the object creation block, not the entire method (for better performance).
✅ Verify using hashCode() or == that only one instance exists.
✅ Common use cases: Logger, Configuration Manager, Cache Manager, Thread Pool Manager, Spring Singleton Beans.