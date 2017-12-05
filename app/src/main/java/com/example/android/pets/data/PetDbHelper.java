package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Seeyon on 2017-12-1.
 */

public class PetDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pets.db";
    private static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + "("
            + PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PetContract.PetEntry.COLUMN_NAME + " TEXT NOT NULL, "
            + PetContract.PetEntry.COLUMN_BREED + " TEXT, "
            + PetContract.PetEntry.COLUMN_GENDER + " INTEGER NOT NULL, "
            + PetContract.PetEntry.COLUMN_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetContract.PetEntry.TABLE_NAME;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
