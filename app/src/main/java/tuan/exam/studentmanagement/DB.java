package tuan.exam.studentmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import tuan.exam.studentmanagement.model.Class;
import tuan.exam.studentmanagement.model.Student;

public class DB extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "StudentManagement.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_1 = "student";
    private static final String TABLE_1_FIRST_COLUMN = "student_id";
    private static final String TABLE_1_SECOND_COLUMN = "student_name";
    private static final String TABLE_1_THIRD_COLUMN = "student_dob";
    private static final String TABLE_1_FOURTH_COLUMN = "student_town";
    private static final String TABLE_1_FIFTH_COLUMN = "student_year";

    private static final String TABLE_2 = "class";
    private static final String TABLE_2_FIRST_COLUMN = "class_id";
    private static final String TABLE_2_SECOND_COLUMN = "class_name";
    private static final String TABLE_2_THIRD_COLUMN = "class_desc";

    private static final String TABLE_3 = "student_class";
    private static final String TABLE_3_FIRST_COLUMN = "student_id";
    private static final String TABLE_3_SECOND_COLUMN = "class_id";
    private static final String TABLE_3_THIRD_COLUMN = "semester";
    private static final String TABLE_3_FOURTH_COLUMN = "number";

    public DB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStudentTable =
                "CREATE TABLE " + TABLE_1 +
                        " (" + TABLE_1_FIRST_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        TABLE_1_SECOND_COLUMN + " TEXT, " +
                        TABLE_1_THIRD_COLUMN + " TEXT, " +
                        TABLE_1_FOURTH_COLUMN + " TEXT, " +
                        TABLE_1_FIFTH_COLUMN + " TEXT);";

        String createClassTable =
                "CREATE TABLE " + TABLE_2 +
                        " (" + TABLE_2_FIRST_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        TABLE_2_SECOND_COLUMN + " TEXT, " +
                        TABLE_2_THIRD_COLUMN + " TEXT);";

        String createStudentClassTable =
                "CREATE TABLE " + TABLE_3 +
                        " (" + TABLE_3_FIRST_COLUMN + " INTEGER, " +
                        TABLE_3_SECOND_COLUMN + " INTEGER, " +
                        TABLE_3_THIRD_COLUMN + " TEXT, " +
                        TABLE_3_FOURTH_COLUMN + " INTEGER);";

        db.execSQL(createStudentTable);
        db.execSQL(createClassTable);
        db.execSQL(createStudentClassTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_3);
        onCreate(db);
    }

    public void addStudent(Student newStudent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TABLE_1_SECOND_COLUMN, newStudent.getName());
        cv.put(TABLE_1_THIRD_COLUMN, newStudent.getDob());
        cv.put(TABLE_1_FOURTH_COLUMN, newStudent.getTown());
        cv.put(TABLE_1_FIFTH_COLUMN, newStudent.getYear());

        long result = db.insert(TABLE_1, null, cv);

        if (result == -1) {
            // fail
            Toast.makeText(context, "Fail to add", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Add success", Toast.LENGTH_SHORT).show();
        }
    }

    public void addClass(Class newClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TABLE_2_SECOND_COLUMN, newClass.getName());
        cv.put(TABLE_2_THIRD_COLUMN, newClass.getDesc());

        long result = db.insert(TABLE_2, null, cv);

        if (result == -1) {
            // fail
            Toast.makeText(context, "Fail to add", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Add success", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllStudents() {
        String query = "SELECT * FROM " + TABLE_1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public Cursor readAllClasses() {
        String query = "SELECT * FROM " + TABLE_2;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public Cursor readStat() {
        String name ="Tien";
        String year = "Nam tu";
        String query = "SELECT * FROM " + TABLE_1 + " WHERE student_name=? AND student_year=?";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, new String[] {name, year});
        }
        return cursor;
    }
}
