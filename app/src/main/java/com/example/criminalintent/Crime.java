package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private boolean mRequiresPolice;
    private boolean mHasChanged;

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    private String mNumber;

    public String getmSuspect() {
        return mSuspect;
    }

    public void setmSuspect(String mSuspect) {
        this.mSuspect = mSuspect;
    }

    private String mSuspect;

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public boolean requiresPolice() { return mRequiresPolice; }

    public void setmRequiresPolice(boolean tf){
        mRequiresPolice = tf;
    }

    public Crime(){
        this(UUID.randomUUID());
        mHasChanged = false;
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
    }

    public boolean ismHasChanged() {
        return mHasChanged;
    }

    public void setmHasChanged(boolean mHasChanged) {
        this.mHasChanged = mHasChanged;
    }
}
