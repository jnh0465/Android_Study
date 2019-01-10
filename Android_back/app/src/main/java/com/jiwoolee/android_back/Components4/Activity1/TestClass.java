package com.jiwoolee.android_back.Components4.Activity1;

import android.os.Parcel;
import android.os.Parcelable;

public class TestClass implements Parcelable {
    int data10;
    String data20;

    public static final Creator<TestClass> CREATOR = new Creator<TestClass>() {
        // 객체 복원
        @Override
        public TestClass createFromParcel(Parcel source) {
            TestClass t1 = new TestClass();
            t1.data10 = source.readInt();
            t1.data20 = source.readString();

            return t1;
        }

        @Override
        public TestClass[] newArray(int size) {
            return new TestClass[size];
        }
    };

    // 객체를 Intent에 담을때 자동으로 호출되는 메서드
    // 첫 번째 매개 변수로 들어는 Parcel 객체에 객체 복원을 위해 필요한 정보를
    // 담는다.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(data10);
        dest.writeString(data20);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
