package io.quarkus.hazelcast.client.runtime.graal;

import com.hazelcast.cache.impl.JCacheDetector;
import com.hazelcast.logging.ILogger;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

/**
 * JCache is not supported under GraalVM but the redundant JCache detection infrastructure is still present
 */
@TargetClass(JCacheDetector.class)
public final class Target_JCacheDetector {

    @Substitute
    public static boolean isJCacheAvailable(ClassLoader classLoader) {
        return false;
    }

    @Substitute
    public static boolean isJCacheAvailable(ClassLoader classLoader, ILogger logger) {
        return false;
    }
}
