package tecsor.andrei.g1087.proxy;

public class ProfilePicture implements PictureUpload {
    private String path;
    private Double size;

    public ProfilePicture(String path, Double size) {
        if (path == null || path.isEmpty() || size <= 0) {
            throw new IllegalArgumentException("Invalid path or size");
        }
        this.path = path;
        this.size = size;
    }

    @Override
    public Double getSize() {
        return this.size;
    }

    @Override
    public boolean upload() {
        String localPath = this.path;
        this.path = GoogleAPI.uploadToCloud(path);
        return !this.path.equals(localPath);
    }

    @Override
    public void show() {
        System.out.println(this.path + "[ " + this.size / 1_000_000 + " MB]This is the user's cool profile picture.");

    }
}
