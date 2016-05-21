package com.example.swachh_bharat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class LoginDataBaseAdapter 
{
            static final String DATABASE_NAME = "swachh_bharat.db";
      
            static final int DATABASE_VERSION = 1;

            public static final int NAME_COLUMN = 1;
            // TODO: Create public field for each column in your table.
            // SQL Statement to create a new database.
            static final String DATABASE_CREATE = "create table "+"compliant_info"+
                                         "( " +"compliant_no"+" integer primary key autoincrement,"+ "comp_loc  text,comp_cause text,Name  text,Number text,location text,pin text); ";
                                         
            // Variable to hold the database instance
            public  SQLiteDatabase db;
            // Context of the application using the database.
            private final Context context;
            // Database open/upgrade helper
            private DataBaseHelper dbHelper;
            public  LoginDataBaseAdapter(Context _context) 
            {
                    context = _context;
                    dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

             // Method to openthe Database  
            public  LoginDataBaseAdapter open() throws SQLException 
            {
                    db = dbHelper.getWritableDatabase();
                    return this;
            }
         
            // Method to close the Database  
            public void close() 
            {
                    db.close();
            }
  
             // method returns an Instance of the Database 
            public  SQLiteDatabase getDatabaseInstance()
            {
                    return db;
            }
    
              // method to insert a record in Table
            public void insertEntry(String comp_location,String cause,String Name,String phone,String user_location,String pin_code)
            {
                       
                     
                       ContentValues newValues = new ContentValues();
                        // Assign values for each column.
                       // newValues.put("compliant_no", comp_location);
                        newValues.put("comp_loc",comp_location);
                        newValues.put("comp_cause", cause);
                        newValues.put("Name",Name);
                        newValues.put("Number", phone);
                        newValues.put("location",user_location);
                        newValues.put("pin",pin_code);
                       
                       
                       
                       
                        // Insert the row into your table
                        db.insert("compliant_info", null, newValues);
                        Toast.makeText(context, "complaint  Info Saved", Toast.LENGTH_LONG).show();
           
       
            }
           
           // method to delete a Record of UserName
            public int deleteEntry(String UserName)
            {
                     
                   String where="USERNAME=?";
                   int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
                   Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
                return numberOFEntriesDeleted;
               
            }
       
       // method to get the password  of userName
        public String getSinlgeEntry(String userName)
        {
           
               
                Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
                if(cursor.getCount()<1) // UserName Not Exist
                    return "NOT EXIST";
                cursor.moveToFirst();
                String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
                return password;
               
           
        }

     // Method to Update an Existing Record 
    /*   public void  updateEntry(String userName,String password)
        {
                //  create object of ContentValues
                ContentValues updatedValues = new ContentValues();
                // Assign values for each Column.
                updatedValues.put("USERNAME", userName);
                updatedValues.put("PASSWORD",password);
               
                String where="USERNAME = ?";
                db.update("LOGIN",updatedValues, where, new String[]{userName});
              
        }  */
       
       
}