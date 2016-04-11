package be.vergauwen.simon.cleanmvp;

import android.support.annotation.NonNull;
import java.lang.reflect.Method;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

// Custom runner allows us set config in one place instead of setting it in each test class.
public class RobolectricUnitTestRunner extends RobolectricGradleTestRunner {

    // This value should be changed as soon as Robolectric will support newer api.
    private static final int SDK_EMULATE_LEVEL = 21;

    public RobolectricUnitTestRunner(@NonNull Class<?> aClass) throws Exception {
        super(aClass);
    }

    @Override
    public Config getConfig(@NonNull Method method) {
        final Config defaultConfig = super.getConfig(method);
        return new Config.Implementation(
            new int[]{SDK_EMULATE_LEVEL},
            defaultConfig.manifest(),
            defaultConfig.qualifiers(),
            defaultConfig.packageName(),
            defaultConfig.resourceDir(),
            defaultConfig.assetDir(),
            defaultConfig.shadows(),
            MVPApplication.class, // Notice that we override real application class for Unit tests.
            defaultConfig.libraries(),
            defaultConfig.constants() == Void.class ? BuildConfig.class : defaultConfig.constants()
        );
    }
}
