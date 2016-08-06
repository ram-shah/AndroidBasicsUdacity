package com.example.android.sanfrancisco;

/**
 * Created by ramshah on 7/27/16.
 */
public class Place {
    private String mName;
    private String mAddress;
    private String mPhone;
    private String mHours;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private boolean hasPhone = true;
    private boolean hasHours = true;

    public Place(String name, String address) {
        this.mName = name;
        this.mAddress = address;
        hasPhone = false;
        hasHours = false;
    }

    public Place(String name, String address, String phone, String hours) {
        this.mName = name;
        this.mAddress = address;
        this.mPhone = phone;
        this.mHours = hours;
    }

    public Place(String name, String address, int imageResourceId) {
        this.mName = name;
        this.mAddress = address;
        hasPhone = false;
        hasHours = false;
        this.mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getHours() {
        return mHours;
    }

    public boolean hasPhone() {
        return hasPhone;
    }

    public boolean hasHours() {
        return hasHours;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this place
     * @return true if the place has image; false otherwise
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
