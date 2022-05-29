package org.example.beauticture.core;

public class ClassicBeautyPicture extends BeautyPicture {

    public ClassicBeautyPicture(BeautyPictureWorker worker) {
        super(worker);
    }

    @Override
    public byte[] build() {
        return getWorker().build();
    }
}
