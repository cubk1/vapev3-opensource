package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class DefaultVertexFormats extends Wrapper {
    public DefaultVertexFormats(Object object) {
        super(object);
    }

    public static Object POSITION(){
        return vape.getMappings().defaultVertexFormats.POSITION;
    }
}
