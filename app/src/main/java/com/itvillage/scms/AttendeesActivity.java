package com.itvillage.scms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AttendeesActivity extends AppCompatActivity {

    private  TableLayout detailsTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendees);
        detailsTable = (TableLayout) findViewById(R.id.activity_tableLayout_attandee);


        TableRow tr1= AddOneStudentAttendeeRowInTable("Moniruzzaman Roni");
        TableRow tr2= AddOneStudentAttendeeRowInTable("Rassel Alom");

        detailsTable.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        detailsTable.addView(tr2, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    private TableRow AddOneStudentAttendeeRowInTable(String StudentName) {
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        int i;
        TextView b = new TextView(this);
        b.setText(StudentName);
        b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tr.addView(b);
        for( i = 0; i<=30; i++) {
            CheckBox checkBox = new CheckBox(this);
            tr.addView(checkBox);

            int finalI = i+1;
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(""+ finalI,StudentName);
                }
            });

        }
        return tr;
    }
}