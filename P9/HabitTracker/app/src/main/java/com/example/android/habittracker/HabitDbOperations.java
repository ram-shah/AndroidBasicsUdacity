package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.android.habittracker.data.HabitContract.HabitEntry;
import com.example.android.habittracker.data.HabitDbHelper;

/**
 * Created by ramshah on 8/28/16.
 */
public class HabitDbOperations {

    public static final String LOG_TAG = HabitDbOperations.class.getSimpleName();

    private Context mContext;

    /** Database helper that will provide us access to the database */
    private HabitDbHelper mDbHelper;

    public HabitDbOperations(Context context) {
        mContext = context;
        mDbHelper = new HabitDbHelper(mContext);
    }

    /**
     * Save new habit into database.
     */
    public long insert(String name, int time, int frequency) {

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and habit attributes are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, name);
        values.put(HabitEntry.COLUMN_HABIT_TIME, time);
        values.put(HabitEntry.COLUMN_HABIT_FREQUENCY, frequency);

        // Insert a new row for habit in the database, returning the ID of that new row.
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        // check whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Log.e(LOG_TAG, "Error with saving habit");
        } else {
            // Otherwise, the insertion was successful
            Log.d(LOG_TAG, "Habit saved with row id: " + newRowId);
        }

        return newRowId;
    }

    /**
     * Query database for habit name and frequency.
     */
    public Cursor read() {

        // Gets the database in read mode
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_FREQUENCY };

        // Perform a query on the habit table
        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

        return cursor;
    }

    /**
     * delete all rows in the database table.
     */
    public void delete() {

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.delete(HabitEntry.TABLE_NAME, null, null);
    }

    /**
     * update frequency of the first row with _ID=1.
     */
    public int update(int frequency) {

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_FREQUENCY, frequency);

        // Which row to update, based on the _ID = 1
        String selection = HabitEntry._ID + " = ?";
        String[] selectionArgs = { "1" };

        int count = db.update(
                HabitEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return count;
    }
}
