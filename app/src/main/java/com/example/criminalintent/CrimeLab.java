package com.example.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setmTitle("Crime #:" + i);
            crime.setmSolved(i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getcrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        return searchList(mCrimes, id);
    }

    private Crime searchList(List<Crime> listSplit, UUID id){
        if(listSplit.size() == 0){
            return null;
        }
        //look at mid point
        if(listSplit.get(listSplit.size()/2).getmId() == id){
            return listSplit.get(listSplit.size()/2);
        } else {
            Crime toReturn;
            if((toReturn = searchList(listSplit.subList(0, listSplit.size()/2), id)) != null){
                return toReturn;
            }else if ((toReturn = searchList(listSplit.subList(clamp(listSplit.size()/2 + 1, 0, listSplit.size()), listSplit.size()), id)) != null){
                return toReturn;
            } else {
                return null;
            }
        }
    }

    private int clamp(int x, int min, int max){
        if(x < min){
            return min;
        } else if (x > max){
            return max;
        } else {
            return x;
        }
    }
}
