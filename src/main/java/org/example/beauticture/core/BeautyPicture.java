package org.example.beauticture.core;

public abstract class BeautyPicture {

    private BeautyPictureWorker worker;

    public BeautyPicture(BeautyPictureWorker worker) {
        this.worker = worker;
    }

    public BeautyPictureWorker getWorker() {
        return worker;
    }

    public abstract byte[] build();
}
