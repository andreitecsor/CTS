package assignments.no3.proxy;

import assignments.no3.proxy.exception.UploadFailedException;

public class ProxyPictureUpload implements PictureUpload {
    private PictureUpload profilePicture;

    private static final Integer MAX_SIZE = 25_000_000;

    public ProxyPictureUpload(PictureUpload profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public boolean upload() {
        if (this.profilePicture == null) {
            throw new UploadFailedException("No picture found");
        }
        if (this.profilePicture.getSize() > MAX_SIZE) {
            throw new UploadFailedException("Maximum size for a picture is 25MB");
        }
        return this.profilePicture.upload();
    }

    @Override
    public void show() {
        if (this.upload()) {
            this.profilePicture.show();
        } else {
            throw new UploadFailedException("Upload failed");
        }

    }

    @Override
    public Double getSize() {
        return this.profilePicture.getSize();
    }
}
