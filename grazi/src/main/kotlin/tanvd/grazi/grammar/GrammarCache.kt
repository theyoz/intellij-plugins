package tanvd.grazi.grammar

import com.github.benmanes.caffeine.cache.Caffeine
import com.github.benmanes.caffeine.cache.LoadingCache

object GrammarCache {
    private val cache: LoadingCache<Int, LinkedHashSet<Typo>> = Caffeine.newBuilder()
            .maximumSize(50_000)
            .build { null }

    fun contains(str: String) = cache.getIfPresent(str.hashCode()) != null

    fun get(str: String) = cache.getIfPresent(str.hashCode()) ?: LinkedHashSet()

    fun put(str: String, typos: LinkedHashSet<Typo>) {
        cache.put(str.hashCode(), typos)
    }

    fun invalidate(str: String) {
        cache.invalidate(str.hashCode())
    }

    fun reset() {
        cache.invalidateAll()
    }
}