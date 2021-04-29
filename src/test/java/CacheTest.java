import com.simran.Cache;
import com.simran.LRUEvictionPolicy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CacheTest
{
    @Test
    public void defaultTest()
    {
        Cache<Integer,String> cache = new Cache<>(3,new LRUEvictionPolicy());
        cache.put(1, "A");
        cache.get(1);
        cache.put(2, "B");
        assertEquals("A", cache.get(1)); // Accessing 1 after 2 got inserted which makes 2 the least recently used till now.
        cache.put(3, "C");
        assertEquals("C", cache.get(3));
        cache.put(4, "D");
        assertEquals("B", cache.get(2));
        //assertEquals("A", cache.get(1));
        // Now if i try to add any element, the eviction should happen
        // Also eviction should happen based on LeastRecentlyUsedItem
        // which is 2 in this case.
        // cache.put(4, "D");

       // cache.get(2); // This should throw exception "Tried to access non-existing key."
    }
}
