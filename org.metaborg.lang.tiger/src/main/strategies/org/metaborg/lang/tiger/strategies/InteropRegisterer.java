package org.metaborg.lang.tiger.strategies;

import org.metaborg.lang.framevm_core.FrameVM;
import org.strategoxt.lang.JavaInteropRegisterer;

public class InteropRegisterer extends JavaInteropRegisterer {
    public InteropRegisterer() {
        super(FrameVM.framevmExtend());
    }
}
