package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by ramshah on 8/28/16.
 */
public final class HabitContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {}

    /**
     * Inner class that defines constant values for the habit database table.
     * Each entry in the table represents a single habit.
     */
    public static final class HabitEntry implements BaseColumns {

        /** Name of database table for habit */
        public final static String TABLE_NAME = "habit";

        /**
         * Unique ID number for the habit (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME ="name";

        /**
         * Time of the day when the habit is carried out
         *
         * The only possible values are {@link #TIME_UNKNOWN}, {@link #TIME_MORNING},
         * {@link #TIME_AFTERNOON} or {@link #TIME_EVENING}.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_HABIT_TIME = "time";

        /**
         * Number of times the habit is carried out in a week.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_HABIT_FREQUENCY = "frequency";

        /**
         * Possible values for the time when the habit is carried out.
         */
        public static final int TIME_UNKNOWN = 0;
        public static final int TIME_MORNING = 1;
        public static final int TIME_AFTERNOON = 2;
        public static final int TIME_EVENING = 3;
    }
}
